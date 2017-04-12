package com.bupt.domain;

import com.bupt.common.base.DomainEntity;

import javax.persistence.Column;

/**
 * Created by bupt626 on 17-4-12.
 */
public class UserInfo extends DomainEntity {

    private String userName;
    private String password;
    private String name;
    private String mobilePhone;
    private Integer position;
    private Integer educational;
    private String professional;
    private String status;
    private String siteInfoId;

    @Column(name = "USER_NAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "MOBILE_PHONE")
    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getEducational() {
        return educational;
    }

    public void setEducational(Integer educational) {
        this.educational = educational;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @Column(name = "SITE_INFO_ID")
    public String getSiteInfoId() {
        return siteInfoId;
    }

    public void setSiteInfoId(String siteInfoId) {
        this.siteInfoId = siteInfoId;
    }
}
