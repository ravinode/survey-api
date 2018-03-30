package org.rk.survey.springboot.dao;

import java.util.List;

import org.rk.survey.springboot.model.CompanyDetails;
import org.rk.survey.springboot.model.CompanyDetailsReq;
import org.rk.survey.springboot.model.Session;
import org.rk.survey.springboot.model.SessionReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionRepository {


	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	
	 public List<Session> isSessionValid(SessionReq session) {

	        List<Session> result = jdbcTemplate.query(
	                "SELECT session, status, created_date, expire_date FROM X_SESSION where"
	                + " session ='"+session.getIdxSession()+"'",
	                (rs, rowNum) -> new Session(
	                		   rs.getString("session"),
	                		   rs.getString("status"), 
	                		   rs.getString("created_date"), 
	                		   rs.getString("expire_date")
	                     )
	        );

	        return result;

	    }
	 
	 public List<CompanyDetails> getCompanyDetails(CompanyDetailsReq req) throws Exception{

	        List<CompanyDetails> result = jdbcTemplate.query(
	                "SELECT xID, company_name, tag_line, description, header_logo_url,bg_image_url,copyright,"
	                + "termsUrl,private_policy_url FROM X_CLIENT_DTL where"
	                + " xID ='"+req.getxID()+"'",
	                (rs, rowNum) -> new CompanyDetails(
	                		   rs.getString("xID"),
	                		   rs.getString("company_name"), 
	                		   rs.getString("tag_line"), 
	                		   rs.getString("description"),
	                		   rs.getString("header_logo_url"),
	                		   rs.getString("bg_image_url"), 
	                		   rs.getString("copyright"), 
	                		   rs.getString("termsUrl"),
	                		   rs.getString("private_policy_url")
	                     )
	        );

	        return result;

	    }

}
