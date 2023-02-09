package com.memberServices.model;

import java.time.LocalDateTime;

import com.memberServices.exceptions.MemberException;

public class MyErrorMessages {

	private String message;
	private LocalDateTime now;
	private Exception excType;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getNow() {
		return now;
	}
	public void setNow(LocalDateTime now) {
		this.now = now;
	}
	public Exception getExcType() {
		return excType;
	}
	public void setExcType(Exception excType) {
		this.excType = excType;
	}
	public MyErrorMessages(String message, MemberException me) {
		super();
		this.now=LocalDateTime.now();
		this.message = message;
		this.excType = me;
	}
	
}
