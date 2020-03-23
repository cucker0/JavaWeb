package com.bookmall.dao;

import com.bookmall.bean.Book;

import java.util.List;
import java.util.Set;

public interface BookDao {
    /**
     * 添加图书
     *
     * @return: 执行insert语句时，返回的自增ID值
     *      执行失败，放回null
     */
    Integer saveBook(Book book);

    /**
     * 删除指定ID的图书
     *
     * @param bookId: 图书ID
     * @return: 执行sql受影响的行数
     */
    int deleteBookById(int bookId);

    /**
     * 更新图书信息
     *
     * @param book: 新的图书对象
     * @return: 执行sql受影响的行数
     */
    int updateBook(Book book);

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
     * @param bookId: 图书ID
     * @return: 返回图书对象
     */
    Book queryBookById(int bookId);

    /**
     * 检查图书ID的有效性
     *
     * @param bookId
     * @return
     *      true: 有效，
     *      false: 无效
     */
    boolean isValidBookId(int bookId);

    /**
     * 通过图书名关键字查找图书
     *
     * @param nameKey
     * @return
     */
    List<Book> queryBookByIdNameKey(String nameKey);

    /**
     * 通过图书ID集合查询图书信息
     *
     * @param idSet: 由作者ID组成的Set对象
     * @return
     */
    List<Book> queryBookByIdSet(Set<Integer> idSet);

    /**
     * 分页查询图书
     *
     * @param offSet 起始索引
     * @param size 查询记录数
     * @return
     */
    List<Book> paginationQueryBook(int offSet, int size);

    /**
     * 查询图书总数量
     *
     * @return
     */
    int queryBookTotal();
}
