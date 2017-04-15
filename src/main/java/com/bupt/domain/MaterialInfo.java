package com.bupt.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.GenericGenerator;

/**
 * 物资信息表
 * 
 * @author yaosiyu
 *
 */

@Entity
@Table(name = "material_info", schema = "disaster-recovery", catalog = "")
public class MaterialInfo {
	private String id;
	private String code; // 物资编码
	private String parentTypeCode; // 种类(中类)
	private String typeCode; // 种类(小类)
	private String name; // 名称
	private String size; // 规格
	private String count; // 数量
	private Date createTime; // 生产日期
	private String serviceCycle; // 固定保养周期
	private String shelfLife; // 保质期
	private Date lastServiceTime; // 上次保养日期
	private String serviceUser; // 经办人
	private String siteInfoId; // 所属站点编号
	private String source; // 物资来源
	private Date lastListTime; // 上次盘点日期
	private String status; // 设备状态

	// 游离态属性
	private String siteCode; // 所属站点编号
	private String siteName; // 所属站点名称

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "ID")
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

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "TYPE_CODE")
	public String getTypeCode() {
		return typeCode;
	}

	@Column(name = "PARENT_TYPE_CODE")
	public String getParentTypeCode() {
		return parentTypeCode;
	}

	public void setParentTypeCode(String parentTypeCode) {
		this.parentTypeCode = parentTypeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "SIZE")
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Column(name = "COUNT")
	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_TIME")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "SERVICE_CYCLE")
	public String getServiceCycle() {
		return serviceCycle;
	}

	public void setServiceCycle(String serviceCycle) {
		this.serviceCycle = serviceCycle;
	}

	@Column(name = "SHELF_LIFE")
	public String getShelfLife() {
		return shelfLife;
	}

	public void setShelfLife(String shelfLife) {
		this.shelfLife = shelfLife;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_SERVICE_TIME")
	public Date getLastServiceTime() {
		return lastServiceTime;
	}

	public void setLastServiceTime(Date lastServiceTime) {
		this.lastServiceTime = lastServiceTime;
	}

	@Column(name = "SERVICE_USER")
	public String getServiceUser() {
		return serviceUser;
	}

	public void setServiceUser(String serviceUser) {
		this.serviceUser = serviceUser;
	}

	@Column(name = "SITE_INFO_ID")
	public String getSiteInfoId() {
		return siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	@Column(name = "SOURCE")
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_LIST_TIME")
	public Date getLastListTime() {
		return lastListTime;
	}

	public void setLastListTime(Date lastListTime) {
		this.lastListTime = lastListTime;
	}

	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

}
