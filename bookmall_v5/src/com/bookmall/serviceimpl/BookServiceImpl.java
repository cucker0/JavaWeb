package com.bookmall.serviceimpl;

import com.bookmall.bean.Author;
import com.bookmall.bean.Book;
import com.bookmall.dao.AuthorDao;
import com.bookmall.dao.BookDao;
import com.bookmall.dao.Relationship4Book2AuthorDao;
import com.bookmall.daoimpl.AuthorDaoImpl;
import com.bookmall.daoimpl.BookDaoImpl;
import com.bookmall.daoimpl.Relationship4Book2AuthorDaoImpl;
import com.bookmall.service.BookService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;
    private AuthorDao authorDao;
    private Relationship4Book2AuthorDao relDao;

    // 构造器
    public BookServiceImpl() {
        super();
        bookDao = new BookDaoImpl();
        authorDao = new AuthorDaoImpl();
        relDao = new Relationship4Book2AuthorDaoImpl();
    }

    // 方法
    /**
     * 添加图书
     *
     * @param book
     */
    @Override
    public void addBook(Book book) {
        bookDao.saveBook(book);
    }

    /**
     * 删除指定ID的图书
     *
     * @param id
     */
    @Override
    public void deleteBookById(int id) {
        bookDao.deleteBookById(id);
    }

    /**
     * 更新图书信息
     *
     * @param book
     */
    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    /**
     * 查询所有图书
     *
     * @return
     */
    @Override
    public List<Book> queryAllBook() {
        List<Book> books = bookDao.queryAllBook();
        for (Book book : books) {
            List<Author> authors = authorDao.queryAuthorByIdSet(relDao.queryAuthorsIdByBookId(book.getId()));
            book.setAuthors(authors);
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
        return bookDao.queryBookById(id);
    }

    /**
     * 根据图书名关键字，搜索图书信息
     *
     * @param nameKey
     * @return
     */
    @Override
    public List<Book> searBooksByNameKey(String nameKey) {
        return bookDao.queryBookByIdNameKey(nameKey);
    }
}
