package com.sp.questionnaire.entity;

public class KinShip {
	
	/** 主鍵. */
	private String id;
	
	/** 指示者ID. */
	private String pointManId;
	
	/** 亲缘关系代码. */
	private String kinShipCode;
	
	/** 亲缘关系录入代码. */
	private String kinShipInputCode;
	
	/** 名称. */
	private String name;
	
	/** 性别. */
	private String sex;
	
	/** 出生日期. */
	private String birthDate;
	
	/** 身份证号码. */
	private String idCardNo;
	
	/** 备注. */
	private String remark;
	
	/** 是否在本村. */
	private boolean inCountry;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the pointManId
	 */
	public String getPointManId() {
		return pointManId;
	}

	/**
	 * @param pointManId the pointManId to set
	 */
	public void setPointManId(String pointManId) {
		this.pointManId = pointManId;
	}

	/**
	 * @return the kinShipCode
	 */
	public String getKinShipCode() {
		return kinShipCode;
	}

	/**
	 * @param kinShipCode the kinShipCode to set
	 */
	public void setKinShipCode(String kinShipCode) {
		this.kinShipCode = kinShipCode;
	}

	/**
	 * @return the kinShipInputCode
	 */
	public String getKinShipInputCode() {
		return kinShipInputCode;
	}

	/**
	 * @param kinShipInputCode the kinShipInputCode to set
	 */
	public void setKinShipInputCode(String kinShipInputCode) {
		this.kinShipInputCode = kinShipInputCode;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
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
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the birthDate
	 */
	public String getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the idCardNo
	 */
	public String getIdCardNo() {
		return idCardNo;
	}

	/**
	 * @param idCardNo the idCardNo to set
	 */
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the inCountry
	 */
	public boolean isInCountry() {
		return inCountry;
	}

	/**
	 * @param inCountry the inCountry to set
	 */
	public void setInCountry(boolean inCountry) {
		this.inCountry = inCountry;
	}
	
}
