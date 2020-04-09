package com.bookmall.dao;

import com.bookmall.bean.Publisher;

import java.util.List;

public interface PublisherDao {
    /**
     * 新增出版社
     * @param publisher
     * @return
     */
    Integer savePublisher(Publisher publisher);

    /**
     * 删除指定ID的出版社
     * @param publisherId
     * @return
     */
    int deletePublisherById(int publisherId);

    /**
     * 更新出版社信息
     * @param publisher
     * @return
     */
    int updatePublisher(Publisher publisher);

    /**
     * 查询所有的出版社
     * @return
     */
    List<Publisher> queryAllPublisher();

    /**
     * 查询指定ID的出版社
     * @param publisherId
     * @return
     */
    Publisher queryPublisherById(int publisherId);


    /**
     * 按出版社名字关键字查找出版社
     * @param nameKey
     * @return
     */
    List<Publisher> queryPublisherByNameKey(String nameKey);

    /**
     * 查询出版社ID是否有效
     * @return
     *      true: 有效
     *      false: 无效
     */
    boolean isValidPublisherById(int publisherId);
}
