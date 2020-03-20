package com.bookmall.daoimpl;

import com.bookmall.bean.Publisher;
import com.bookmall.dao.BaseDao;
import com.bookmall.dao.PublisherDao;

import java.util.List;

public class PublisherDaoImpl extends BaseDao<Publisher> implements PublisherDao {
    // 方法
    /**
     * 新增出版社
     *
     * @param publisher
     * @return
     */
    @Override
    public Integer savePublisher(Publisher publisher) {
        String sql = "INSERT INTO t_publisher (`name`) VALUES (?);";
        return insert(sql, publisher.getName());
    }

    /**
     * 删除指定ID的出版社
     *
     * @param publisherId
     * @return
     */
    @Override
    public int deletePublisherById(int publisherId) {
        String sql = "DELETE FROM t_publisher WHERE id = ?;";
        return update(sql, publisherId);
    }

    /**
     * 更新出版社信息
     *
     * @param publisher
     * @return
     */
    @Override
    public int updatePublisher(Publisher publisher) {
        String sql = "UPDATE t_publisher SET `name` = ? WHERE id = ?;";
        return update(sql, publisher.getName(), publisher.getId());
    }

    /**
     * 查询所有的出版社
     *
     * @return
     */
    @Override
    public List<Publisher> queryAllPublisher() {
        String sql = "SELECT id, `name` FROM t_publisher;";
        return getBeanList(sql);
    }

    /**
     * 查询指定ID的出版社
     *
     * @param publisherId
     * @return
     */
    @Override
    public Publisher queryPublisherById(int publisherId) {
        String sql = "SELECT id, `name` FROM t_publisher WHERE id = ?;";
        return getBean(sql, publisherId);
    }


    /**
     * 按出版社名字关键字查找出版社
     * @param nameKey
     * @return
     */
    @Override
    public List<Publisher> queryPublisherByNameKey(String nameKey) {
        if (nameKey == null) {
            return null;
        }
        if (nameKey.strip().length() == 0) {
            return null;
        }
        String key = "%" + nameKey + "%";
        String sql = "SELECT id, `name` FROM t_publisher WHERE `name` LIKE ?;";
        return getBeanList(sql, key);
    }

    /**
     * 查询出版社ID是否有效
     *
     * @return true: 有效
     * false: 无效
     */
    @Override
    public boolean isValidPublisherById(int publisherId) {
        String sql = "SELECT COUNT(id) FROM t_publisher WHERE id = ?;";
        long count = getValue(sql, publisherId);
        return count != 0;
    }
}
