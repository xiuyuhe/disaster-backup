package com.bupt.domain;
import com.bupt.common.base.DomainEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.security.Timestamp;

/**
 * Created by wang on 2017/4/13.
 */
@Entity
@Table(name = "equipment_info")
public class EquipmentInfo
{
    private String id ;
    private String code;
    private String type;
    private String status;
    private String siteInfoId;
    private Timestamp crateTime;

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

    @Column(name = "CODE")
    public String getCode() {
        return code;
    }
    public void setCode(String code) {this.code = code;}

    @Column(name = "TYPE")
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
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

    @Column(name = "CRATE_TIME")
    public Timestamp getCrateTime() {
        return crateTime;
    }
    public void setCrateTime(Timestamp crateTime) {
        this.crateTime = crateTime;
    }

}