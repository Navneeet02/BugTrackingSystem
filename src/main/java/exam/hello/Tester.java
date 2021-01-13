package exam.hello;

//import java.util.HashSet;
//import java.util.Set;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//create table tester (testerid int(20)PRIMARY KEY NOT NULL AUTO_INCREMENT,testername varchar(50),testerpwd varchar(50),testeraddress varchar(50),testermobile varchar(50),email varchar(50));

@Entity
@Table(name ="tester")
@SequenceGenerator(name="seq", initialValue=10000, allocationSize=100)
public class Tester {
	@Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
	private Integer testerid;
	
	private String testername;
	private String testerpwd;
	private String testeraddress;
	private String testermobile;
	private String email;
	public Tester() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tester(Integer testerid, String testername, String testerpwd, String testeraddress, String testermobile,
			String email) {
		super();
		this.testerid = testerid;
		this.testername = testername;
		this.testerpwd = testerpwd;
		this.testeraddress = testeraddress;
		this.testermobile = testermobile;
		this.email = email;
	}
	public Integer getTesterid() {
		return testerid;
	}
	public void setTesterid(Integer testerid) {
		this.testerid = testerid;
	}
	public String getTestername() {
		return testername;
	}
	public void setTestername(String testername) {
		this.testername = testername;
	}
	public String getTesterpwd() {
		return testerpwd;
	}
	public void setTesterpwd(String testerpwd) {
		this.testerpwd = testerpwd;
	}
	public String getTesteraddress() {
		return testeraddress;
	}
	public void setTesteraddress(String testeraddress) {
		this.testeraddress = testeraddress;
	}
	public String getTestermobile() {
		return testermobile;
	}
	public void setTestermobile(String testermobile) {
		this.testermobile = testermobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return  testerid + "";	}
	
	//@OneToMany(mappedBy="tester", cascade = CascadeType.ALL)
    //Set Bugs = new HashSet();
	
	
}

