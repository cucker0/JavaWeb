package com.bookmall.dao;

import com.bookmall.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 事务型基本操作的Dao
 * 自动关闭connection的事务自动提交，autocommit = 0
 *
 * @param <T>: 类型
 */
public abstract class BaseDao4Transaction<T> {
    private QueryRunner queryRunner;
    // 泛型T的类型
    private Class<T> type;

    // 构造器
    public BaseDao4Transaction() {
        queryRunner = new QueryRunner();

        // 获取T的类型
        Class clazz = this.getClass();
        ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
        Type[] types = parameterizedType.getActualTypeArguments();
        if (types.length > 0) {
            this.type = (Class<T>) types[0];
        } else {
            this.type = null;
        }
    }

    // 方法

    /**
     * 获取数据库连接，关闭事务自动提交
     */
    protected Connection getConnection() {
        return C3p0Utils.getConnection(false);
    }

    /**
     * 释放threadLocal存放的connection数据库连接
     */
    protected void release() {
        C3p0Utils.release(getConnection());
    }

    /**
     * 通用的SQL更新操作(INSERT,UPDATE,DELETE)，适用于事务
     *
     * @param sql:    可含?占位符的SQL语句
     * @param params: ?占位符对应的可变参数
     * @return: 执行sql语句受影响的行数
     * <p>
     * 注意：需要传入Connection连接对象的方法，适用于事务，Connection在提交事务或回滚事务时释放回连接池。下同
     */
    public int update(String sql, Object... params) {
        Connection conn = getConnection();
        int rows = 0;
        try {
            rows = queryRunner.update(conn, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return rows;
    }

    /**
     * 执行插入一条记录，并获取自增ID值
     *
     * @param sql:    可含?占位符的SQL语句
     * @param params: ?占位符对应的可变参数
     * @return: 自增ID值
     */
    public Integer insert(String sql, Object... params) {
        Connection conn = getConnection();
        BigInteger auto_increment_id = null;
        try {
            auto_increment_id = queryRunner.insert(conn, sql, new ScalarHandler<>(), params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return auto_increment_id == null ? null : auto_increment_id.intValue();
    }

    /**
     * 执行查询SQL获取第一行，并转为一个Bean对象
     *
     * @param sql:    可含?占位符的SQL语句
     * @param params: ?占位符对应的可变参数
     * @return: T的Bean对象
     * 如果查询结果为空，则返回null
     */
    public T getBean(String sql, Object... params) {
        Connection conn = getConnection();
        T bean = null;
        try {
            bean = queryRunner.query(conn, sql, new BeanHandler<T>(type), params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return bean;
    }

    /**
     * 执行查询SQL获取所有行，每行并转为转为一个Bean对象，这些Bean对象组成一个List并返回
     *
     * @param sql:    可含?占位符的SQL语句
     * @param params: ?占位符对应的可变参数
     * @return: T的Bean对象组成的List
     * 如果查询结果为空，则返回null
     */
    public List<T> getBeanList(String sql, Object... params) {
        Connection conn = getConnection();
        List<T> list = null;
        try {
            list = queryRunner.query(conn, sql, new BeanListHandler<T>(type), params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list;
    }

    /**
     * 执行返回一个值的SQL查询语句
     * <p>
     * 可用来执行像 select count(*) from ...这样的sql语句
     *
     * @param sql:    可含?占位符的SQL语句
     * @param params: ?占位符对应的可变参数
     * @return: 返回查询SQL执行后返回的单一的值
     */
    public <E> E getValue(String sql, Object... params) {
        Connection conn = getConnection();
        E val = null;
        try {
            val = queryRunner.query(conn, sql, new ScalarHandler<>(), params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return val;
    }

    /**
     * 批量处理的方法
     * 如批量更新
     *
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    public int[] batch(String sql, Object[][] params) {
        Connection conn = getConnection();
        int[] ints = new int[0];
        try {
            ints = queryRunner.batch(conn, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return ints;
    }
}