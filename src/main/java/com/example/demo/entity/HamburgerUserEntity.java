package com.example.demo.entity;

import java.io.Serializable;

/**
 * @description:
 * @author: mideming
 * @create: 2019-04-17 10:18
 **/
public class HamburgerUserEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -2197320433652923539L;
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 用户手机号
     */
    private String userMobile;

    /**
     * 用户描述
     */
    private String userDescription;

    /**
     * 用户logo
     */
    private String userLogo;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    public String getUserLogo() {
        return userLogo;
    }

    public void setUserLogo(String userLogo) {
        this.userLogo = userLogo;
    }

    @Override
    public String toString() {
        return "HamburgerUserEntity{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", userDescription='" + userDescription + '\'' +
                ", userLogo='" + userLogo + '\'' +
                '}';
    }
}
