package com.example.hello.entity;

import org.hibernate.id.IncrementGenerator;

import javax.persistence.*;

@Entity
public class StudentEntity {

    @Column(name = "sid")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;

    @Column(name = "sName")
    private String sName;

    @Column(name = "age")
    private int age;

    @Column(name = "contactNo")
    private long contactNo;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getContactNo() {
        return contactNo;
    }

    public void setContactNo(long contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "sid='" + sid + '\'' +
                ", sName='" + sName + '\'' +
                ", age=" + age +
                ", contactNo=" + contactNo +
                '}';
    }
}
