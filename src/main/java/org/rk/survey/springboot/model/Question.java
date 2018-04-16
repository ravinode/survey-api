package org.rk.survey.springboot.model;


public class Question {

	private String questionID;
	private String question;
	private String questionOption;
	private String answer;
	private String sessionID;
	
	public Question(String questionID, String question, String questionOption, String answer, String sessionID) {
		super();
		this.questionID = questionID;
		this.question = question;
		this.questionOption = questionOption;
		this.answer = answer;
		this.sessionID = sessionID;
	}
	
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
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	
	

	
	
	
}
