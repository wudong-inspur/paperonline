package com.sp.questionnaire.entity.view;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * description:
 * Author:Xiaowanwan
 * Date:2018/9/17-10:39
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class DataPaperViewQuestion {
    private String id;
    private Integer questionType;
    private String questionTitle;
    private List<String> questionOption;
    private List<Object> answerContent;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getQuestionType() {
		return questionType;
	}
	public void setQuestionType(Integer questionType) {
		this.questionType = questionType;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public List<String> getQuestionOption() {
		return questionOption;
	}
	public void setQuestionOption(List<String> questionOption) {
		this.questionOption = questionOption;
	}
	public List<Object> getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(List<Object> answerContent) {
		this.answerContent = answerContent;
	}
    
}
