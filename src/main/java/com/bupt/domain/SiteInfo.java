package com.bupt.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @author yaosiyu
 *
 */

@Entity
@Table(name = "site_info", schema = "disaster-recovery", catalog = "")
public class SiteInfo {
	private String id;
	private String code;
	private String name;
	private String stationMaster;
	private String personNumber;
	private String propertyNumber;
	private String chargeUnit;
	private String carNumber;
	private String status;
	private String place;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createTime;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "ID", nullable = false)
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

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "STATION_MASTER")
	public String getStationMaster() {
		return stationMaster;
	}

	public void setStationMaster(String stationMaster) {
		this.stationMaster = stationMaster;
	}

	@Column(name = "PERSON_NUMBER")
	public String getPersonNumber() {
		return personNumber;
	}

	public void setPersonNumber(String personNumber) {
		this.personNumber = personNumber;
	}

	@Column(name = "PROPERTY_NUMBER")
	public String getPropertyNumber() {
		return propertyNumber;
	}

	public void setPropertyNumber(String propertyNumber) {
		this.propertyNumber = propertyNumber;
	}

	@Column(name = "CHARGE_UNIT")
	public String getChargeUnit() {
		return chargeUnit;
	}

	public void setChargeUnit(String chargeUnit) {
		this.chargeUnit = chargeUnit;
	}

	@Column(name = "CAR_NUMBER")
	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name = "PLACE")
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	
	@Column(name = "CREATE_TIME")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
