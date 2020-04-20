package com.bookmall.bean;

/**
 * 图书作者
 */
public class Author {
    private int id; // 默认值为0
    private String name;
    // 作者简介
    private String brief;
    // 用于html前面显示是否选中，true: 选中，false: 不选中(默认值)
    private boolean checked = false;

    // 构造器
    public Author() {}

    public Author(int id, String name, String brief) {
        this.id = id;
        this.name = name;
        this.brief = brief;
    }

    // 方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (name != null ? !name.equals(author.name) : author.name != null) return false;
        return brief != null ? brief.equals(author.brief) : author.brief == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (brief != null ? brief.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brief='" + brief + '\'' +
                ", checked=" + checked +
                '}';
    }
}
