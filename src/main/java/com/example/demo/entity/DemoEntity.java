package com.example.demo.entity;

import java.io.Serializable;

public class DemoEntity implements Serializable {
    private static final long serialVersionUID = 4676210938649473427L;
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DemoEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
