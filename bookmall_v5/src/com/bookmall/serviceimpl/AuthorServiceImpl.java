package com.bookmall.serviceimpl;

import com.bookmall.bean.Author;
import com.bookmall.dao.AuthorDao;
import com.bookmall.dao.Relationship4Book2AuthorDao;
import com.bookmall.daoimpl.AuthorDaoImpl;
import com.bookmall.daoimpl.Relationship4Book2AuthorDaoImpl;
import com.bookmall.service.AuthorService;

import java.util.List;
import java.util.Set;

public class AuthorServiceImpl implements AuthorService {
    private AuthorDao authorDao = new AuthorDaoImpl();
    private Relationship4Book2AuthorDao relDao = new Relationship4Book2AuthorDaoImpl();

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
     * 查询所有作者，并把id在authorsIdSet的作者checked设置为true
     *
     * @param bookId
     * @return
     */
    @Override
    public List<Author> queryAllAuthor(int bookId) {
        // 所有作者
        List<Author> authors = queryAllAuthor();
        // 更新 选中的作者
        Set<Integer> checkedIdSet = relDao.queryAuthorsIdByBookId(bookId);
        int count = 0;
        for (Author author : authors) {
            if (checkedIdSet.contains(author.getId())) {
                ++count;
                author.setChecked(true);
                if (count >= checkedIdSet.size()) {
                    break;
                }
            }
        }
        return authors;
    }

    /**
     * 查询指定ID的作者
     *
     * @param id
     */
    @Override
    public Author queryAuthorById(int id) {
        if (id < 1) {
            return null;
        }
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
