package com.bookmall.service;

import com.bookmall.bean.Author;
import com.bookmall.bean.Paginator;

import java.util.List;
import java.util.Set;

public interface AuthorService {
    /**
     * 新增作者
     *
     * @param author
     */
    void saveAuthor(Author author);

    /**
     * 删除指定ID的作者
     *
     * @param id
     */
    void deleteAuthorById(int id);

    /**
     * 更新作者信息系
     *
     * @param author
     */
    void updateAuthor(Author author);

    /**
     * 查询所有作者信息
     */
    List<Author> queryAllAuthor();

    /**
     * 查询所有作者，并把指定ID图书的作者checked设置为true
     *
     * @param bookId
     * @return
     */
    List<Author> queryAllAuthor(int bookId);

    /**
     * 查询指定ID的作者
     *
     * @param id
     */
    Author queryAuthorById(int id);

    /**
     * 根据作者名字关键字搜索作者信息
     *
     * @param nameKey
     */
    List<Author> searchAuthorByNameKey(String nameKey);

    /**
     * 根据作者ID集合查询作者信息
     *
     * @param idSet 多个作者ID组成的Set集合
     * @return
     */
    List<Author> queryAuthorByIdSet(Set<Integer> idSet);

    /**
     * 分页查询作者信息
     *
     * @param activePageNo 要查看的页码
     * @param pageSize 每页显示的条数
     * @return
     */
    Paginator<Author> page(int activePageNo, int pageSize);
}
