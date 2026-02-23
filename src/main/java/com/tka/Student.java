package com.tka;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;



@Component
@Entity
@Table(name = "students")
public class Student {

    @Id
    private String sid;

    private String name;
    private String course;
    private String mobile;
    private String username;
    private String password;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", course=" + course + ", mobile=" + mobile + ", username="
				+ username + ", password=" + password + "]";
	}

   
    
}