package org.rk.survey.springboot.bo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.rk.survey.springboot.dao.TransactionRepository;
import org.rk.survey.springboot.model.CompanyDetails;
import org.rk.survey.springboot.model.CompanyDetailsReq;
import org.rk.survey.springboot.model.CompanyDetailsResp;
import org.rk.survey.springboot.model.Session;
import org.rk.survey.springboot.model.SessionReq;
import org.rk.survey.springboot.model.SessionResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SessionBO {
	
	@Autowired
	TransactionRepository transactionResp;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	public SessionResp isSessionValid(SessionReq session)
	{		
			logger.info("Inside SessionBO isSessionValid::"+session.getIdxSession());
			List<Session> result = transactionResp.isSessionValid(session);
			logger.info("Inside SessionBO isSessionValid:: result size::"+result.size());
			SessionResp sesRes = new SessionResp();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for(int i=0;i<result.size();i++) {
			
				try {
					
					Date currentDate =  getCurrentDate();
					Date expireDate = dateFormat.parse(result.get(i).getExpireDate());
					logger.info("Inside SessionBO isSessionValid:: currentDate "+currentDate);
					logger.info("Inside SessionBO isSessionValid:: expireDate "+expireDate);
					if(expireDate.before(currentDate))
					{
						if(result.get(i).getStatus().equalsIgnoreCase("C"))
								{
									sesRes.setMessage("Session Expired and Completed");
									sesRes.setStatus(result.get(i).getStatus());
									sesRes.setFlag("EC");
								}
						else if(result.get(i).getStatus().equalsIgnoreCase("P"))
								{
									sesRes.setMessage("Session Expired and In Complete");
									sesRes.setStatus(result.get(i).getStatus());
									sesRes.setFlag("EIC");
								}
						else if(result.get(i).getStatus().equalsIgnoreCase("NS"))
								{
									sesRes.setMessage("Session Expired and Not started");
									sesRes.setStatus(result.get(i).getStatus());
									sesRes.setFlag("ENS");
								}
					}
					if(expireDate.after(currentDate))
					{ 
						if(result.get(i).getStatus().equalsIgnoreCase("C"))
								{
									sesRes.setMessage("Session Valid and Completed");
									sesRes.setStatus(result.get(i).getStatus());
									sesRes.setFlag("SC");
								}
						else if(result.get(i).getStatus().equalsIgnoreCase("P"))
								{
									sesRes.setMessage("Session Valid and In Progress");
									sesRes.setStatus(result.get(i).getStatus());
									sesRes.setFlag("SP");
								}
						else if(result.get(i).getStatus().equalsIgnoreCase("NS"))
								{
									sesRes.setMessage("Session Valid and Not Started");
									sesRes.setStatus(result.get(i).getStatus());
									sesRes.setFlag("SNS");
								}
					}
					
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		
			return sesRes;
		
	}
	
	public CompanyDetailsResp getClientDetail(CompanyDetailsReq req) throws Exception
	{
		CompanyDetailsResp companyResp = new CompanyDetailsResp();
		logger.info("Inside SessionBO getClientDetail::"+req.getxID());
		List<CompanyDetails> result = transactionResp.getCompanyDetails(req);
		logger.info("Inside SessionBO getClientDetail:: result size::"+result.size());
		
		for(int i=0;i<result.size();i++) {
			companyResp.setxID(result.get(i).getxID());
			companyResp.setBackgroundImageUrl(result.get(i).getBackgroundImageUrl());
			companyResp.setCompanyName(result.get(i).getCompanyName());
			companyResp.setCopyright(result.get(i).getCopyright());
			companyResp.setHeaderLogoUrl(result.get(i).getHeaderLogoUrl());
			companyResp.setDesc(result.get(i).getDesc());
			companyResp.setPrivatepolicy(result.get(i).getPrivatepolicy());
			companyResp.setTagLine(result.get(i).getTagLine());
			companyResp.setTermsandConditionUrl(result.get(i).getTermsandConditionUrl());
		}
		
		return companyResp;
	}
	
	private Date getCurrentDate() throws ParseException
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.parse(dateFormat.format(date));
	}
	
}
