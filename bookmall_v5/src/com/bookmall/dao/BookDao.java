package com.bookmall.dao;

import com.bookmall.bean.Book;

import java.util.List;

public interface BookDao {
    /**
     * 添加图书
     *
     * @return: 执行insert语句时，返回的自增ID值
     *      执行失败，放回null
     */
    Integer save();

    /**
     * 删除指定ID的图书
     *
     * @param id: 图书ID
     * @return: 执行sql受影响的行数
     */
    int deleteById(int id);

    /**
     * 更新图书信息
     *
     * @param book: 新的图书对象
     * @return: 执行sql受影响的行数
     */
    int update(Book book);

    /**
     * 查询所有图书
     *
     * @return: 返回图书对象集合，
     *     查询失败放回null
     */
    List<Book> queryAllBook();

    /**
     * 查询指定ID的图书信息
     *
     * @param id: 图书ID
     * @return: 返回图书对象
     */
    Book queryBookById(int id);
}
