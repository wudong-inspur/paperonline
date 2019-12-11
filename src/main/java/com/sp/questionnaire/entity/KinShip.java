package com.sp.questionnaire.entity;

public class Kinship {

	/** 主鍵. */
	private String id;

	/** 指示者代码. */
	private String pointmanNo;

	/** 亲缘关系代码. */
	private String kinshipCode;

	/** 亲缘关系录入代码. */
	private String kinshipInputCode;

	/** 名称. */
	private String name;

	/** 性别. */
	private String sex;

	/** 出生日期. */
	private String birthdate;

	/** 身份证号码. */
	private String idcardNo;

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
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the pointmanNo
	 */
	public String getPointmanNo() {
		return pointmanNo;
	}

	/**
	 * @param pointmanNo
	 *            the pointmanNo to set
	 */
	public void setPointmanNo(String pointmanNo) {
		this.pointmanNo = pointmanNo;
	}

	/**
	 * @return the kinshipCode
	 */
	public String getKinshipCode() {
		return kinshipCode;
	}

	/**
	 * @param kinshipCode
	 *            the kinshipCode to set
	 */
	public void setKinshipCode(String kinshipCode) {
		this.kinshipCode = kinshipCode;
	}

	/**
	 * @return the kinshipInputCode
	 */
	public String getKinshipInputCode() {
		return kinshipInputCode;
	}

	/**
	 * @param kinshipInputCode
	 *            the kinshipInputCode to set
	 */
	public void setKinshipInputCode(String kinshipInputCode) {
		this.kinshipInputCode = kinshipInputCode;
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
	 * @return the birthdate
	 */
	public String getBirthdate() {
		return birthdate;
	}

	/**
	 * @param birthdate
	 *            the birthdate to set
	 */
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * @return the idcardNo
	 */
	public String getIdcardNo() {
		return idcardNo;
	}

	/**
	 * @param idcardNo
	 *            the idcardNo to set
	 */
	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark
	 *            the remark to set
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
	 * @param inCountry
	 *            the inCountry to set
	 */
	public void setInCountry(boolean inCountry) {
		this.inCountry = inCountry;
	}

}
