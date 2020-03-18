package com.bookmall.service;

import com.bookmall.bean.Book;

import java.util.List;

public interface BookService {


    /**添加图书
     * @param book
     */
    void addBook(Book book);

    /**
     * 删除指定ID的图书
     * @param id
     */
    void deleteBookById(int id);

    /**
     * 更新图书信息
     * @param book
     */
    void updateBook(Book book);

    /**
     * 查询所有图书
     * @return
     */
    List<Book> queryAllBook();

    /**
     * 根据id查询图书
     * @param id
     * @return
     */
    Book queryBookById(int id);

    /**
     * 根据图书名关键字，搜索图书信息
     * @param nameKey
     * @return
     */
    List<Book> searBooksByNameKey(String nameKey);
}
