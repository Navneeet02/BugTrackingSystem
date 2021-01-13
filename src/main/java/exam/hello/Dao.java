package exam.hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
@Service
public class Dao {
	private Repo r;
	private Repo2 r2;
	private Repo3 r3;

	Dao(){
		System.out.println("dao layer object created");
		//this.r=r;
		//this.r2=r2;
	}

	
	  @Autowired public void setR(Repo r) { this.r=r; }
	 
	
	  @Autowired public void setR2(Repo2 r2) { this.r2=r2; }
	  
	  @Autowired public void setR3(Repo3 r3) { this.r3=r3; }
	 


	public Tester addData(Tester t) {
		// TODO Auto-generated method stub
		System.out.println("in next function ");
		Tester t2=	r.save(t);
		System.out.println(t2);
		return t2;
	}

	public Tester chkTester(Tester t) {
		// TODO Auto-generated method stub
		Tester t1=null;
		if(r.existsById(t.getTesterid())) {
			t1=r.getOne(t.getTesterid());
			System.out.println(t1);
			if(t1.getTesterpwd().equals(t.getTesterpwd()))
			return t1;
			else {
				t1=new Tester(0,"","", null, null,null);
			return t1;
			}
		}
		else {
			t1=new Tester(0,"","", null, null,null);
			return t1;
		}}

	public Developer chkDeveloper(Developer d) {
		Developer d1=null;
		if(r2.existsById(d.getDeveloperid())){
			d1=r2.getOne(d.getDeveloperid());
			System.out.println(d1);
			if(d1.getDeveloperpwd().equals(d.getDeveloperpwd()))
			return d1;
			else {
				d1=new Developer(0,"","", null, null,null);
			return d1;
			}
		}
		else {
			d1=new Developer(0,"","", null, null,null);
			return d1;
		}}

	public Developer addDeveloper(Developer d2) {
		// TODO Auto-generated method stub
		Developer  dev;
		dev=r2.save(d2);
		return dev;
	}

	public Tester addTester(Tester t) {
		// TODO Auto-generated method stub
		Tester t2;
	    t2=r.save(t);
		return t2;
	}

	public Bugs addBugs(Bugs b) {
		// TODO Auto-generated method stub
		Bugs b2;
	    b2=r3.saveAndFlush(b);
	    
		return b2;
	}

	public void chkBugs(Bugs b) {
		// TODO Auto-generated method stub
		Bugs b1;
		System.out.println(b);
		//Boolean review=
				r3.updateReview(b.getReview(), b.getBugid());
		//return review;
		
		
		
	}

	public List<Tester> view_tester_list() {
		// TODO Auto-generated method stub
		List<Tester> tester = r.findAll();
		return tester;
	}

	public List<Developer> view_developer_list() {
		// TODO Auto-generated method stub
		List<Developer> developer = r2.findAll();
		return developer;
	}

	public List<Bugs> getBugsTester(Integer testerid) {
		// TODO Auto-generated method stub
		List<Bugs> b = r3.getBugsTester(testerid);
		return b;
	}

	public List<Bugs> view_bug_list() {
		// TODO Auto-generated method stub
		List<Bugs> bugs = r3.findAll();
		return bugs;
	}

	public List<Bugs> getDeveloperBugs(Integer developerid) {
		// TODO Auto-generated method stub
		List<Bugs> l=r3.getDeveloperBugs(developerid);
		return l;
	}

	public Tester getTesterIdObject(Integer id) {
		Tester t=r.getOne(id);
		return t;
	} 
	public Developer getDeveloperIdObject(Integer id) {
		Developer t=r2.getOne(id);
		return t;
	} 
	
	
	public void updateTesterPassword(Integer id, String newpassword) {
		// TODO Auto-generated method stub
//	Boolean b=	
			r.updatePassword(newpassword, id);
	//	return b;
	}
	public void updateTesterEmail(Integer id, String email) {
		// TODO Auto-generated method stub
	//Boolean b=
			r.updateEmail(email, id);
		//return b;
	}
	public void updateTesterMobile(Integer id, String newpassword) {
		// TODO Auto-generated method stub
//	Boolean b=	
			r.updateMobile(newpassword, id);
	//	return b;
	}
	public void updateDeveloperPassword(Integer id, String newpassword) {
		// TODO Auto-generated method stub
//	Boolean b=	
			r2.updatePassword2(newpassword, id);
	//	return b;
	}
	public void updateDeveloperEmail(Integer id, String newpassword) {
		// TODO Auto-generated method stub
	//Boolean b=	
			r2.updateEmail2(newpassword, id);
		//return b;
	}
	public void updateDeveloperMobile(Integer id, String newpassword) {
		// TODO Auto-generated method stub
	//Boolean b=	
			r2.updateMobile2(newpassword, id);
	
		//return b;
	}


	public void deleteDeveloper(Integer id) {
		// TODO Auto-generated method stub
		r2.deleteById(id);	
	}


	public void deleteTester(Integer id) {
		// TODO Auto-generated method stub
		r.deleteById(id);
	}


}
	
