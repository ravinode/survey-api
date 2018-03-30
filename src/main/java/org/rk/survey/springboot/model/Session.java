package org.rk.survey.springboot.model;

public class Session {
	
	private String idxSession;
    private String status;
    private String createdDate ;
    private String expireDate;
    
	public Session(String idxSession, String status, String createdDate, String expireDate) {
		super();
		this.idxSession = idxSession;
		this.status = status;
		this.createdDate = createdDate;
		this.expireDate = expireDate;
	}

	public Session() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdxSession() {
		return idxSession;
	}

	public void setIdxSession(String idxSession) {
		this.idxSession = idxSession;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

    
}
