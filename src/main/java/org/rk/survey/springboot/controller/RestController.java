package org.rk.survey.springboot.controller;

import javax.sql.DataSource;


import org.rk.survey.springboot.bo.SessionBO;
import org.rk.survey.springboot.model.CompanyDetailsReq;
import org.rk.survey.springboot.model.CompanyDetailsResp;
import org.rk.survey.springboot.model.SessionReq;
import org.rk.survey.springboot.model.SessionResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	DataSource dataSource;

	@Autowired
	private SessionBO sessionBo;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@RequestMapping(value = "/checkSession", method = RequestMethod.POST)
	public SessionResp isValidSession(@RequestBody SessionReq sessionReq) {
		logger.info("Inside check session"+sessionReq.getIdxSession());
		SessionResp sessResp = new SessionResp();
		try {
			sessResp = sessionBo.isSessionValid(sessionReq);
		}
		catch(Exception e)
		{
			sessResp.setMessage(e.getLocalizedMessage());
			sessResp.setFlag("E");
			sessResp.setStatus("FAILURE");
			e.printStackTrace();
		}
		return sessResp;
	}
	
	@RequestMapping(value = "/getCompanyDetails", method = RequestMethod.POST)
	public CompanyDetailsResp getCompanyDetails(@RequestBody CompanyDetailsReq companyReq) {
		logger.info("Inside getCompanyDetails"+companyReq.getxID());
		CompanyDetailsResp companyResp = new CompanyDetailsResp();
		try {
			companyResp = sessionBo.getClientDetail(companyReq);
		}
		catch(Exception e)
		{
			org.rk.survey.springboot.model.Exception ex = new org.rk.survey.springboot.model.Exception();
			ex.setMessage(e.getMessage());
			ex.setStatus("FAILURE");
			e.printStackTrace();
		}
		return companyResp;
	}
	
}
