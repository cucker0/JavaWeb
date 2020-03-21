package com.bookmall.service;

import com.bookmall.bean.Publisher;

import java.util.List;

public interface PublisherService {
    /**
     * 新增出版社
     *
     * @param publisher
     */
    void addPublisher(Publisher publisher);

    /**
     * 删除指定ID的出版社
     *
     * @param id
     */
    void deletePublisherById(int id);

    /**
     * 更新出版社信息
     *
     * @param publisher
     */
    void updatePublisher(Publisher publisher);

    /**
     * 查询所有的出版社
     *
     * @return
     */
    List<Publisher> queryAllPublisher();

    /**
     * 查询所有出版社，并把指定ID图书的出版社checked设置为true
     *
     * @param bookId
     * @return
     */
    List<Publisher> queryAllPublisher(int bookId);

    /**
     * 根据出版社ID查询出版社
     *
     * @param id
     * @return
     */
    Publisher queryPublisherById(int id);

    /**
     * 根据出版社名字关键字搜索出版社
     *
     * @return
     */
    List<Publisher> searchPublisherByNameKey(String nameKey);

    /**
     * 查询出版社ID是否有效
     *
     * @param id
     * @return
     */
    boolean isValidPublisherById(int id);

}
