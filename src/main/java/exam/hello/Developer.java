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

//create table developer (developerid int(20)PRIMARY KEY NOT NULL AUTO_INCREMENT,developername varchar(50),developerpwd varchar(50),developeraddress varchar(50),developermobile varchar(50),email varchar(50));

@Entity
@Table(name="developer")
@SequenceGenerator(name="seq", initialValue=10000, allocationSize=100)

public class Developer {
	@Id
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
	private Integer developerid;
	private String developername;
	private String developerpwd;
	private String developeraddress;
	private String developermobile;
	private String email;
	
	
	public Developer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Developer(Integer developerid, String developername, String developerpwd, String developeraddress,
			String developermobile, String email) {
		super();
		this.developerid = developerid;
		this.developername = developername;
		this.developerpwd = developerpwd;
		this.developeraddress = developeraddress;
		this.developermobile = developermobile;
		this.email = email;
	}
	public Integer getDeveloperid() {
		return developerid;
	}
	public void setDeveloperid(Integer developerid) {
		this.developerid = developerid;
	}
	public String getDevelopername() {
		return developername;
	}
	public void setDevelopername(String developername) {
		this.developername = developername;
	}
	public String getDeveloperpwd() {
		return developerpwd;
	}
	public void setDeveloperpwd(String developerpwd) {
		this.developerpwd = developerpwd;
	}
	public String getDeveloperaddress() {
		return developeraddress;
	}
	public void setDeveloperaddress(String developeraddress) {
		this.developeraddress = developeraddress;
	}
	public String getDevelopermobile() {
		return developermobile;
	}
	public void setDevelopermobile(String developermobile) {
		this.developermobile = developermobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return developerid+"";
					}

	//@OneToMany(mappedBy="developer", cascade = CascadeType.ALL)
    //Set Bugs = new HashSet();
	
	
	
	
	
	

}
