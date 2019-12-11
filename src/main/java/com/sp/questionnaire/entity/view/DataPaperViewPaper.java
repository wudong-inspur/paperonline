package com.sp.questionnaire.entity.view;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * description:
 * Author:Xiaowanwan
 * Date:2018/9/17-10:23
 */

@Setter
@Getter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class DataPaperViewPaper {
    private String id;
    private String title;
    private Integer status;
    private Long createTime;
    private String startTime;
    private String endTime;
    private Integer totalCount;
    private List<DataPaperViewQuestion> questions;
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
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public List<DataPaperViewQuestion> getQuestions() {
		return questions;
	}
	public void setQuestions(List<DataPaperViewQuestion> questions) {
		this.questions = questions;
	}

}
