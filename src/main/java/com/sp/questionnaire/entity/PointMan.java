package com.sp.questionnaire.entity;

import java.util.Date;
import java.util.List;

/**
 * 指标指示者. The Class PointMan.
 */
public class PointMan {

	/** 主键. */
	private String id;

	/** 地址：乳山市 乡镇 村（居委会） */
	private String addr;

	/** 填表人. */
	private String inputUser;

	/** 填表日期. */
	private Date inputDate;

	/** 指示者编号. */
	private String pointManNo;

	/** 姓名. */
	private String name;

	/** 性别. */
	private String sex;

	/** 健康状况. */
	private String healthy;

	/** 是否从本村迁出. */
	private String inCurrentCountry;

	/** 出生日期. */
	private String birthDate;

	/** 现住址. */
	private String currentAddr;

	/** 身份证号码. */
	private String idCardNo;

	/** 电话号码. */
	private String mobilePhone;

	/** 是否和其他指示者有亲属关系. */
	private String isOtherPointmanRel;

	/** 其他指示者名称. */
	private String otherPointmanName;

	/** 与其他指示者亲属关系. */
	private String otherPointmanRel;

	/** 本村亲缘关系. */
	private List<Kinship> inKinShips;

	
	/** 外村亲缘关系. */
	private List<Kinship> outKinShips;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the addr
	 */
	public String getAddr() {
		return addr;
	}

	/**
	 * @param addr
	 *            the addr to set
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}

	/**
	 * @return the inputUser
	 */
	public String getInputUser() {
		return inputUser;
	}

	/**
	 * @param inputUser
	 *            the inputUser to set
	 */
	public void setInputUser(String inputUser) {
		this.inputUser = inputUser;
	}

	/**
	 * @return the inputDate
	 */
	public Date getInputDate() {
		return inputDate;
	}

	/**
	 * @param inputDate
	 *            the inputDate to set
	 */
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	/**
	 * @return the pointManNo
	 */
	public String getPointManNo() {
		return pointManNo;
	}

	/**
	 * @param pointManNo
	 *            the pointManNo to set
	 */
	public void setPointManNo(String pointManNo) {
		this.pointManNo = pointManNo;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the healthy
	 */
	public String getHealthy() {
		return healthy;
	}

	/**
	 * @param healthy
	 *            the healthy to set
	 */
	public void setHealthy(String healthy) {
		this.healthy = healthy;
	}

	/**
	 * @return the inCurrentCountry
	 */
	public String getInCurrentCountry() {
		return inCurrentCountry;
	}

	/**
	 * @param inCurrentCountry
	 *            the inCurrentCountry to set
	 */
	public void setInCurrentCountry(String inCurrentCountry) {
		this.inCurrentCountry = inCurrentCountry;
	}

	/**
	 * @return the birthDate
	 */
	public String getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate
	 *            the birthDate to set
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the currentAddr
	 */
	public String getCurrentAddr() {
		return currentAddr;
	}

	/**
	 * @param currentAddr
	 *            the currentAddr to set
	 */
	public void setCurrentAddr(String currentAddr) {
		this.currentAddr = currentAddr;
	}

	/**
	 * @return the idCardNo
	 */
	public String getIdCardNo() {
		return idCardNo;
	}

	/**
	 * @param idCardNo
	 *            the idCardNo to set
	 */
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	/**
	 * @return the mobilePhone
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}

	/**
	 * @param mobilePhone
	 *            the mobilePhone to set
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	/**
	 * @return the isOtherPointmanRel
	 */
	public String getIsOtherPointmanRel() {
		return isOtherPointmanRel;
	}

	/**
	 * @param isOtherPointmanRel
	 *            the isOtherPointmanRel to set
	 */
	public void setIsOtherPointmanRel(String isOtherPointmanRel) {
		this.isOtherPointmanRel = isOtherPointmanRel;
	}

	/**
	 * @return the otherPointmanName
	 */
	public String getOtherPointmanName() {
		return otherPointmanName;
	}

	/**
	 * @param otherPointmanName
	 *            the otherPointmanName to set
	 */
	public void setOtherPointmanName(String otherPointmanName) {
		this.otherPointmanName = otherPointmanName;
	}

	/**
	 * @return the otherPointmanRel
	 */
	public String getOtherPointmanRel() {
		return otherPointmanRel;
	}

	/**
	 * @param otherPointmanRel
	 *            the otherPointmanRel to set
	 */
	public void setOtherPointmanRel(String otherPointmanRel) {
		this.otherPointmanRel = otherPointmanRel;
	}

	/**
	 * @return the inKinShips
	 */
	public List<Kinship> getInKinShips() {
		return inKinShips;
	}

	/**
	 * @param inKinShips the inKinShips to set
	 */
	public void setInKinShips(List<Kinship> inKinShips) {
		this.inKinShips = inKinShips;
	}

	/**
	 * @return the outKinShips
	 */
	public List<Kinship> getOutKinShips() {
		return outKinShips;
	}

	/**
	 * @param outKinShips the outKinShips to set
	 */
	public void setOutKinShips(List<Kinship> outKinShips) {
		this.outKinShips = outKinShips;
	}
}
