package com.sp.questionnaire.entity.view;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * description:返回所有Paper类的中间类，返回的是这个类的对象 Author:Xiaowanwan Date:2018/9/16-15:17
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class PaperQueryView {
	private String id;// 试卷ID
	private String title;// 试卷标题
	// private String userId;//用户ID，外键
	private Integer status;// 状态值：0：未发布1：已发布2：已结束
	private Long createTime;// 试卷创建时间
	private String startTime;// 开始时间
	private String endTime;// 结束时间

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
