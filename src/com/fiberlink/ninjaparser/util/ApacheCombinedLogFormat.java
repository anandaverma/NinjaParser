package com.fiberlink.ninjaparser.util;

public class ApacheCombinedLogFormat {
	private String ipaddrr;
	private String remotelogname;
	private String remoteuser;
	private String time;
	private String method;
	private String request;
	private String response;
	private String bytessent;
	private String referer;
	private String browser;
	
	public String getIpaddrr() {
		return ipaddrr;
	}
	public void setIpaddrr(String ipaddrr) {
		this.ipaddrr = ipaddrr;
	}
	public String getRemotelogname() {
		return remotelogname;
	}
	public void setRemotelogname(String remotelogname) {
		this.remotelogname = remotelogname;
	}
	public String getRemoteuser() {
		return remoteuser;
	}
	public void setRemoteuser(String remoteuser) {
		this.remoteuser = remoteuser;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getBytessent() {
		return bytessent;
	}
	public void setBytessent(String bytessent) {
		this.bytessent = bytessent;
	}
	public String getReferer() {
		return referer;
	}
	public void setReferer(String referer) {
		this.referer = referer;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	@Override
	public String toString() {
		return "[IP: " + ipaddrr + ", Time: " + time + ", Method: " + method + "]";
	}
}
