package exam.hello;

//import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


//create table Bug (bugid int(50) NOT NULL PRIMARY KEY AUTO_INCREMENT,developerid int(50) NOT NULL, testerid int(50) NOT NULL, bugname varchar(100) , date varchar(50),solution varchar(100) ,priority varchar(50),review varchar(200), FOREIGN KEY(developerid)REFERENCES developer(developerid) ,FOREIGN KEY(testerid)REFERENCES tester(testerid));;

 
@Entity
@Table(name="bug")
@SequenceGenerator(name="seq", initialValue=10000, allocationSize=100)

public class Bugs {
	
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
private Integer bugid;

@ManyToOne
@JoinColumn(name = "developerid", nullable = false)
private Developer developerid;

@ManyToOne
@JoinColumn(name ="testerid")
private Tester testerid;


private String bugname;
private String date;
private String solution;
private String priority;
private String review;

public Bugs() {
	super();
	// TODO Auto-generated constructor stub
}
public Bugs(Integer bugid, Developer developerid, Tester testerid, String bugname, String date, String solution,
		String priority, String review) {
	super();
	this.bugid = bugid;
	this.developerid = developerid;
	this.testerid = testerid;
	this.bugname = bugname;
	this.date = date;
	this.solution = solution;
	this.priority = priority;
	this.review = review;
}
public Integer getBugid() {
	return bugid;
}
public void setBugid(Integer bugid) {
	this.bugid = bugid;
}
public Developer getDeveloperid() {
	return developerid;
}
public void setDeveloperid(Developer developerid) {
	this.developerid = developerid;
}
public Tester getTesterid() {
	return testerid;
}
public void setTesterid(Tester testerid) {
	this.testerid = testerid;
}
public String getBugname() {
	return bugname;
}
public void setBugname(String bugname) {
	this.bugname = bugname;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getSolution() {
	return solution;
}
public void setSolution(String solution) {
	this.solution = solution;
}
public String getPriority() {
	return priority;
}
public void setPriority(String priority) {
	this.priority = priority;
}
public String getReview() {
	return review;
}
public void setReview(String review) {
	this.review = review;
}
@Override
public String toString() {
	return "Bugs [bugid=" + bugid + ", developerid=" + developerid + ", testerid=" + testerid + ", bugname=" + bugname
			+ ", date=" + date + ", solution=" + solution + ", priority=" + priority + ", review=" + review + "]";
}


	

}
