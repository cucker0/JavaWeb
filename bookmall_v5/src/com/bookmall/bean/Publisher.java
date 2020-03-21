package com.bookmall.bean;

/**
 * 出版社
 */
public class Publisher {
    private int id;
    // 出版社名称
    private String name;
    // 用于html前面显示是否选中，true: 选中，false: 不选中(默认值)
    private boolean checked = false;

    // 构造器
    public Publisher() {}

    public Publisher(int id, String name) {
        this.id = id;
        this.name = name;
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

        Publisher publisher = (Publisher) o;

        return name != null ? name.equals(publisher.name) : publisher.name == null;

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", checked=" + checked +
                '}';
    }
}
