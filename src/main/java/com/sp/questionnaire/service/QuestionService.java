package com.sp.questionnaire.service;

import com.sp.questionnaire.entity.Question;

import java.util.List;

/**
 * description:
 * Author:Xiaowanwan
 * Date:2018/9/13-16:18
 */
public interface QuestionService {
    /**
     * 查询所有的Question,返回List<Question>
     *
     * @return
     */
    public List<Question> queryQuestion();

    /**
     * 根据试卷的ID查询该试卷所有的Question
     *
     * @param paperId
     * @return
     */
    public List<Question> queryQusetionByPaperId(String paperId);

    /**
     * 根据id查询Question
     *
     * @param id
     * @return
     */
    public Question queryQuestionById(String id);

    /**
     * 插入一个Question
     *
     * @param question
     * @return
     */
    public boolean insertQuestion(Question question);

    /**
     * 根据id更新该Question
     *
     * @param question
     * @return
     */
    public boolean updateQuestion(Question question);

    /**
     * 根据id删除该Question
     *
     * @param id
     * @return
     */
    public boolean deleteQuestion(String id);

    /**
     * 根据paperId删除question
     *
     * @param id
     * @return
     */
    public boolean deleteQuestionsByPaperId(String id);

    /**
     * 根据paperId和问题的类型获取questions
     *
     * @param id
     * @return
     */
    public List<Question> getQuestionsByPaperIdAndQuestionType(String id, Integer questionType);
}
