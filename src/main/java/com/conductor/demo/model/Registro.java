package com.conductor.demo.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "registro")
public class Registro {

	/**
	*
	* (Required)
	*
	*/
	@Id
	@NotNull
	private Long logic;
	/**
	*
	* (Required)
	*
	*/
	@NotEmpty
	private String serial;
	@NotEmpty
	private String model;
	
	@Min(0)
	@NotNull
	private Long sam;
	@NotEmpty
	private String ptid;
	@NotNull
	private Long plat;
	/**
	*
	* (Required)
	*
	*/
	@NotEmpty
	private String version;
	@NotNull
	private Long mxr;
	@NotNull
	private Long mxf;
	
	@NotEmpty
	private String verfm;

	/**
	*
	* (Required)
	*
	*/
	

	public Long getMxf() {
		return mxf;
	}

	public void setMxf(Long mxf) {
		this.mxf = mxf;
	}
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	public Long getLogic() {
	return logic;
	}

	/**
	*
	* (Required)
	*
	*/
	public void setLogic(Long logic) {
	this.logic = logic;
	}

	/**
	*
	* (Required)
	*
	*/
	public String getSerial() {
	return serial;
	}

	/**
	*
	* (Required)
	*
	*/
	public void setSerial(String serial) {
	this.serial = serial;
	}

	public Long getSam() {
	return sam;
	}

	public void setSam(Long sam) {
	this.sam = sam;
	}

	public String getPtid() {
	return ptid;
	}

	public void setPtid(String ptid) {
	this.ptid = ptid;
	}

	public Long getPlat() {
	return plat;
	}

	public void setPlat(Long plat) {
	this.plat = plat;
	}

	/**
	*
	* (Required)
	*
	*/
	public String getVersion() {
	return version;
	}

	/**
	*
	* (Required)
	*
	*/
	public void setVersion(String version) {
	this.version = version;
	}

	public Long getMxr() {
	return mxr;
	}

	public void setMxr(Long mxr) {
	this.mxr = mxr;
	}

	public String getVerfm() {
	return verfm;
	}

	public void setVerfm(String verfm) {
	this.verfm = verfm;
	}

	@Override
	public int hashCode() {
	int result = 1;
	result = ((result* 31)+((this.verfm == null)? 0 :this.verfm.hashCode()));
	result = ((result* 31)+((this.serial == null)? 0 :this.serial.hashCode()));
	result = ((result* 31)+((this.mxr == null)? 0 :this.mxr.hashCode()));
	result = ((result* 31)+((this.logic == null)? 0 :this.logic.hashCode()));
	result = ((result* 31)+((this.ptid == null)? 0 :this.ptid.hashCode()));
	result = ((result* 31)+((this.plat == null)? 0 :this.plat.hashCode()));
	result = ((result* 31)+((this.version == null)? 0 :this.version.hashCode()));
	result = ((result* 31)+((this.sam == null)? 0 :this.sam.hashCode()));
	return result;
	}

	@Override
	public boolean equals(Object other) {
	if (other == this) {
	return true;
	}
	if ((other instanceof Registro) == false) {
	return false;
	}
	Registro rhs = ((Registro) other);
	return (((((((((this.verfm == rhs.verfm)||((this.verfm!= null)&&this.verfm.equals(rhs.verfm)))&&((this.serial == rhs.serial)||((this.serial!= null)&&this.serial.equals(rhs.serial))))&&((this.mxr == rhs.mxr)||((this.mxr!= null)&&this.mxr.equals(rhs.mxr))))&&((this.logic == rhs.logic)||((this.logic!= null)&&this.logic.equals(rhs.logic))))&&((this.ptid == rhs.ptid)||((this.ptid!= null)&&this.ptid.equals(rhs.ptid))))&&((this.plat == rhs.plat)||((this.plat!= null)&&this.plat.equals(rhs.plat))))&&((this.version == rhs.version)||((this.version!= null)&&this.version.equals(rhs.version))))&&((this.sam == rhs.sam)||((this.sam!= null)&&this.sam.equals(rhs.sam))));
	}

	}