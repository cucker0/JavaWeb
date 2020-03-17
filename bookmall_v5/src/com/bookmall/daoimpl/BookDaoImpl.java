package com.bookmall.daoimpl;

import com.bookmall.bean.Book;
import com.bookmall.dao.BaseDao;
import com.bookmall.dao.BookDao;
import com.bookmall.utils.CommonUtils;

import java.util.List;
import java.util.Set;

public class BookDaoImpl extends BaseDao<Book> implements BookDao {
    // 构造器
    public BookDaoImpl() {}

    // 方法
    /**
     * 添加图书
     *
     * @return: 执行insert语句时，返回的自增ID值
     * 执行失败，放回null
     */
    @Override
    public Integer saveBook(Book book) {
        String sql = "INSERT INTO t_book (`name`, price, sales, stock, img_path, publisher_id, `time`) VALUES " +
                "(?, ?, ?, ?, ?, ?, ?);";
        return insert(sql, book.getName(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(),
                book.getPublisher() == null ? null : book.getPublisher().getId(),
                book.getTime());
    }

    /**
     * 删除指定ID的图书
     *
     * @param bookId : 图书ID
     * @return: 执行sql受影响的行数
     */
    @Override
    public int deleteBookById(int bookId) {
        String sql = "DELETE FROM t_book WHERE id = ?;";
        return update(sql, bookId);
    }

    /**
     * 更新图书信息
     *
     * @param book : 新的图书对象
     * @return: 执行sql受影响的行数
     */
    @Override
    public int updateBook(Book book) {
        String sql = "UPDATE t_book SET `name` = ?, price = ?, sales = ?, stock = ?, img_path = ?, publisher_id = ?, `time` = ? " +
                "WHERE id = ?;";
        return update(sql, book.getName(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(),
                book.getPublisher() == null ? null : book.getPublisher().getId(),
                book.getTime(), book.getId());
    }

    /**
     * 查询所有图书
     *
     * @return: 返回图书对象集合，
     * 查询失败放回null
     */
    @Override
    public List<Book> queryAllBook() {
        String sql = "SELECT id, `name`, price, sales, stock, img_path imgPath, publisher_id, `time` sqlTime FROM t_book LIMIT 0, 1000;";
     return getBeanList(sql);
     }

     /**
     * 查询指定ID的图书信息
     *
     * @param bookdId : 图书ID
     * @return: 返回图书对象
     */
    @Override
    public Book queryBookById(int bookdId) {
        String sql = "SELECT id, `name`, price, sales, stock, img_path imgPath, publisher_id, `time` sqlTime FROM  t_book WHERE id = ?;";
        return getBean(sql, bookdId);
    }

    /**
     * 检查图书ID的有效性
     *
     * @param bookId
     * @return true: 有效，
     * false: 无效
     */
    @Override
    public boolean isValidBookId(int bookId) {
        String sql = "SELECT COUNT(id) FROM t_book WHERE id = ?;";
        long count = getValue(sql, bookId);
        return count != 0;
    }

    /**
     * 通过图书名关键字查找图书
     *
     * @param nameKey
     * @return
     */
    @Override
    public List<Book> queryBookByIdNameKey(String nameKey) {
        if (nameKey == null || nameKey.length() == 0) {
            return null;
        }
        String key = "%" + nameKey + "%";
        String sql = "SELECT id, `name`, price, sales, stock, img_path imgPath, publisher_id, `time` sqlTime FROM  t_book WHERE `name` LIKE ?;";
        return getBeanList(sql, key);
    }

    /**
     * 通过图书ID集合查询图书信息
     *
     * @param idSet : 由作者ID组成的Set对象
     * @return
     */
    @Override
    public List<Book> queryBookByIdSet(Set<Integer> idSet) {
        if (idSet == null || idSet.isEmpty()) {
            return null;
        }
        idSet.remove(null);
        if (idSet.isEmpty()) {
            return null;
        }
        String parametersStr = CommonUtils.getBeanSetParamerts(idSet);
        String sql = String.format("SELECT id, `name`, price, sales, stock, img_path imgPath, publisher_id, `time` sqlTime " +
                "FROM  t_book WHERE id IN (%s);", parametersStr);
        return getBeanList(sql, idSet.toArray());
    }
}
