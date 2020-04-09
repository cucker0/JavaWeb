package com.bookmall.service;

import com.bookmall.bean.Author;
import com.bookmall.bean.Book;
import com.bookmall.bean.Relationship4Book2Author;

import java.util.List;
import java.util.Set;

public interface Relationship4Book2AuthorService {
    /**
     * 添加新增图片与作者的关联记录
     *
     * @param book
     */
    void addRelationshipBook2Authors(Book book);

    void deleteRelationship4Book2AuthorByBookIdAndAuthorId(int bookId, int authorId);

    /**
     * 删除指定图书与作者的所有关联记录
     *
     * @param bookId
     */
    void deleteRelationship4Book2AuthorByBook(int bookId);

    /**
     * 查找指定ID图书的作者
     * @param bookId
     * @return
     */
    List<Author> queryAuthorsByBookId(int bookId);

    /**
     * 查找指定ID作者写的所有图书
     * @param authorId
     * @return
     */
    List<Book> queryBooksByAuthorId(int authorId);

    /**
     * 检查图书ID与作者ID是否关联
     * @param bookId
     * @param authorId
     * @return
     *      true: 已关联
     *      false: 无关联
     */
    boolean checkRelationship(Integer bookId, Integer authorId);
}
