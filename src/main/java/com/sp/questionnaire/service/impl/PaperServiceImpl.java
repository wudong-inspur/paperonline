package com.sp.questionnaire.service.impl;

import com.sp.questionnaire.dao.PaperDao;
import com.sp.questionnaire.entity.Answer;
import com.sp.questionnaire.entity.Paper;
import com.sp.questionnaire.entity.Question;
import com.sp.questionnaire.entity.view.*;
import com.sp.questionnaire.service.AnswerService;
import com.sp.questionnaire.service.PaperService;
import com.sp.questionnaire.service.QuestionService;
import com.sp.questionnaire.utils.CommonUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * description: Author:Xiaowanwan Date:2018/9/13-14:59
 */
@Service
public class PaperServiceImpl implements PaperService {
	// private final static int dataPaperViewQuestionNum = 100;
	@Autowired
	private PaperDao paperDao;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private CommonUtils commonUtils;
	@Autowired
	private AnswerService answerService;
	@Autowired
	private PaperMethodHelp paperMethodHelp;

	@Override
	public List<Paper> queryPaper() {
		return paperDao.queryPaper();
	}

	@Override
	public List<Paper> queryPaperByUserID(String userId) {
		return paperDao.queryPaperByUserID(userId);
	}

	@Override
	public Paper queryPaperByID(String id) {
		return paperDao.queryPaperByID(id);
	}

	@Transactional
	@Override
	public boolean insertPaper(Paper paper) {
		if (paper != null && !"".equals(paper.getId())) {
			try {
				// System.err.println(paper.toString());
				int i = paperDao.insertPaper(paper);
				if (i == 1) {
					return true;
				} else {
					throw new RuntimeException("a:插入试卷失败！" + paper);
				}
			} catch (Exception e) {
				throw new RuntimeException("b:插入试卷失败：" + e.getMessage());
			}
		} else {
			throw new RuntimeException("c:插入试卷失败，Paper的id不能为空！");
		}
	}

	@Transactional
	@Override
	public boolean updatePaper(Paper paper) {
		if (paper != null && !"".equals(paper.getId())) {
			try {
				int i = paperDao.updatePaper(paper);
				if (i == 1) {
					return true;
				} else {
					throw new RuntimeException("a:修改试卷失败！" + paper);
				}
			} catch (Exception e) {
				throw new RuntimeException("b:修改试卷失败：" + e.getMessage());
			}
		} else {
			throw new RuntimeException("c:修改试卷失败，Paper的id不能为空！");
		}
	}

	@Transactional
	@Override
	public boolean deletePaper(String id) {
		if (id != null && !"".equals(id)) {
			try {
				// System.out.println(id);
				int i = paperDao.deletePaper(id);
				if (i == 1) {
					return true;
				} else {
					throw new RuntimeException("a:删除试卷失败！" + id);
				}
			} catch (Exception e) {
				throw new RuntimeException("b:删除试卷失败：" + e.getMessage());
			}
		} else {
			throw new RuntimeException("c:删除试卷失败，Paper的id不能为空！");
		}
	}

	@Override
	public List<Paper> queryPaperByTitle(String title) {
		return paperDao.queryPaperByTitle(title);
	}

	@Transactional
	@Override
	public boolean deleteManyPaper(List<String> id) {
		if (id == null || id.size() <= 0) {
			throw new RuntimeException("c:删除试卷失败，Paper的id不能为空！");
		}
		// int t = id.size();
		for (String i : id) {
			Paper paper = queryPaperByID(i);
			paper.setStatus(3);
			updatePaper(paper);
		}

		return true;
	}

