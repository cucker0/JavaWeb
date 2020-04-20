package com.bookmall.serviceimpl;

import com.bookmall.bean.Author;
import com.bookmall.bean.Book;
import com.bookmall.dao.AuthorDao;
import com.bookmall.dao.BookDao;
import com.bookmall.dao.Relationship4Book2AuthorDao;
import com.bookmall.daoimpl.AuthorDaoImpl;
import com.bookmall.daoimpl.BookDaoImpl;
import com.bookmall.daoimpl.Relationship4Book2AuthorDaoImpl;
import com.bookmall.service.AuthorService;
import com.bookmall.service.BookService;
import com.bookmall.service.Relationship4Book2AuthorService;

import java.util.List;
import java.util.Set;

public class Relationship4Book2AuthorServiceImpl implements Relationship4Book2AuthorService {
    private Relationship4Book2AuthorDao relDao = new Relationship4Book2AuthorDaoImpl();
    private BookDao bookDao = new BookDaoImpl();
    private AuthorDao authorDao = new AuthorDaoImpl();

    // 方法

    /**
     * 添加新增图片与作者的关联记录
     *
     * @param book
     */
    @Override
    public void addRelationshipBook2Authors(Book book) {
        if (book == null || book.getId() == null || book.getAuthors() == null) {
            return;
        }
        for (Author author : book.getAuthors()) {
            // 检查图书ID与作者ID是否可以建立关联
            if (!checkRelationship(book.getId(), author.getId())) {
                continue;
            }
            relDao.saveSingleRelationship4Book2Author(book.getId(), author.getId());
        }
    }

    @Override
    public void deleteRelationship4Book2AuthorByBookIdAndAuthorId(int bookId, int authorId) {
        relDao.deleteRelationship4Book2AuthorByBookIdAndAuthorId(bookId, authorId);
    }

    /**
     * 删除指定图书与作者的所有关联记录
     *
     * @param bookId
     */
    @Override
    public void deleteRelationship4Book2AuthorByBook(int bookId) {
        relDao.deleteRelationship4Book2AuthorByBookId(bookId);
    }

    /**
     * 查找指定ID图书的作者
     *
     * @param bookId
     * @return
     */
    @Override
    public List<Author> queryAuthorsByBookId(int bookId) {
        return authorDao.queryAuthorByIdSet(relDao.queryAuthorsIdByBookId(bookId));
    }

    /**
     * 查找指定ID作者写的所有图书
     *
     * @param authorId
     * @return
     */
    @Override
    public List<Book> queryBooksByAuthorId(int authorId) {
        Set<Integer> booksId = relDao.queryBooksIdByAuthorId(authorId);
        return bookDao.queryBookByIdSet(booksId);
    }

    /**
     * 检查图书ID与作者ID是否可以建立关联
     *
     * @param bookId
     * @param authorId
     * @return true: 可关联
     * false: 不关联
     */
    @Override
    public boolean checkRelationship(Integer bookId, Integer authorId) {
        // bookId无效时，不能建立关联
        if (bookId != null) {
            if (!bookDao.isValidBookId(bookId)) {
                return false;
            }
        }

        // authorId无效时，不能建立关联
        if (authorId != null) {
            if (!authorDao.isValidAuthorId(authorId)) {
                return false;
            }
        }
        // bookId、authorID都有效时，检查是否已经存在相同的记录
        if (bookId != null && authorId != null) {
            // bookId、authorId关联记录存在时，不能再见相同的关联记录
            if (relDao.isValidRelationshipQeuryByBookIdAndAuthorId(bookId, authorId)) {
                return false;
            }
        }
        return true;
    }
}
