package exam.hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


//@RestController
@Controller
public class A {

	private Service1 service;

	
	@Autowired
	public A(Service1 service) {
		System.out.println("servicelayer wired to contoller");
		this.service = service;
		// TODO Auto-generated constructor stub
	}
 
	@RequestMapping("/")
	public String index(Model model) {
		return "main";
	}

	
	
	@GetMapping("/Request")
	public String mainpage(@RequestParam("mainpage") String page) {
		System.out.println("f1 invoked");
		if (page.equalsIgnoreCase("Admin"))
			return "admin";
		else if (page.equalsIgnoreCase("Main"))
			return "main";
		else if (page.equalsIgnoreCase("Tester"))
			return "demoFile";
		else if (page.equalsIgnoreCase("Developer"))
			return "developer";
		
		else if (page.equalsIgnoreCase("ContactUs"))
			return "contactus";
		
		else
			return "main";
	}

	@RequestMapping(value = "/tester", method = RequestMethod.POST)
	public String testerloginchk(@ModelAttribute Tester t, Model m) {
		System.out.println("tester adding func 111");
		System.out.println(t);
		Tester t1 = service.chkTester(t);

		if (t1.getTesterid() == 0) {
			m.addAttribute("Tester", t1);
			return "testerloginfail";
		} else {
			m.addAttribute("Tester", t1);
			List<Bugs> b = service.getBugsTester(t1.getTesterid());
			System.out.println("size=" + b.size());
			if (b.size() == 0) {
				m.addAttribute("id", t1.getTesterid());
				return "tester2bugtableEmpty";
			} else {
				m.addAttribute("id", t1.getTesterid());
				m.addAttribute("t", b);
				return "tester2";
			}
		}
	}

	@RequestMapping(value = "/developer", method = RequestMethod.POST)
	public String developerloginchk(@ModelAttribute Developer d, Model m) {
		System.out.println(d);
		Developer d1 = service.chkDeveloper(d);
		List<Bugs> b = service.getDeveloperBugs(d1.getDeveloperid());
		if (d1.getDeveloperid() == 0) {
			m.addAttribute("Developer", d1);
			return "developerloginfail";
		} else {
		if(b.size()==0) {
			m.addAttribute("k1", b);
			m.addAttribute("id", d1.getDeveloperid());
			return "developer2notbugassign";
		}
		
		else {	// m.addAttribute(d1);
			System.out.println(b);
			m.addAttribute("k1", b);
			m.addAttribute("id", d1.getDeveloperid());
			return "developer2";
		}
	}}
	
@GetMapping("/DeveloperBackRequest")
public String developerBack(@RequestParam("page") String id,Model m) {
	Integer id1 = Integer.parseInt(id);
	List<Bugs> b = service.getDeveloperBugs(id1);
	if(b.size()==0) {
		m.addAttribute("k1", b);
		m.addAttribute("id", id1);
		return "developer2notbugassign";
	}
	
	else {	// m.addAttribute(d1);
		System.out.println(b);
		m.addAttribute("k1", b);
		m.addAttribute("id", id1);
		return "developer2";
	}
}
	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public String adminloginchk(@ModelAttribute Admin a, Model m) {
		Admin a1 = service.chkAdmin(a);
		List<Developer> developer = service.view_developer_list();
		List<Tester> tester = service.view_tester_list();
		m.addAttribute("k2",tester);
		m.addAttribute("k1",developer);
		
		return "admin2";
		}

