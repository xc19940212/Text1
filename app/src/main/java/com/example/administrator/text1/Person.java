package com.example.administrator.text1;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by Administrator on 2016/12/8.
 */
@Table(name="my_db")
public class Person {
    @Column(name="id",isId = true)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="age")
    private int age;
    @Column(name="gender")
    private String gender;
    public Person() {

    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
