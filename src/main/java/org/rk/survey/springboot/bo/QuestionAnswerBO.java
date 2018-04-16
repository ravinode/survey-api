package org.rk.survey.springboot.bo;

import java.util.List;

import org.rk.survey.springboot.dao.TransactionRepository;
import org.rk.survey.springboot.model.Answer;
import org.rk.survey.springboot.model.Question;
import org.rk.survey.springboot.model.QuestionReq;
import org.rk.survey.springboot.model.QuestionResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionAnswerBO {
	
	@Autowired
	TransactionRepository transactionResp;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public QuestionResp getQuestion(QuestionReq req) throws Exception
	{
		QuestionResp resp = new QuestionResp();
		List<Question> result = transactionResp.getQuestions(req);
		
		
		logger.info("Inside getQuestion"+req.questionID);
		for(int i=0;i<result.size();i++) {
			List<Answer> answer = transactionResp.getAnswer(Integer.parseInt(result.get(i).getAnswer()));
			resp.setQuestion(result.get(i).getQuestion());
			resp.setAnswerID(answer);
			resp.setSessionID(result.get(i).getSessionID());
			resp.setQuestionOption(result.get(i).getQuestionOption());
			resp.setQuestionID(result.get(i).getQuestionID());
		}
		
		
		return resp;
	}

}
