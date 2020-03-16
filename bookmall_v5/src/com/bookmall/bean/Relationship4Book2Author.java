package com.bookmall.bean;


/**
 * 图书与作者关系
 */
public class Relationship4Book2Author {
    private Integer id;
    private Integer bookId;
    private Integer authorId;

    // 构造器
    public Relationship4Book2Author() {}

    public Relationship4Book2Author(Integer id, Integer bookId, Integer authorId) {
        this.id = id;
        this.bookId = bookId;
        this.authorId = authorId;
    }

    // 方法
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "Relationship4Book2Author{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", authorId=" + authorId +
                '}';
    }
}
