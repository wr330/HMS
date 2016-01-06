package com.test.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@Table(name="HMS_userInfoemation")
public class  Userinfoemation implements Serializable {
	private static final long serialVersionUID = 1L;
    public Userinfoemation(){}
   public Userinfoemation(String userid) {
      this.userid = userid;
 	}	

	private String userid ;

	private String male ;
	private Integer usertype ;
	private String email ;
	private Date usercreated ;
	private String telephone ;
	private String userpassword ;
	private String username ;
	private Date useeffectivetime ;
	private String studentid ;



	@Id
	//@GeneratedValue(generator = "generator")
	@Column(name = "userID", unique = true, nullable = false)
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Column(name="male")
	public String getMale() {
		return male;
	}
	public void setMale(String male) {
		this.male=male;
	}
	@Column(name="userType")
	public Integer getUsertype() {
		return usertype;
	}
	public void setUsertype(Integer usertype) {
		this.usertype=usertype;
	}
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	@Column(name="userCreated")
	public Date getUsercreated() {
		return usercreated;
	}
	public void setUsercreated(Date usercreated) {
		this.usercreated=usercreated;
	}
	@Column(name="telephone")
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone=telephone;
	}
	@Column(name="userPassword")
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword=userpassword;
	}
	@Column(name="userName")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username=username;
	}
	@Column(name="useEffectiveTime")
	public Date getUseeffectivetime() {
		return useeffectivetime;
	}
	public void setUseeffectivetime(Date useeffectivetime) {
		this.useeffectivetime=useeffectivetime;
	}
	@Column(name="studentID")
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid=studentid;
	}


}