package com.bupt.domain;

import com.bupt.common.base.DomainEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by bupt626 on 17-4-12.
 */
@Entity
@Table(name = "user_info")
public class UserInfo  {

    private String id;
    private String userName;
    private String password;
    private String name;
    private String mobilePhone;
    private Integer position;
    private Integer educational;
    private String professional;
    private String status;
    private String siteInfoId;


    private RoleInfo roleInfo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roleId")
    public RoleInfo getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(RoleInfo roleInfo) {
        this.roleInfo = roleInfo;
    }

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name="ID", nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "USER_NAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name = "NAME")
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
    @Column(name = "POSITION")
    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
    @Column(name = "EDUCATIONAL")
    public Integer getEducational() {
        return educational;
    }

    public void setEducational(Integer educational) {
        this.educational = educational;
    }
    @Column(name = "PROFESSIONAL")
    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }
    @Column(name = "STATUS")
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
