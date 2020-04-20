package com.bookmall.serviceimpl;

import com.bookmall.bean.Book;
import com.bookmall.bean.Publisher;
import com.bookmall.dao.BookDao;
import com.bookmall.dao.PublisherDao;
import com.bookmall.daoimpl.BookDaoImpl;
import com.bookmall.daoimpl.PublisherDaoImpl;
import com.bookmall.service.PublisherService;

import java.util.List;

public class PublisherServiceImpl implements PublisherService {
    private PublisherDao publisherDao = new PublisherDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    /**
     * 新增出版社
     *
     * @param publisher
     */
    @Override
    public void addPublisher(Publisher publisher) {
        if (publisher == null) {
            return;
        }
        publisherDao.savePublisher(publisher);
    }

    /**
     * 删除指定ID的出版社
     *
     * @param id
     */
    @Override
    public void deletePublisherById(int id) {
        if (id <1) {
            return;
        }
        publisherDao.deletePublisherById(id);
    }

    /**
     * 更新出版社信息
     *
     * @param publisher
     */
    @Override
    public void updatePublisher(Publisher publisher) {
        if (publisher == null) {
            return;
        }
        publisherDao.updatePublisher(publisher);
    }

    /**
     * 查询所有的出版社
     *
     * @return
     */
    @Override
    public List<Publisher> queryAllPublisher() {
        return publisherDao.queryAllPublisher();
    }

    /**
     * 查询所有出版社，并把指定ID图书的出版社checked设置为true
     *
     * @param bookId
     * @return
     */
    @Override
    public List<Publisher> queryAllPublisher(int bookId) {
        Book book = bookDao.queryBookById(bookId);
        if (book == null || book.getPublisher() == null) {
            return null;
        }
        List<Publisher> publishers = publisherDao.queryAllPublisher();
        for (Publisher publisher : publishers) {
            if (publisher.getId() == book.getPublisher().getId()) {
                publisher.setChecked(true);
                break;
            }
        }
        return publishers;
    }

    /**
     * 根据出版社ID查询出版社
     *
     * @param id
     * @return
     */
    @Override
    public Publisher queryPublisherById(int id) {
        return publisherDao.queryPublisherById(id);
    }

    /**
     * 根据出版社名字关键字搜索出版社
     *
     * @return
     */
    @Override
    public List<Publisher> searchPublisherByNameKey(String nameKey) {
        return publisherDao.queryPublisherByNameKey(nameKey);
    }

    /**
     * 查询出版社ID是否有效
     *
     * @param id
     * @return
     */
    @Override
    public boolean isValidPublisherById(int id) {
        return publisherDao.isValidPublisherById(id);
    }

}
