package com.java.el.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Person {
    private int id;
    private String[] arr;
    private List<String> list;
    private Map<String, String> map;

    public Person() {}

    public Person(int id, String[] arr, List<String> list, Map<String, String> map) {
        this.id = id;
        this.arr = arr;
        this.list = list;
        this.map = map;
    }

    // 方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getArr() {
        return arr;
    }

    public void setArr(String[] arr) {
        this.arr = arr;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", arr=" + Arrays.toString(arr) +
                ", list=" + list +
                ", map=" + map +
                '}';
    }
}
