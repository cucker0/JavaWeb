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

    // 图书与记录关联记录，只要图书ID与作者ID是相同即是一个相同的关联关系
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Relationship4Book2Author that = (Relationship4Book2Author) o;

        if (bookId != null ? !bookId.equals(that.bookId) : that.bookId != null) return false;
        return authorId != null ? authorId.equals(that.authorId) : that.authorId == null;

    }

    @Override
    public int hashCode() {
        int result = bookId != null ? bookId.hashCode() : 0;
        result = 31 * result + (authorId != null ? authorId.hashCode() : 0);
        return result;
    }
}
