package com.java.www;

import com.google.gson.reflect.TypeToken;
import com.java.bean.Person;

import java.util.ArrayList;


/**
 * 用于json字符串转包含Person对象的List集合的类型
 *
 */
public class PersonListType extends TypeToken<ArrayList<Person>> {

}
