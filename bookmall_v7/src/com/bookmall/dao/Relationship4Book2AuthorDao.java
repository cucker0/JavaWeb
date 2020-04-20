package com.bookmall.dao;


import com.bookmall.bean.Author;
import com.bookmall.bean.Relationship4Book2Author;

import java.util.List;
import java.util.Set;

public interface Relationship4Book2AuthorDao {


    /**
     * 保存book与作者关联记录
     *
     * @param bookId
     * @param authorId
     *      图片关联作者ID组成的Set对象
     * @return
     */
    Integer saveSingleRelationship4Book2Author(int bookId, int authorId);


    /**
     * 删除所有关联指定图书ID的作者关联记录
     *
     * @param bookId
     * @return 执行sql语句影响的行数
     */
    int deleteRelationship4Book2AuthorByBookId(int bookId);

    /**
     * 删除指定图书ID、作者ID的关系关联记录
     *
     * @param bookId
     * @param authorId
     * @return 执行sql语句影响的行数
     */
    int deleteRelationship4Book2AuthorByBookIdAndAuthorId(int bookId, int authorId);


    /**
     * 查询指定ID图书与作者的所有关联记录
     *
     * @param bookId
     * @return
     */
    List<Relationship4Book2Author> queryRelationshipsByBookId(int bookId);

    /**
     * 查看指定作者ID与图书的所有关联记录
     *
     * @param authorId
     * @return
     */
    List<Relationship4Book2Author> queryRelationshipsByAuthorId(int authorId);

    /**
     * 根据图书ID，查询关联该图书的所有作者的ID
     *
     * @param bookId
     * @return
     */
    Set<Integer> queryAuthorsIdByBookId(int bookId);

    /**
     * 根据作者ID，查询关联该作者的所有图书的ID
     *
     * @param authorId
     * @return
     */
    Set<Integer> queryBooksIdByAuthorId(int authorId);

    /**
     * 检查指定id的图书与指定id的作者关联记录是否存在
     *
     * @param bookId
     * @param authorId
     * @return
     *      true: 存在
     *      false: 不存在
     */
    boolean isValidRelationshipQeuryByBookIdAndAuthorId(int bookId, int authorId);
}
