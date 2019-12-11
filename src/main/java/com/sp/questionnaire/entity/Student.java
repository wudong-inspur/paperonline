package com.sp.questionnaire.entity;


import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

/*
 * Author: Seven
 * Email : cpwu@foxmail.com
 * 2018-07-20 星期五 23:40
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String stdNumber;
    private String name;
    private Integer age;
    private Date birth;
	public String getStdNumber() {
		return stdNumber;
	}
	public void setStdNumber(String stdNumber) {
		this.stdNumber = stdNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
}
