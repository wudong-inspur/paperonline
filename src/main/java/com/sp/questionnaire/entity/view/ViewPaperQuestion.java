package com.sp.questionnaire.entity.view;

import lombok.*;
import lombok.experimental.Accessors;
import net.sf.json.JSONArray;

import java.util.List;

/**
 * description:查看问卷所定义的中间Question类，页面返回的是这个类对象 Author:Xiaowanwan
 * Date:2018/9/16-16:01
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class ViewPaperQuestion {
	private String id;
	private Integer questionType;
	private String questionTitle;
	private List<String> questionOption;

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

}
