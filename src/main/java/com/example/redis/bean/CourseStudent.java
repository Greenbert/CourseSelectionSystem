package com.example.redis.bean;

import java.io.Serializable;

public class CourseStudent implements Serializable {
    private int num;
    private String stuid;
    private String couid;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getCouid() {
        return couid;
    }

    public void setCouid(String couid) {
        this.couid = couid;
    }
}
