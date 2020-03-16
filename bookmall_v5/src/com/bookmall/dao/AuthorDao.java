package com.bookmall.dao;

import com.bookmall.bean.Author;

import java.util.List;

public interface AuthorDao {
    /**
     * 新增作者
     *
     * @param author: 要保存的author对象
     * @return: 执行insert语句时，返回的自增ID值
     * 执行失败，放回null
     */
    Integer saveAuthor(Author author);

    /**
     * 删除指定ID的作者
     *
     * @param authorId: 作者ID
     * @return: 执行sql受影响的行数
     */
    int deleteAuthorById(int authorId);

    /**
     * 更新作者信息
     *
     * @param author: 作者对象
     * @return: 执行sql受影响的行数
     */
    int updateAuthor(Author author);

    /**
     * 查询所有的作者
     *
     * @return: 由所有作者对对象组成的list集合
     */
    List<Author> queryAllAuthor();

    /**
     * 查询指定ID的作者
     * @param authorId:
     * @return:
     */
    Author queryAuthorById(int authorId);

    /**
     * 检查用户ID是否有效
     *
     * @param authorId
     * @return
     */
    boolean isValidAuthorId(int authorId);

    /**
     * 查找作者名中包含指定关键字的作者
     *
     * @param nameKey
     * @return
     */
    List<Author> queryAuthorByNameKey(String nameKey);
}
