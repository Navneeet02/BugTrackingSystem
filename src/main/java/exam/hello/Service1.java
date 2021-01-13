package exam.hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;



@Service
public class Service1 {

	private Dao d;
	
@Autowired
public JavaMailSender mail;

	public Service1(Dao d) {
		this.d=d;
		System.out.println("Service class wired to dao layerd");
		
	}

@Autowired
public void setDao(Dao d) {
	this.d=d;
}
public Tester getTestinfo(Tester t) {
	// TODO Auto-generated method stub
	System.out.println("you are in insert method");
	Tester t1 = d.addData(t);
	return t1;
}

public Admin chkAdmin(Admin a) {
	// TODO Auto-generated method stub
	Admin a1= null;
	if((a.getAdminname().equals("Aakashgarg"))&&(a.getAdminpwd().equals("garg12345")))
			{
		a1 =a;
		return a1;
			}
	else
		a1 = new Admin("Invalid User","");
	return a1;
		}

public Tester chkTester(Tester t) {
	// TODO Auto-generated method stub
	Tester t1 = d.chkTester(t);
	return t1;
}

public Developer chkDeveloper(Developer d2) {
	Developer d1 = d.chkDeveloper(d2);
	return d1;

}

public Developer addDeveloper(Developer d2) {
	// TODO Auto-generated method stub
	Developer dev = d.addDeveloper(d2);
	developerMailSend(dev);
	return dev;
}

public Tester addTester(Tester t) {
	// TODO Auto-generated method stub
System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
	Tester t2 = d.addTester(t);
	testerMailSend(t2);
	return t2;
}

public Bugs addBugs(Bugs b) {
	// TODO Auto-generated method stub
	Bugs b2 = d.addBugs(b);
	bugMailSend(b2);
	return b2;
}

public void bugMailSend(Bugs b) {
	//https://myaccount.google.com/u/0/lesssecureapps?pli=1&pageid=none
	System.out.println("mail function called");
	Developer d=b.getDeveloperid();
	System.out.println(d.getEmail());
	String email=d.getEmail();
	Integer id=b.getBugid();
	System.out.println(id);
	SimpleMailMessage body = new SimpleMailMessage();
	body.setTo(email);
	body.setSubject("Bug id assigned to Solve");
	body.setText(" Bug Id generted :"+id);
	mail.send(body);
	
}

public void testerMailSend(Tester t) {
	//https://myaccount.google.com/u/0/lesssecureapps?pli=1&pageid=none
	System.out.println("mail function called");
	Integer id =t.getTesterid();
	String password=t.getTesterpwd();
	System.out.println(t.getEmail());
	String email=t.getEmail();
	System.out.println(id);
	SimpleMailMessage body = new SimpleMailMessage();
	body.setTo(email);

	body.setBcc("garg.akash27@gmail.com");
	body.setSubject("Bug Tracking System");
	body.setText("Your login id:"+id+" & password is: "+password+" Please Login with these Credentials "+ "  192.168.43.210:1234/Request?mainpage=Tester");
	mail.send(body);
}

public void developerMailSend(Developer b) {
  //https://myaccount.google.com/u/0/lesssecureapps?pli=1&pageid=none
	System.out.println("mail function called");
	Integer id =b.getDeveloperid();
	String password= b.getDeveloperpwd();
	System.out.println(b.getEmail());
	String email=b.getEmail();
	System.out.println(id);
	SimpleMailMessage body = new SimpleMailMessage();
	body.setTo(email);
	body.setBcc("garg.akash27@gmail.com");
	body.setSubject("Bug Tracking System");
	body.setText("Your login id:"+id+" & password is: "+password+" Please Login with these Credentials  " + "192.168.43.210:1234/Request?mainpage=Developer");
	mail.send(body);
		
}

public Boolean chkBugs(Bugs b) {
	// TODO Auto-generated method stub
	Boolean b2 =true;
			d.chkBugs(b);
	return b2;
}

public List<Tester> view_tester_list() {
	// TODO Auto-generated method stub
	
	List<Tester> tester =d.view_tester_list();
	return tester;
}

public List<Developer> view_developer_list() {
	// TODO Auto-generated method stub
	List<Developer> developer = d.view_developer_list();
	return developer;
}
public List<Bugs> view_Bug_list() {
	// TODO Auto-generated method stub
	List<Bugs> bug = d.view_bug_list();
	return bug;
}

public List<Bugs> getBugsTester(Integer testerid) {
	// TODO Auto-generated method stub
List<Bugs> b = d.getBugsTester(testerid);
	return b;
}

public List<Bugs> getDeveloperBugs(Integer developerid) {
	// TODO Auto-generated method stub
	List<Bugs> b = d.getDeveloperBugs(developerid);
	return b;
}

public Boolean updateTesterPassword(Integer id, String newpassword,String oldpassword) {
	// TODO Auto-generated method stub
	Boolean b=false;
	Tester t=d.getTesterIdObject(id);
	if(t.getTesterpwd().equals(oldpassword)) {
		b =true;
				d.updateTesterPassword(id,newpassword);
	return b; 
    }
	return b;
}
public Boolean updateDeveloperPassword(Integer id, String newpassword,String oldpassword) {
	// TODO Auto-generated method stub
	Boolean b=false;
	Developer t=d.getDeveloperIdObject(id);
	if(t.getDeveloperpwd().equals(oldpassword)) {
		b =true;
		d.updateDeveloperPassword(id,newpassword);
	return b; 
    }
	return b;
}

public Boolean updateTesterMobile(Integer id, String mobile) {
	// TODO Auto-generated method stub
	Boolean b=false;
	b =true;
			d.updateTesterMobile(id,mobile);
	return b; 
    
}

public Boolean updateDevelopererMobile(Integer id, String mobile) {
	// TODO Auto-generated method stub
	Boolean b=false;
	b =true;
			d.updateDeveloperMobile(id,mobile);
	return b; 
    
}
public Boolean updateTesterEmail(Integer id, String email) {
	// TODO Auto-generated method stub
	Boolean b=false;
	b =true;
			d.updateTesterEmail(id,email);
	return b; 
    
}
public Boolean updateDeveloperEmail(Integer id, String email) {
	// TODO Auto-generated method stub
	Boolean b=false;
	b =true;
			d.updateTesterMobile(id,email);
	return b; 
    
}

public Tester getTesterIdObject(Integer id) {
	Tester t=d.getTesterIdObject(id);
	return t;
} 
public Developer getDeveloperIdObject(Integer id) {
	Developer t=d.getDeveloperIdObject(id);
	return t;
}

public void deleteDeveloper(Integer id) {
	// TODO Auto-generated method stub
	Developer t=	d.getDeveloperIdObject(id);
		
		  System.out.println(t.getEmail()); String email=t.getEmail();
		  System.out.println(id); SimpleMailMessage body = new SimpleMailMessage();
		  body.setTo(email);
		  
		  body.setBcc("garg.akash27@gmail.com");
		  body.setSubject("Bug Tracking System");
		  body.setText("You are no longer member of a bug tracking system  "
		  +id+"  Cannot be used as a login"); mail.send(body);
		 

	d.deleteDeveloper(id);
	
}

public void deleteTester(Integer id) {
	// TODO Auto-generated method stub
		
		  Tester t= d.getTesterIdObject(id); System.out.println(t.getEmail()); String
		  email=t.getEmail(); System.out.println(id); SimpleMailMessage body = new
		  SimpleMailMessage(); body.setTo(email);
		  
		  body.setBcc("garg.akash27@gmail.com");
		  body.setSubject("Bug Tracking System");
		  body.setText("You are no longer member of a bug tracking system  "
		  +id+"  Cannot be used as a login"); mail.send(body);
		 	d.deleteTester(id);
} 
	
}
