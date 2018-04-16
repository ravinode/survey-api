package org.rk.survey.springboot.model;

public class Answer {
	
	private String answerID;
	private String answer;
	
	
	
	public Answer(String answerID, String answer) {
		super();
		this.answerID = answerID;
		this.answer = answer;
	}
	public String getAnswerID() {
		return answerID;
	}
	public void setAnswerID(String answerID) {
		this.answerID = answerID;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	

}
