package com.bupt.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

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
    private Date createTime;
    private String siteInfoId;
    private RoleInfo roleInfo;
    private java.sql.Date birthday;
    private String email;
    private String sex;
    //游离态字段
    private String educationalName;
    private String positionName;
    private String siteCode;
    private String siteName;


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

    public UserInfo() {
    }

    public UserInfo(UserInfo userInfo) {
        this.id = userInfo.getId();
        this.userName = userInfo.getUserName();
        this.password = userInfo.getPassword();
        this.name = userInfo.getName();
        this.mobilePhone = userInfo.getMobilePhone();
        this.position = userInfo.getPosition();
        this.educational = userInfo.getEducational();
        this.professional = userInfo.getProfessional();
        this.status = userInfo.getStatus();
        this.siteInfoId = userInfo.getSiteInfoId();
        this.roleInfo = userInfo.getRoleInfo();
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATE_TIME")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    @Transient
    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
    @Transient
    public String getEducationalName() {
        return educationalName;
    }

    public void setEducationalName(String educationalName) {
        this.educationalName = educationalName;
    }
    @Transient
    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }
    @Transient
    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    @Column(name = "BIRTHDAY")
    public java.sql.Date getBirthday() {
        return birthday;
    }

    public void setBirthday(java.sql.Date birthday) {
        this.birthday = birthday;
    }
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name = "SEX")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
