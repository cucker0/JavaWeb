package com.bookmall.serviceimpl;

import com.bookmall.bean.Author;
import com.bookmall.bean.Paginator;
import com.bookmall.dao.AuthorDao;
import com.bookmall.dao.Relationship4Book2AuthorDao;
import com.bookmall.daoimpl.AuthorDaoImpl;
import com.bookmall.daoimpl.Page;
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
        if (author == null || author.getName() == null) {
            return;
        }
        if (!authorDao.isValidAuthorByAuthor(author)) {
            authorDao.saveAuthor(author);
        }
    }

    /**
     * 删除指定ID的作者
     *
     * @param id
     */
    @Override
    public void deleteAuthorById(int id) {
        if (id <= 0) {
            return;
        }
        authorDao.deleteAuthorById(id);
    }

    /**
     * 更新作者信息系
     *
     * @param author
     */
    @Override
    public void updateAuthor(Author author) {
        if (author == null || author.getId() <= 0) {
            return;
        }
        // author.id需要存在才更新
        if (authorDao.isValidAuthorId(author.getId())) {
            authorDao.updateAuthor(author);
        }
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

    /**
     * 分页查询作者信息
     *
     * @param activePageNo 要查看的页码
     * @param pageSize     每页显示的条数
     * @return
     */
    @Override
    public Paginator<Author> page(int activePageNo, int pageSize) {
        int recordsTotal = authorDao.queryAuthorTotal();
        activePageNo = Page.checkActivePageNo(activePageNo, pageSize, recordsTotal);
        List<Author> authors = authorDao.paginationQueryAuthor(pageSize * (activePageNo - 1), pageSize);
        String url = "manager/authorServlet?action=page";
        Page<Author> page = new Page<>(activePageNo, pageSize, recordsTotal, authors, url);
        return page.getPaginator();
    }

}
