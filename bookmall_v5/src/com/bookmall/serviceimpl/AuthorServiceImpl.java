package com.bookmall.serviceimpl;

import com.bookmall.bean.Author;
import com.bookmall.dao.AuthorDao;
import com.bookmall.daoimpl.AuthorDaoImpl;
import com.bookmall.service.AuthorService;

import java.util.List;
import java.util.Set;

public class AuthorServiceImpl implements AuthorService {
    private AuthorDao authorDao = new AuthorDaoImpl();

    /**
     * 新增作者
     *
     * @param author
     */
    @Override
    public void saveAuthor(Author author) {
        authorDao.saveAuthor(author);
    }

    /**
     * 删除指定ID的作者
     *
     * @param id
     */
    @Override
    public void deleteAuthorById(int id) {
        authorDao.deleteAuthorById(id);
    }

    /**
     * 更新作者信息系
     *
     * @param author
     */
    @Override
    public void updateAuthor(Author author) {
        if (author == null) {
            return;
        }
        authorDao.updateAuthor(author);
    }

    /**
     * 查询所有作者信息
     */
    @Override
    public List<Author> queryAllAuthor() {
        return authorDao.queryAllAuthor();
    }

    /**
     * 查询指定ID的作者
     *
     * @param id
     */
    @Override
    public Author queryAuthorById(int id) {
        return authorDao.queryAuthorById(id);
    }

    /**
     * 根据作者名字关键字搜索作者信息
     *
     * @param nameKey
     */
    @Override
    public List<Author> searchAuthorByNameKey(String nameKey) {
        return authorDao.queryAuthorByNameKey(nameKey);
    }

    /**
     * 根据作者ID集合查询作者信息
     *
     * @param idSet 多个作者ID组成的Set集合
     * @return
     */
    @Override
    public List<Author> queryAuthorByIdSet(Set<Integer> idSet) {
        return authorDao.queryAuthorByIdSet(idSet);
    }
}
