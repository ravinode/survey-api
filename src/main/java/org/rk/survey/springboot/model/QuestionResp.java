package org.rk.survey.springboot.model;

import java.util.List;

public class QuestionResp {

	private String questionID;
	private String question;
	private String questionOption;
	private List<Answer> answer;
	private String sessionID;

	
	public String getQuestionID() {
		return questionID;
	}
	public void setQuestionID(String questionID) {
		this.questionID = questionID;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getQuestionOption() {
		return questionOption;
	}
	public void setQuestionOption(String questionOption) {
		this.questionOption = questionOption;
	}
	
	public List<Answer> getAnswerID() {
		return answer;
	}
	public void setAnswerID(List<Answer> answerID) {
		this.answer = answerID;
	}
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	
}
