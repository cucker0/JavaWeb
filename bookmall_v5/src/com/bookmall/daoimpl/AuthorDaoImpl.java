package com.bookmall.daoimpl;

import com.bookmall.bean.Author;
import com.bookmall.dao.AuthorDao;
import com.bookmall.dao.BaseDao;
import com.bookmall.utils.CommonUtils;

import java.util.List;
import java.util.Set;

public class AuthorDaoImpl extends BaseDao<Author> implements AuthorDao {
    /**
     * 新增作者
     *
     * @param author : 要保存的author对象
     * @return: 执行insert语句时，返回的自增ID值
     * 执行失败，放回null
     */
    @Override
    public Integer saveAuthor(Author author) {
        String sql = "INSERT INTO t_author (`name`, brief) VALUES (?, ?);";
        return insert(sql, author.getName(), author.getBrief());
    }

    /**
     * 删除指定ID的作者
     *
     * @param authorId : 作者ID
     * @return: 执行sql受影响的行数
     */
    @Override
    public int deleteAuthorById(int authorId) {
        String sql = "DELETE FROM t_author WHERE id = ? ;";
        return update(sql, authorId);
    }

    /**
     * 更新作者信息
     *
     * @param author : 作者对象
     * @return: 执行sql受影响的行数
     */
    @Override
    public int updateAuthor(Author author) {
        String sql = "UPDATE t_author SET `name` = ?, brief = ? WHERE id = ?;";
        return update(sql, author.getName(), author.getBrief(), author.getId());
    }

    /**
     * 查询所有的作者
     *
     * @return: 由所有作者对象组成的list集合
     */
    @Override
    public List<Author> queryAllAuthor() {
        String sql = "SELECT id, `name`, brief FROM t_author ORDER BY id;";
        return getBeanList(sql);
    }

    /**
     * 查询指定ID的作者
     *
     * @param authorId :
     * @return:
     */
    @Override
    public Author queryAuthorById(int authorId) {
        String sql = "SELECT id, `name`, brief FROM t_author WHERE id = ?;";
        return getBean(sql, authorId);
    }

    /**
     * 检查用户ID是否有效
     *
     * @param authorId
     * @return
     */
    @Override
    public boolean isValidAuthorId(int authorId) {
        String sql = "SELECT COUNT(id) FROM t_author WHERE id = ?;";
        long count = getValue(sql, authorId);
        return count != 0;
    }

    /**
     * 查询author对象是否存在
     *
     * @param author
     * @return true: 存在
     * false: 不村子
     */
    @Override
    public boolean isValidAuthorByAuthor(Author author) {
        if (author == null || author.getName() == null || author.getName().isEmpty()) {
            return false;
        }
        // author.id有效情况
        if (author.getId() > 0) {
            return isValidAuthorId(author.getId());
        }
        // 检查name、brief是否有效
        String sql = "SELECT COUNT(id) FROM t_author WHERE `name` = ? AND brief <=> ?;";
        long count = getValue(sql, author.getName(), author.getBrief());
        return count != 0;
    }

    /**
     * 给定的多个作者ID是否全部有效
     *
     * @param idSet 由多个作者ID组成的Set集合
     * @return true: 是全部有效
     * false: 不是全部都有效
     */
    @Override
    public boolean isValidAuthorsId(Set<Integer> idSet) {
        if (idSet == null || idSet.isEmpty() || idSet.contains(null)) {
            return false;
        }
        String beanSetParamerts = CommonUtils.getBeanSetParamerts(idSet);
        String sql = String.format("SELECT COUNT(id) FROM t_author WHERE id IN (%s);", beanSetParamerts);
        long count = getValue(sql, idSet.toArray());
        return count == idSet.size();
    }

    /**
     * 查找作者名中包含指定关键字的作者
     *
     * @param nameKey
     * @return
     */
    @Override
    public List<Author> queryAuthorByNameKey(String nameKey) {
        if (nameKey == null || nameKey.length() == 0) {
            return null;
        }
//        String sql = "SELECT id, `name`, brief FROM t_author WHERE `name` LIKE ‘%?%’;"; // 这样写，表示不需要参数
        String sql = "SELECT id, `name`, brief FROM t_author WHERE `name` LIKE ?;"; // 正确写法
        // 模糊查询关键字拼接
        String key = "%" + nameKey + "%";
        return getBeanList(sql, key);
    }

    /**
     * 通过作者ID集合查询作者信息
     *
     * @param idSet 由作者ID组成的Set对象
     * @return
     */
    @Override
    public List<Author> queryAuthorByIdSet(Set<Integer> idSet) {
        if (idSet == null) {
            return null;
        }
        // 去掉null元素要
        idSet.remove(null);
        if (idSet.isEmpty()) {
            return null;
        }
        // 拼接in (set) 中元素?占位
        // 如：
        // in (?, ?, ?)，需要括号里的内容：?, ?, ?
        String parametersStr = "";
        int i = 0;
        for (Integer id : idSet) {
            ++i;
            if (i == idSet.size()) {
                parametersStr += "?";
            } else {
                parametersStr += "?" + ", ";
            }
        }
        Object[] paramertsList = idSet.toArray();
        String sql = String.format("SELECT id, `name`, brief FROM t_author WHERE id IN (%s);", parametersStr);
//        System.out.println(parametersStr);
        return getBeanList(sql, paramertsList);
    }
}
