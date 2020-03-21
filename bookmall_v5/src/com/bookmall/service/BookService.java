package com.bookmall.service;

import com.bookmall.bean.Author;
import com.bookmall.bean.Book;

import java.util.List;
import java.util.Set;

public interface BookService {


    /**
     * 添加图书
     *
     * @param book
     */
    void addBook(Book book);

    /**
     * 删除指定ID的图书
     *
     * @param id
     */
    void deleteBookById(int id);

    /**
     * 更新图书信息
     *
     * @param book
     */
    void updateBook(Book book);

    /**
     * 查询所有图书
     *
     * @return
     */
    List<Book> queryAllBook();

    /**
     * 根据id查询图书
     *
     * @param id
     * @return
     */
    Book queryBookById(int id);

    /**
     * 根据图书名关键字，搜索图书信息
     *
     * @param nameKey
     * @return
     */
    List<Book> searBooksByNameKey(String nameKey);

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
    boolean isValidBook(Book book);

    /**
     * 通过图书ID集合查询图书信息
     *
     * @param idSet: 由作者ID组成的Set对象
     * @return
     */
    List<Book> queryBookByIdSet(Set<Integer> idSet);

    /**
     * 查询指定ID的图书的作者
     *
     * @param bookId
     * @return
     */
    List<Author> queryAuthorsByBookId(int bookId);

    /**
     * 查询指定ID的图书的作者ID
     *
     * @param bookId
     * @return
     */
    Set<Integer> queryAuthorsIdByBookId(int bookId);

}