	@GetMapping("/viewtableRequest")
	public String view_table_list(@RequestParam("viewtable") String s, Model m) {
		System.out.println("function invoked"+s);
		String page = null;
		if (s.equalsIgnoreCase("tester")) {
			List<Tester> test = service.view_tester_list();
			m.addAttribute("k1", test);
			page = "viewtestertable";
		} else if (s.equalsIgnoreCase("developer")) {
			List<Developer> test = service.view_developer_list();
			m.addAttribute("k1", test);

			page = "viewdevelopertable";
		} else if(s.equalsIgnoreCase("bug")) {
			List<Bugs> bug = service.view_Bug_list();
			m.addAttribute("k1", bug);
			page = "viewbugtable";
		}else if (s.equalsIgnoreCase("Deletetester")) {
			List<Tester> test = service.view_tester_list();
			m.addAttribute("k1", test);
			page = "deletetester";
		} else if (s.equalsIgnoreCase("Deletedeveloper")) {
			List<Developer> test = service.view_developer_list();
			m.addAttribute("k1", test);

			page = "deletedeveloper";
		}
		
		return page;
	}

	@GetMapping("/addRequest")
	public String add_developer_tester(@RequestParam("adminpage") String s) {
		System.out.println("f4 invoked");
		if (s.equalsIgnoreCase("developer"))
			return "adddeveloper";
		else
			return "addtester";
	}

	@GetMapping("/backRequest")
	public String admin_bck_request(@RequestParam("adminaddpage") String s,Model m) {
		System.out.println("f6 invoked");
		List<Developer> developer = service.view_developer_list();
		List<Tester> tester = service.view_tester_list();
		m.addAttribute("k2",tester);
		m.addAttribute("k1",developer);
		
		return "admin2";

	}

	@RequestMapping(value = "/adddeveloper", method = RequestMethod.POST)
	public String admin_add_developer(@ModelAttribute Developer d, Model m) {
		// String message="Success";
		System.out.println(d);
		Developer d1 = service.addDeveloper(d);
		Integer i = d1.getDeveloperid();
		if (d1.getDeveloperid() == 0) {
			m.addAttribute("message", i);
			return "dataNotadded";

		} else {
			m.addAttribute("developer", i);

			return "adddeveloper_id";
		}
	}

	@RequestMapping(value = "/addtester", method = RequestMethod.POST)
	public String admin_add_tester(@ModelAttribute Tester t, Model m) {
		System.out.println(t);
		Tester t1 = service.addTester(t);
		System.out.println(t1);
		Integer i = t1.getTesterid();
		System.out.println(i);
		if (t1.getTesterid() == 0) {
			m.addAttribute("tester", i);

			return "dataNotadded";

		} else {
			m.addAttribute("tester", i);

			return "addtester_id";
		}
	}

	@GetMapping("/TesterRequest")
	public String tester_bug_linkpage(@RequestParam("page") String page, Model m) {
		System.out.println("value =" + page);
		String s[] = page.split(" ");

		Integer id = Integer.parseInt(s[0]);
		System.out.println(id);
		String i = s[1];
		System.out.println(i);
		if (i.equals("assign")) {
			List<Developer> l = service.view_developer_list();
			m.addAttribute("id", id);
			m.addAttribute("developer", l);
			return "bugassign";
		} else {
			List<Bugs> b = service.getBugsTester(id);
			if (b.size() == 0) {
				m.addAttribute("id", id);
				return "tester2bugtableEmpty";
			} else {
				m.addAttribute("id", id);
				m.addAttribute("t", b);
				return "tester2";

			}
		}
	}

