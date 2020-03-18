package com.bookmall.daoimpl;

import com.bookmall.bean.Author;
import com.bookmall.bean.Relationship4Book2Author;
import com.bookmall.dao.AuthorDao;
import com.bookmall.dao.BaseDao;
import com.bookmall.dao.BookDao;
import com.bookmall.dao.Relationship4Book2AuthorDao;

import java.sql.Connection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Relationship4Book2AuthorDaoImpl extends BaseDao<Relationship4Book2Author> implements Relationship4Book2AuthorDao {
    // 方法
    /**
     * 保存book与作者关联记录
     *
     * @param bookId
     * @param authorId 图片关联作者ID组成的Set对象
     * @return
     */
    @Override
    public Integer saveSingleRelationship4Book2Author(int bookId, int authorId) {
        // 检查图书ID有效性 \ 检查作者ID有效性 工作放到service层去，这样使每个DAO互相独立，不存在太多的依赖
        String sql = "INSERT INTO r_book_author (book_id, author_id) VALUES (?, ?);";
        return insert(sql, bookId, authorId);
    }

    /**
     * 删除所有关联指定图书ID的作者关联记录
     *
     * @param bookId
     * @return 执行sql语句影响的行数
     */
    @Override
    public int deleteRelationship4Book2AuthorByBookId(int bookId) {
        String sql = "DELETE FROM r_book_author WHERE book_id = ?;";
        return update(sql, bookId);
    }

    /**
     * 删除指定图书ID、作者ID的关系关联记录
     *
     * @param bookId
     * @param authorId
     * @return 执行sql语句影响的行数
     */
    @Override
    public int deleteRelationship4Book2AuthorByBookIdAndAuthorId(int bookId, int authorId) {
        String sql = "DELETE FROM r_book_author WHERE book_id = ? AND author_id = ?;";
        return update(sql, bookId, authorId);
    }

    /**
     * 查询指定ID图书与作者的所有关联记录
     *
     * @param bookId
     * @return
     */
    @Override
    public List<Relationship4Book2Author> queryRelationshipsByBookId(int bookId) {
        String sql = "SELECT DISTINCT book_id bookId, author_id authorId FROM r_book_author WHERE book_id = ? LIMIT 0, 100;";
        return getBeanList(sql, bookId);
    }

    /**
     * 查看指定作者ID与图书的所有关联记录
     *
     * @param authorId
     * @return
     */
    @Override
    public List<Relationship4Book2Author> queryRelationshipsByAuthorId(int authorId) {
        String sql = "SELECT DISTINCT book_id bookId, author_id authorId FROM r_book_author WHERE author_id = ? LIMIT 0, 100;";
        return getBeanList(sql, authorId);
    }

    /**
     * 根据图书ID，查询关联该图书的所有作者的ID
     *
     * @param bookId
     * @return
     */
    @Override
    public Set<Integer> queryAuthorsIdByBookId(int bookId) {
        Set<Integer> set = new HashSet<>();
        List<Relationship4Book2Author> relationships = queryRelationshipsByBookId(bookId);
        for (Relationship4Book2Author r : relationships) {
            if (r.getAuthorId() == null) {
                continue;
            }
            set.add(r.getAuthorId());
        }
        return set;
    }

    /**
     * 根据作者ID，查询关联该作者的所有图书的ID
     *
     * @param authorId
     * @return
     */
    @Override
    public Set<Integer> queryBooksIdByAuthorId(int authorId) {
        Set<Integer> set = new HashSet<>();
        List<Relationship4Book2Author> relationships = queryRelationshipsByAuthorId(authorId);
        for (Relationship4Book2Author r : relationships) {
            if (r.getBookId() == null) {
                continue;
            }
            set.add(r.getBookId());
        }
        return set;
    }


    /**
     * 检查指定id的图书与指定id的作者关联记录是否存在
     *
     * @param bookId
     * @param authorId
     * @return true: 存在
     * false: 不存在
     */
    @Override
    public boolean isValidRelationshipQeuryByBookIdAndAuthorId(int bookId, int authorId) {
        String sql = "SELECT COUNT(*) FROM r_book_author WHERE book_id = ? AND author_id = ?;";
        long count = getValue(sql, bookId, authorId);
        return count != 0;
    }
}
