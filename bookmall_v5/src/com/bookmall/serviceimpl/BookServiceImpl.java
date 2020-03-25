package com.bookmall.serviceimpl;

import com.bookmall.bean.*;
import com.bookmall.dao.AuthorDao;
import com.bookmall.dao.BookDao;
import com.bookmall.dao.PublisherDao;
import com.bookmall.dao.Relationship4Book2AuthorDao;
import com.bookmall.daoimpl.AuthorDaoImpl;
import com.bookmall.daoimpl.BookDaoImpl;
import com.bookmall.daoimpl.PublisherDaoImpl;
import com.bookmall.daoimpl.Relationship4Book2AuthorDaoImpl;
import com.bookmall.service.BookService;
import com.bookmall.service.Relationship4Book2AuthorService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;
    private AuthorDao authorDao;
    private Relationship4Book2AuthorDao relDao;
    private PublisherDao publisherDao;
    private Relationship4Book2AuthorService relService = new Relationship4Book2AuthorServiceImpl();

    // 构造器
    public BookServiceImpl() {
        super();
        bookDao = new BookDaoImpl();
        authorDao = new AuthorDaoImpl();
        relDao = new Relationship4Book2AuthorDaoImpl();
        publisherDao = new PublisherDaoImpl();
    }

    // 方法

    /**
     * 添加图书
     *
     * @param book
     */
    @Override
    public void addBook(Book book) {
        if (!isValidBook(book)) {
            return;
        }
        // t_book表中插入图书记录，并获取插入数据时的id列的值(这点很重要，因为新增book时，从客户端传过来的数据是无法指定book id的)
        Integer bookId = bookDao.saveBook(book);
        book.setId(bookId);
        // 插入图书与作者的关联记录
        relService.addRelationshipBook2Authors(book);
    }

    /**
     * 删除指定ID的图书
     *
     * @param id
     */
    @Override
    public void deleteBookById(int id) {
        // 1. 删除图书与作者的关联记录
        relDao.deleteRelationship4Book2AuthorByBookId(id);
        // 2. 删除图书
        bookDao.deleteBookById(id);
    }

    /**
     * 更新图书信息
     *
     * @param book
     */
    @Override
    public void updateBook(Book book) {
        if (book == null || book.getId() == null) {
            return;
        }
        // 1. 更新图书基本信息
        bookDao.updateBook(book);
        // 2. 更新图书与作者的关联记录
        // 未更新前，图书的作者
        List<Author> authors = queryAuthorsByBookId(book.getId());
        List<Author> newAuthors = book.getAuthors();
        // 需要去除与本书关联的作者：authors - newAuthors
        if (authors != null && authors.size() > 0) {
            Set<Author> removeSet = new HashSet<>(authors);
            // Set<Author> removeSet = new HashSet<>();
            // removeSet.addAll(authors);
            if (newAuthors != null) {
                removeSet.removeAll(newAuthors);
            }
            for (Author author : removeSet) {
                relDao.deleteRelationship4Book2AuthorByBookIdAndAuthorId(book.getId(), author.getId());
            }
        }
        // 需要新增与本书关联的作者：newAuthors - authors
        if (newAuthors != null && newAuthors.size() > 0) {
            Set<Author> addSet = new HashSet<>(newAuthors);
            // Set<Author> addSet = new HashSet<>();
            // addSet.addAll(newAuthors);
            if (authors != null) {
                addSet.removeAll(authors);
            }
            for (Author author : addSet) {
                relDao.saveSingleRelationship4Book2Author(book.getId(), author.getId());
            }
        }

    }

    /**
     * 给一个信息不完整的book对象填充数据
     *
     * @param book
     * @return 填充数据后的book对象
     */
    protected Book fillBook(Book book) {
        if (book == null) {
            return null;
        }
        // 给book设置authors
        List<Author> authors = authorDao.queryAuthorByIdSet(relDao.queryAuthorsIdByBookId(book.getId()));
        book.setAuthors(authors);
        // 给book设置publisher
        if (book.getPublisher() != null) {
            Publisher publisher = publisherDao.queryPublisherById(book.getPublisher().getId());
            book.setPublisher(publisher);
        }
        return book;
    }

    /**
     * 给多个信息不完整的book对象填充数据
     *
     * @param books
     * @return 填充数据后的book对象
     */
    protected List<Book> fillBook(List<Book> books) {
        if (books == null || books.size() == 0) {
            return null;
        }
        for (Book book : books) {
            fillBook(book);
        }
        return books;
    }

    /**
     * 查询所有图书
     *
     * @return
     */
    @Override
    public List<Book> queryAllBook() {
        List<Book> books = bookDao.queryAllBook();
        if (books == null || books.size() == 0) {
            return null;
        }
        for (Book book : books) {
            fillBook(book);
        }
        return books;
    }

    /**
     * 根据id查询图书
     *
     * @param id
     * @return
     */
    @Override
    public Book queryBookById(int id) {
        Book book = bookDao.queryBookById(id);
        fillBook(book);
        return book;
    }

    /**
     * 根据图书名关键字，搜索图书信息
     *
     * @param nameKey
     * @return
     */
    @Override
    public List<Book> searBooksByNameKey(String nameKey) {
        List<Book> books = bookDao.queryBookByIdNameKey(nameKey);
        for (Book book : books) {
            fillBook(book);
        }
        return books;
    }

    /**
     * 检查一个book是否有效
     * 用于添加图书、更新图书信息时检查用
     * <p>
     * 检查出版社是否有效
     * 检查图书关联的作者是否有效
     *
     * @param book
     * @return true: 有效
     * false: 无效
     */
    @Override
    public boolean isValidBook(Book book) {
        if (book == null) {
            return false;
        }
        if (book.getPublisher() == null) {
            System.out.println("出版社不能为null");
            return false;
        }
        if (!publisherDao.isValidPublisherById(book.getPublisher().getId())) {
            System.out.println("出版社ID无效");
            return false;
        }

        if (!authorDao.isValidAuthorsId(authorDao.getBeansField(book.getAuthors(), "id"))) {
            System.out.println("选择了无效的作者");
            return false;
        }
        return true;
    }

    /**
     * 通过图书ID集合查询图书信息
     *
     * @param idSet : 由作者ID组成的Set对象
     * @return
     */
    @Override
    public List<Book> queryBookByIdSet(Set<Integer> idSet) {
        List<Book> books = bookDao.queryBookByIdSet(idSet);
        for (Book book : books) {
            fillBook(book);
        }
        return books;
    }

    /**
     * 查询指定ID的图书的作者
     *
     * @param bookId
     * @return
     */
    @Override
    public List<Author> queryAuthorsByBookId(int bookId) {
        return relService.queryAuthorsByBookId(bookId);
    }

    /**
     * 查询指定ID的图书的作者ID
     *
     * @param bookId
     * @return
     */
    @Override
    public Set<Integer> queryAuthorsIdByBookId(int bookId) {
        return relDao.queryAuthorsIdByBookId(bookId);
    }

    /**
     * 分页查询图书信息
     * 根据当面页码、每页size查询
     *
     * @param activePageNo
     * @param pageSize
     * @return
     */
    @Override
    public Paginator<Book> page(int activePageNo, int pageSize) {
        Paginator<Book> paginator = new Paginator<>(activePageNo, pageSize);
        // 查询总记录数
        int recordsTotal = bookDao.queryBookTotal();
        paginator.setRecordsTotal(recordsTotal);
        // 显示的总页数
        int pageTotal = recordsTotal / pageSize;
        // 如果 recordsTotal不是pageSize整数倍，显示总页数要加1页
        if (recordsTotal % pageSize != 0) {
            pageTotal = pageTotal + 1;
        }
        paginator.setPageTotal(pageTotal);
        // 查询当前要显示的记录
        List<Book> books = bookDao.paginationQueryBook(pageSize * (activePageNo - 1), pageSize);
        fillBook(books);
        paginator.setItems(books);
        paginator.setUrl("manager/bookServlet?action=page");
        return paginator;
    }
}