	@RequestMapping(value = "/AssignDeveloperToSolveBugs", method = RequestMethod.POST)
	public String tester_add_bugs(@ModelAttribute Bugs b, Model m) {
		System.out.println(b);
		Bugs b1 = service.addBugs(b);
		System.out.println(b1.getBugid());
		Integer i = b1.getBugid();
		List<Developer> l = service.view_developer_list();

		m.addAttribute("developer", l);

		m.addAttribute("bugid", i);
		m.addAttribute("id", b1.getTesterid());
		return "bugassignId";

	}

	
	@GetMapping("/DeveloperRequest")
	public String developerReviewPage(@RequestParam("page") String p,Model m) {
		String s[]=p.split(" ");
		Integer id=Integer.parseInt(s[0]);
		List<Bugs> b = service.getDeveloperBugs(id);
		
		
			if(b.size()==0) {
				System.out.println(b);
				m.addAttribute("k1", b);
				m.addAttribute("id1", id);
				return"developer3notassign";
			}
			
			else {	// m.addAttribute(d1);
				System.out.println(b);
				m.addAttribute("k1", b);
				m.addAttribute("id1", id);
				return"developer3";
			}
		}
	@RequestMapping(value = "/AssignToSolveBugs", method = RequestMethod.POST)
	public String f33(@ModelAttribute Bugs b, Model m) {
		System.out.println(b);
		System.out.println("in functiom"+b.getDeveloperid());
		Boolean review = true;
		review=service.chkBugs(b);
		
		Developer d=b.getDeveloperid();
		System.out.println(d.getDeveloperid());
		
		
		  List<Bugs> b1 = service.getDeveloperBugs(d.getDeveloperid());
		  System.out.println(b1); m.addAttribute("k1", b1);
		  m.addAttribute("id1", d.getDeveloperid());
		 
			return "developer3_action";
		}
		
	
	@GetMapping("/UpdateRequest")
	public String updatePageRequest(@RequestParam("page") String page,Model m) {
		String p[]=page.split(" ");
		Integer id= Integer.parseInt(p[0]);
		System.out.println(id+" "+p[1]);
		if(p[1].equalsIgnoreCase("tester")) {
		
			Tester r = service.getTesterIdObject(id);
			m.addAttribute("id", r.getTesterid());
			m.addAttribute("key",r);
			return "updateTester";
		}
		else if(p[1].equalsIgnoreCase("developer")) {
			
			Developer r = service.getDeveloperIdObject(id);
			m.addAttribute("id", r.getDeveloperid());
			m.addAttribute("key",r);
			return "Update";
		}
		return "Update";
	}
	
	@PostMapping("/UpdateTesterPassword")
	public String updateTesterPassword(Model m,@RequestParam("id")Integer id,@RequestParam("newpassword") String newp,@RequestParam("oldpassword") String oldp,@RequestParam("email") String email,@RequestParam("mobile") String mobile) {
	System.out.println(id+" "+newp+" " +oldp);
	Tester r = service.getTesterIdObject(id);
	m.addAttribute("id", r.getTesterid());
	m.addAttribute("key",r);
	Boolean password=true;	
	if((newp!="")&&(mobile!="")&&(email!="")) {
			System.out.println(newp+" "+email+" "+mobile);
		 password=service.updateTesterPassword(id, newp, oldp);
		Boolean e =service.updateTesterEmail(id, email);
		Boolean mob = service.updateTesterMobile(id, mobile);
		if(password!=true) {
			return "updateTestererror";
		}
		else return "updateTestersucces";
	}
	else if((newp=="")&&(mobile=="")&&(email!="")) {
		Boolean b=service.updateTesterEmail(id, email);
	    return "updateTestersucces";
	}
	
	else if((newp=="")&&(mobile!="")&&(email=="")) {
		Boolean b=service.updateTesterMobile(id, mobile);
	    return "updateTestersucces";
	}
	
	else if((newp!="")&&(mobile=="")&&(email=="")) {
	 password=service.updateTesterPassword(id, newp, oldp);
		if(password!=true) {
			return "updateTestererror";
		}
		else return "updateTestersucces";
       }
	
	else if((newp=="")&&(mobile!="")&&(email!="")) {
		Boolean b1= service.updateTesterEmail(id, email);
		Boolean b2=service.updateTesterMobile(id, mobile);
		return "updateTestersucces";
		
	}
	
	else if((newp!="")&&(mobile!="")&&(email=="")) {
	
		Boolean b2=service.updateTesterMobile(id, mobile);
		 password=service.updateTesterPassword(id, newp, oldp);
		 Developer r1 = service.getDeveloperIdObject(id);
		 System.out.println(r1);
			m.addAttribute("id", r1.getDeveloperid());
			m.addAttribute("key",r1);
		if(password!=true) {
			return "updateTestererror";
		}
		else return "updateTestersucces";
   }
	else if((newp!="")&&(mobile=="")&&(email!="")) {
		
		Boolean b2=service.updateTesterMobile(id, mobile);
		 password=service.updateTesterPassword(id, newp, oldp);
		if(password!=true) {
			return "updateTestererror";
		}
		else return "updateTestersucces";
   }
 	return"updateTestererror";
	
    }
	
