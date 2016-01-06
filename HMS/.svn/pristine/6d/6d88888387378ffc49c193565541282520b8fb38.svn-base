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
@Table(name="HMS_homeworkState")
public class  Homeworkstate implements Serializable {
	private static final long serialVersionUID = 1L;
    public Homeworkstate(){
    }
   public Homeworkstate(String homeworkoid) {
      this.homeworkoid = homeworkoid;
 	}	

	private String homeworkoid ;

	private String studentid ;
	private Date createddate ;
	private Integer homeworkgrade ;
	private String efile ;
	private String homeworkname ;
	private String homeworkstate ;
	private String beizhu ;



	@Id
	//@GeneratedValue(generator = "generator")
	@Column(name = "homeworkOid", unique = true, nullable = false)
	public String getHomeworkoid() {
		return homeworkoid;
	}
	public void setHomeworkoid(String homeworkoid) {
		this.homeworkoid=homeworkoid;
	}

	@Column(name="studentID")
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid=studentid;
	}
	@Column(name="createdDate")
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate=createddate;
	}
	@Column(name="homeworkGrade")
	public Integer getHomeworkgrade() {
		return homeworkgrade;
	}
	public void setHomeworkgrade(Integer homeworkgrade) {
		this.homeworkgrade=homeworkgrade;
	}
	@Column(name="efile")
	public String getEfile() {
		return efile;
	}
	public void setEfile(String efile) {
		this.efile=efile;
	}
	@Column(name="homeworkName")
	public String getHomeworkname() {
		return homeworkname;
	}
	public void setHomeworkname(String homeworkname) {
		this.homeworkname=homeworkname;
	}
	@Column(name="homeworkState")
	public String getHomeworkstate() {
		return homeworkstate;
	}
	public void setHomeworkstate(String homeworkstate) {
		this.homeworkstate=homeworkstate;
	}
	@Column(name="beizhu")
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu=beizhu;
	}


}