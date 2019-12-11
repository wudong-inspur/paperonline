package com.sp.questionnaire.entity.view;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 * Author:Xiaowanwan
 * Date:2018/9/16-18:22
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class AddPaperViewPaper {
    private String title;
    private String startTime;
    private String endTime;
    private Integer status;
    private List<AddPaperViewQuestion> questions;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public List<AddPaperViewQuestion> getQuestions() {
		return questions;
	}
	public void setQuestions(List<AddPaperViewQuestion> questions) {
		this.questions = questions;
	}
}