	// 处理Paper的data
	@Transactional
	@Override
	public Object dataPaper(String id) throws ParseException {
		Paper paper = queryPaperByID(id);
		// System.out.println(id);
		// 根据id拿到paper对象
		if (paper != null) {

			// System.out.println("paper" + paper);

			// 返回的数据类型dataPaperViewPaper，包括信息和questions和content
			DataPaperViewPaper dataPaperViewPaper = new DataPaperViewPaper();

			// 对应DataPaperViewPaper里的questions，就是下面的对象数组
			List<DataPaperViewQuestion> questions = new ArrayList<>();
			// 定义上面的List里面的对象数组，必须初始化
			DataPaperViewQuestion dataPaperViewQuestion = new DataPaperViewQuestion();
			// for (int i = 0; i < dataPaperViewQuestionNum; i++) {//初始化数组
			// dataPaperViewQuestion[i] = new DataPaperViewQuestion();
			// }
			int num = 0;// 记录数组下标

			// System.out.println("paperid"+paper.getId());
			// 根据paperId查询相关问题，list1是类型为1的问题组合，list2的问题类型为2，list3为3
			List<Question> list1 = questionService
					.getQuestionsByPaperIdAndQuestionType(paper.getId(), 1);
			List<Question> list2 = questionService
					.getQuestionsByPaperIdAndQuestionType(paper.getId(), 2);
			List<Question> list3 = questionService
					.getQuestionsByPaperIdAndQuestionType(paper.getId(), 3);

			JSONObject json = new JSONObject();
			json.put("id", paper.getId());
			json.put("title", paper.getTitle());
			json.put("status", paper.getStatus());
			json.put("createTime",
					commonUtils.getLongByDate(paper.getCreateTime()));
			json.put("startTime",
					commonUtils.getDateStringByDate(paper.getStartTime()));
			json.put("endTime",
					commonUtils.getDateStringByDate(paper.getEndTime()));
			json.put(
					"totalCount",
					(list1.size() == 0) ? 0 : answerService.countAnswer(id,
							list1.get(0).getId()));

			JSONArray jsonArray = new JSONArray();

			// 先把查询到的基本信息放入结果对象
			dataPaperViewPaper.setId(paper.getId());
			dataPaperViewPaper.setTitle(paper.getTitle());
			dataPaperViewPaper.setStatus(paper.getStatus());
			dataPaperViewPaper.setCreateTime(commonUtils.getLongByDate(paper
					.getCreateTime()));
			dataPaperViewPaper.setStartTime(commonUtils
					.getDateStringByDate(paper.getStartTime()));
			dataPaperViewPaper.setEndTime(commonUtils.getDateStringByDate(paper
					.getEndTime()));
			dataPaperViewPaper.setTotalCount((list1.size() == 0) ? 0
					: answerService.countAnswer(id, list1.get(0).getId()));// 次数先放在这里

			if (list1.size() > 0) {// 问题类型为1--单选题
				for (Question question : list1) {// 处理每一个问题

					// System.out.println("questionOption============"+question.getQuestionOption().substring(1,question.getQuestionOption().length()-1));
					// 定义单选题的选项数组,中间数组
					// System.out.println("___----" +
					// JSONArray.fromObject(question.getQuestionOption()));
					// [java,c,qq,aa]
					// ["java","c","qq","aa"]
					Object[] o = JSONArray.fromObject(
							question.getQuestionOption()).toArray();
					String[] options = new String[o.length];
					for (int i = 0, n = o.length; i < n; i++) {
						options[i] = o[i].toString();
					}
					// 定义单选题的List对象，用来存QuestionOption。其实对应的就是结果数据下面的questions下的用来存QuestionOption
					List<String> a = new ArrayList<>();
					Collections.addAll(a, options);// 数组添加到集合里面去

					// 定义答案的集合，获取AnswerContent集合，放入b中
					List<Object> b = new ArrayList<>();
					List<Answer> listAnswer = answerService
							.queryAnswerByQuestionId(question.getId());
					// String option =
					// question.getQuestionOption();//获取到了数据库中的QuestionOption
					// [java,c,qq,aa]
					// System.out.println(option);
					// String[] ops = {"a", "b", "c"};
					// String[] ops = option.substring(1, option.length() -
					// 1).split(",");

					// 定义答案统计数组，长度是对应问题选项的长度
					int[] ansContent = new int[options.length];

					/*
					 * for (int i=0,n=options.length;i<n;i++){
					 * System.out.println("看看options："+options[i]); }
					 */

					for (Answer an : listAnswer) {// 遍历答案,记录answerContent
						// System.out.println(an.getAnswerContent());
						for (int i = 0, n = options.length; i < n; i++) {
							// System.out.println("看看answerContent"+an.getAnswerContent());
							if (an.getAnswerContent().length() > 4) {
								if (an.getAnswerContent()
										.substring(
												2,
												an.getAnswerContent().length() - 2)
										.equals(options[i])) {
									// 满足条件就累加答案统计数组
									ansContent[i]++;
								}
							}
						}
					}

					// 把答案统计数组放入对应结果对象的Questions下的answerContent 的b中
					Collections.addAll(b, ansContent);

					JSONArray ja = new JSONArray();// 选项
					ja.addAll(JSONArray.fromObject(options));
					JSONArray jTimes = new JSONArray();// 被选次数
					jTimes.addAll(JSONArray.fromObject(ansContent));

					JSONObject jo = new JSONObject();
					jo.put("id", question.getId());
					jo.put("questionType", 1);
					jo.put("questionTitle", question.getQuestionTitle());
					jo.put("questionOption", ja);// 选项
					jo.put("answerContent", jTimes);// 选项被选次数

					jsonArray.add(jo);

					dataPaperViewQuestion = new DataPaperViewQuestion();
					// 把单个question的信息放入question中,questions集合下对应的对象就是dataPaperViewQuestion
					dataPaperViewQuestion.setId(question.getId());
					dataPaperViewQuestion.setQuestionType(1);
					dataPaperViewQuestion.setQuestionTitle(question
							.getQuestionTitle());
					dataPaperViewQuestion.setQuestionOption(a);
					dataPaperViewQuestion.setAnswerContent(b);

					// JSONObject json = new JSONObject();
					// json.put("before", questions);
					// System.out.println("json1:"+json);

					// 把上面的一个question对象放入questions集合中,question对象对应的数组下标加1
					questions.add(dataPaperViewQuestion);
					// num++;
					// json = new JSONObject();
					// json.put("data1", questions);
					// System.out.println("json1:"+json);

					// 把questions集合放入最终的返回对象中
					dataPaperViewPaper.setQuestions(questions);

				}
				/*
				 * JSONObject json = new JSONObject(); json.put("data1",
				 * dataPaperViewPaper); System.out.println("json1:"+json);
				 */
				// return dataPaperViewPaper;
			}

			if (list2.size() > 0) {// 问题类型为2--多选题

				for (Question q : list2) {
					// 定义多选题的选项数组,中间数组

					// String[] options = q.getQuestionOption().substring(1,
					// q.getQuestionOption().length() - 1).split(",");
					// String[] options = (String[])
					// JSONArray.fromObject(q.getQuestionOption()).toArray();
					Object[] o = JSONArray.fromObject(q.getQuestionOption())
							.toArray();
					String[] options = new String[o.length];
					for (int i = 0, n = o.length; i < n; i++) {
						options[i] = o[i].toString();
					}
					// 定义多选题的List对象，用来存QuestionOption。其实对应的就是结果数据下面的questions下的用来存QuestionOption
					List<String> a = new ArrayList<>();
					Collections.addAll(a, options);

					// 定义答案的集合，获取AnswerContent集合，放入b中
					List<Object> b = new ArrayList<>();

					// 获取所有的选项
					List<Answer> listAnswer = answerService
							.queryAnswerByQuestionId(q.getId());
					// String[] option = {"a","b","c"};
					// String option =
					// q.getQuestionOption();//获取到了数据库中的QuestionOption
					// [java,c,qq,aa]
					// System.out.println(option);
					// String[] ops = {"a", "b", "c"};//option.substring(1,
					// option.length() - 1).split(",");

					// 定义答案统计数组，长度是对应问题选项的长度
					int[] ansContent = new int[options.length];// 定义结果数组

					/*
					 * for (int i=0,n=options.length;i<n;i++){
					 * System.out.println("看看options："+options[i]); }
					 */

					for (Answer an : listAnswer) {// 遍历答案,记录answerContent

						// System.out.println(an.getAnswerContent());
						// [java,qq,aa]
						String temp = "";
						if (an.getAnswerContent().length() > 2) {
							temp = an.getAnswerContent().substring(1,
									an.getAnswerContent().length() - 1);// 去括号["java","qq","aa"]
						}
						String[] answerContents = null;
						if (temp != null) {
							// 记录an.getAnswerContent()，每一个答案的每一个选项
							answerContents = temp.split(",");
						}
						// System.out.println("看看AnswerContent："+an.getAnswerContent());//[java,qq,aa]
						for (int i = 0, n = options.length; i < n; i++) {
							for (int j = 0, m = answerContents.length; j < m; j++) {
								if (answerContents.length > 2) {
									if (answerContents[j].substring(1,
											answerContents[j].length() - 1)
											.equals(options[i])) {
										ansContent[i]++;
									}
								}
							}

						}
					}
					Collections.addAll(b, ansContent);

					JSONArray ja = new JSONArray();// 选项
					ja.addAll(JSONArray.fromObject(options));
					JSONArray jTimes = new JSONArray();// 被选次数
					jTimes.addAll(JSONArray.fromObject(ansContent));

					JSONObject jo = new JSONObject();
					jo.put("id", q.getId());
					jo.put("questionType", 2);
					jo.put("questionTitle", q.getQuestionTitle());
					jo.put("questionOption", ja);// 选项
					jo.put("answerContent", jTimes);// 选项被选次数

					jsonArray.add(jo);

					dataPaperViewQuestion = new DataPaperViewQuestion();

					// 一层一层加数据
					// System.out.println("questions0============="+questions);
					dataPaperViewQuestion.setId(q.getId());
					dataPaperViewQuestion.setQuestionType(2);
					dataPaperViewQuestion
							.setQuestionTitle(q.getQuestionTitle());
					dataPaperViewQuestion.setQuestionOption(a);
					dataPaperViewQuestion.setAnswerContent(b);
					// System.out.println("questions1============="+questions);
					questions.add(dataPaperViewQuestion);
					// num++;
					// System.out.println("questions2============="+questions);
					/*
					 * JSONObject json = new JSONObject(); json.put("before",
					 * questions); System.out.println("json1-2:"+json);
					 */

					dataPaperViewPaper.setQuestions(questions);

					/*
					 * json = new JSONObject(); json.put("after", questions);
					 * System.out.println("json1-2:"+json);
					 */

				}
				// JSONObject json = new JSONObject();
				// json.put("data2", dataPaperViewPaper);
				// System.out.println("json2:" + json);
				// return dataPaperViewPaper;
			}

			if (list3.size() > 0) {// 第三个类型的问题

				for (Question questionThree : list3) {

					/*
					 * "id": "3234", "questionType":3, "questionTitle":
					 * "说一说你觉得最幸福的事", "questionOption": [], "answerContent": [
					 * "从青铜", "到黄金", "到王者" ]
					 */

					// 获取所有的答案,把每个答案的结果放入答案集合中，答案集合对应的是answerContent 对应中间集合b
					List<Answer> listAnswer = answerService
							.queryAnswerByQuestionId(questionThree.getId());
					List<Object> b = new ArrayList<>();
					for (Answer a : listAnswer) {
						if (a.getAnswerContent().length() > 4) {
							b.add(a.getAnswerContent().substring(2,
									a.getAnswerContent().length() - 2));
						}
					}

					JSONArray ja = new JSONArray();// 选项,空值就行
					// ja.addAll(JSONArray.fromObject(options));
					JSONArray jTimes = new JSONArray();// 被选次数
					jTimes = JSONArray.fromObject(b);

					JSONObject jo = new JSONObject();
					jo.put("id", questionThree.getId());
					jo.put("questionType", 3);
					jo.put("questionTitle", questionThree.getQuestionTitle());
					jo.put("questionOption", ja);// 选项
					jo.put("answerContent", jTimes);// 选项被选次数

					jsonArray.add(jo);

					dataPaperViewQuestion = new DataPaperViewQuestion();

					// 数据层层加入
					// System.out.println("num==========="+num);
					dataPaperViewQuestion.setId(questionThree.getId());
					dataPaperViewQuestion.setQuestionType(3);
					dataPaperViewQuestion.setQuestionTitle(questionThree.getQuestionTitle());
					dataPaperViewQuestion.setQuestionOption(new ArrayList<String>());
					dataPaperViewQuestion.setAnswerContent(b);

					// JSONObject json = new JSONObject();
					// json.put("before", questions);
					// System.out.println("json1:"+json);

					questions.add(dataPaperViewQuestion);
					// num++;
					// json = new JSONObject();
					// json.put("data1", questions);
					// System.out.println("json1:"+json);

					dataPaperViewPaper.setQuestions(questions);

				}
				// JSONObject json = new JSONObject();
				// json.put("data3", dataPaperViewPaper);
				// System.out.println("json3:" + json);

			}

			if (json != null) {
				json.put("questions", jsonArray);
				return json;// 最后返回对象
			} else
				return null;

		}
		return null;
	}

	@Override
	@Transactional
	public boolean updatePaperQuestions(UpdatePaperViewPaper paper,
			String userId, AddPaperViewPaper addPaperViewPaper)
			throws ParseException {

		deletePaper(paper.getId());
		questionService.deleteQuestionsByPaperId(paper.getId());
		// PaperMethodHelp paperMethodHelp = new PaperMethodHelp();
		paperMethodHelp.insertPaper(addPaperViewPaper, userId, paper.getId());

		return true;
	}

}
