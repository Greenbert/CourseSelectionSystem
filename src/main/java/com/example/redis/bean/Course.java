package com.example.redis.bean;

import java.io.Serializable;

public class Course implements Serializable {
    private String couid;
    private String name;
    private int xf;
    private int xs;
    private int capacity;
    private int left;

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public String getCouid() {
        return couid;
    }

    public void setCouid(String couid) {
        this.couid = couid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getXf() {
        return xf;
    }

    public void setXf(int xf) {
        this.xf = xf;
    }

    public int getXs() {
        return xs;
    }

    public void setXs(int xs) {
        this.xs = xs;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Course{" +
                "couid='" + couid + '\'' +
                ", name='" + name + '\'' +
                ", xf=" + xf +
                ", xs=" + xs +
                ", capacity=" + capacity +
                ", left=" + left +
                '}';
    }
}