	@PostMapping("/UpdateDeveloperPassword")
	public String updateDeveloperPassword(Model m,@RequestParam("id")Integer id,@RequestParam("newpassword") String newp,@RequestParam("oldpassword") String oldp,@RequestParam("email") String email,@RequestParam("mobile") String mobile) {
	System.out.println("entry to update developer"+newp+" "+mobile+" "+email);
	Boolean r = true;
	Boolean password=true;
	 Developer r1 = service.getDeveloperIdObject(id);
	 System.out.println(r1);
		m.addAttribute("id", r1.getDeveloperid());
		m.addAttribute("key",r1);
	if((newp!="")&&(mobile!="")&&(email!="")) {
			System.out.println("in first");
 password=service.updateDeveloperPassword(id, newp, oldp);
		Boolean e =service.updateDeveloperEmail(id, email);
		Boolean mob = service.updateDevelopererMobile(id, mobile);
		
		if(password!=true) {
			return "updateDevelopererror";
		}
		else return "updateDevelopersuccess";
	}
	else if((newp=="")&&(mobile=="")&&(email!="")) {
		System.out.println("in 2");
		
		Boolean b=service.updateDeveloperEmail(id, email);
	    return "updateDevelopersuccess";
	}
	
	else if((newp=="")&&(mobile!="")&&(email=="")) {
		System.out.println("in 3");
		
		Boolean b=service.updateDevelopererMobile(id, mobile);
	    return "updateDevelopersuccess";
	}
	
	else if((newp!="")&&(mobile=="")&&(email=="")) {
		System.out.println("in 4");
		
		 password=service.updateDeveloperPassword(id, newp, oldp);
		if(password!=true) {
			return "updateDevelopererror";
		}
		else return "updateDevelopersuccess";
       }
	
	else if((newp=="")&&(mobile!="")&&(email!="")) {
		System.out.println("in 5");
		
		Boolean b1= service.updateDeveloperEmail(id, email);
		Boolean b2=service.updateDevelopererMobile(id, mobile);
		return "updateDevelopersuccess";
		
	}
	
	else if((newp!=null)&&(mobile!=null)&&(email==null)) {
		System.out.println("in 6");
		
		Boolean b2=service.updateDevelopererMobile(id, mobile);
		 password=service.updateDeveloperPassword(id, newp, oldp);
		if(password!=true) {
			return "updateDevelopererror";
		}
		else return "updateDevelopersuccess";
   }
	else if((newp!=null)&&(mobile==null)&&(email!=null)) {
		System.out.println("in 7");
		
		Boolean b2=service.updateTesterMobile(id, mobile);
		 password=service.updateDeveloperPassword(id, newp, oldp);
		if(password!=true) {
			return "updateDevelopererror";
		}
		else return "updateDevelopersuccess";
   }
 	return"updateDevelopererror";
	
    }
	
	@GetMapping("/DeleteRequestDeveloper")
	public String deleteDeveloper(@RequestParam("mainpage") String page,Model m) {
		Integer id=Integer.parseInt(page);
		System.out.println(id);
		String p=null;
		System.out.println("function called developer delete");
		service.deleteDeveloper(id);
		List<Developer> test = service.view_developer_list();
		m.addAttribute("k1", test);

		p = "deletedeveloper";
		return p;
	}
	@GetMapping("/DeleteRequestTester")
	public String deleteTester(@RequestParam("page") String page,Model m) {
		Integer id=Integer.parseInt(page);
		System.out.println(id);
		String p=null;
		System.out.println("function called tester delete");
		service.deleteTester(id);
		List<Tester> test = service.view_tester_list();
		m.addAttribute("k1", test);

		p = "deletetester";
		return p;
	}

}