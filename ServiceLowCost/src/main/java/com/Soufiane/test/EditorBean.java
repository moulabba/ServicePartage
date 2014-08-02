package com.Soufiane.test;

import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "editor")
public class EditorBean {
 
	private String value = "This editor is provided by PrimeFaces";
	private Date date=new Date();
 
	public String getValue() {
		return value;
	}
 
	public void setValue(String value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}