package org.rk.survey.springboot.model;

public class CompanyDetailsResp {

	private String xID;
	private String companyName;
	private String tagLine;
	private String desc;
	private String headerLogoUrl;
	private String backgroundImageUrl;
	private String copyright;
	private String termsandConditionUrl;
	private String privatepolicy;
	
	
	
	public CompanyDetailsResp() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CompanyDetailsResp(String xID, String companyName, String tagLine, String desc, String headerLogoUrl,
			String backgroundImageUrl, String copyright, String termsandConditionUrl, String privatepolicy) {
		super();
		this.xID = xID;
		this.companyName = companyName;
		this.tagLine = tagLine;
		this.desc = desc;
		this.headerLogoUrl = headerLogoUrl;
		this.backgroundImageUrl = backgroundImageUrl;
		this.copyright = copyright;
		this.termsandConditionUrl = termsandConditionUrl;
		this.privatepolicy = privatepolicy;
	}
	
	
	public String getxID() {
		return xID;
	}
	public void setxID(String xID) {
		this.xID = xID;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getTagLine() {
		return tagLine;
	}
	public void setTagLine(String tagLine) {
		this.tagLine = tagLine;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getHeaderLogoUrl() {
		return headerLogoUrl;
	}
	public void setHeaderLogoUrl(String headerLogoUrl) {
		this.headerLogoUrl = headerLogoUrl;
	}
	public String getBackgroundImageUrl() {
		return backgroundImageUrl;
	}
	public void setBackgroundImageUrl(String backgroundImageUrl) {
		this.backgroundImageUrl = backgroundImageUrl;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	public String getTermsandConditionUrl() {
		return termsandConditionUrl;
	}
	public void setTermsandConditionUrl(String termsandConditionUrl) {
		this.termsandConditionUrl = termsandConditionUrl;
	}
	public String getPrivatepolicy() {
		return privatepolicy;
	}
	public void setPrivatepolicy(String privatepolicy) {
		this.privatepolicy = privatepolicy;
	}
	
	
	
}
