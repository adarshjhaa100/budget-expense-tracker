package com.tcsc.budgetAndExpense.entity;

import org.hibernate.Hibernate;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name",length = 100, nullable = false)
    private String name;
    @Column(name = "description",length = 255)
    private String desc;
    @Column(name="user_id")
    private int userId;

    public Product() {
    }

    public Product(int id, String name, String desc, int userId) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.userId = userId;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
