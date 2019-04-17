package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: mideming
 * @create: 2019-04-17 10:50
 **/
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = -7572944830253243280L;
    private Date createTime;

    private Date updateTime = new Date();

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "createTime=" + createTime +
                ", updateTime=" + updateTime +
                "}";
    }
}
