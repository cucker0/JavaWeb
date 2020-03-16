package com.bookmall.daoimpl;

import com.bookmall.bean.Author;
import com.bookmall.bean.Relationship4Book2Author;
import com.bookmall.dao.AuthorDao;
import com.bookmall.dao.BaseDao;
import com.bookmall.dao.BookDao;
import com.bookmall.dao.Relationship4Book2AuthorDao;

import java.sql.Connection;
import java.util.List;
import java.util.Set;

public class Relationship4Book2AuthorDaoImpl extends BaseDao<Relationship4Book2Author> implements Relationship4Book2AuthorDao {
    protected BookDao bookDao;
    protected AuthorDao authorDao;

    public Relationship4Book2AuthorDaoImpl() {
        bookDao = new BookDaoImpl();
        authorDao = new AuthorDaoImpl();
    }

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
        // 检查图书ID有效性
        if (!bookDao.isValidBookId(bookId)) {
            return null;
        }
        // 检查作者ID有效性
        if (!authorDao.isValidAuthorId(authorId)) {
            return null;
        }
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
    public List<Relationship4Book2Author> queryAuthorsByBookId(int bookId) {
        String sql = "SELECT id, book_id bookId, author_id authorId FROM r_book_author WHERE book_id = ? LIMIT 0, 100;";
        return getBeanList(sql, bookId);
    }

    /**
     * 查看指定作者ID与图书的所有关联记录
     *
     * @param authorId
     * @return
     */
    @Override
    public List<Relationship4Book2Author> queryBooksByAuthorId(int authorId) {
        String sql = "SELECT id, book_id bookId, author_id authorId FROM r_book_author WHERE author_id = ? LIMIT 0, 100;";
        return getBeanList(sql, authorId);
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
