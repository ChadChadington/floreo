package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import data.Floreo;
import data.FloreoDAO;

@Controller
@SessionAttributes("current")
public class FloreoController {
	@Autowired
	private FloreoDAO floreoDao;

	@ModelAttribute("current")
	public Integer initSessionObject(){
		return 1;
	}
	
	@RequestMapping(path="submit.do", params="previous")
	public ModelAndView previous(@ModelAttribute("current") Integer current) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("results.jsp");
		mv.addObject("current", current--);
		
		System.out.println(current);
		
		Floreo fl = floreoDao.getFloreoById(current);
		if (fl.equals(null)){
			mv.setViewName("index.html");
		}
		else{
			mv.addObject("floreo", fl);
		}
		return mv;
	}
	
	@RequestMapping(path="submit.do", params="next")
	public ModelAndView next(@ModelAttribute("current") Integer current) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("results.jsp");
		mv.addObject("current", ++current);
		
		System.out.println(current);
		
		Floreo fl = floreoDao.getFloreoById(current);
		if (fl.equals(null)){
			mv.setViewName("index.html");
		}
		else{
			mv.addObject("floreo", fl);
		}
		return mv;
	}
	
	@RequestMapping(path="GetFloreoData.do", params="fname", method=RequestMethod.GET) 
	public ModelAndView getByFname(@RequestParam("fname") String n) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("results.jsp");
		mv.addObject("floreo", floreoDao.getFloreoByFname(n));
		return mv;
	}
	
	@RequestMapping(path="GetFloreoData.do", params="lname", method=RequestMethod.GET) 
	public ModelAndView getByLname(@RequestParam("lname") String n) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("results.jsp");
		mv.addObject("floreo", floreoDao.getFloreoByLname(n));
		return mv;
	}
	
	@RequestMapping(path="GetFloreoData.do") 
	public ModelAndView getAllFloreos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employee.jsp");
		mv.addObject("floreo", floreoDao.getAllFloreos());
		return mv;
	}
	
	@RequestMapping("EditFloreo.do") 
    public ModelAndView editFloreo(@RequestParam("id") int a) {
        Floreo fl;
		fl = floreoDao.getFloreoById(a);
		System.out.println("In Edit ID =" + a);
        
		ModelAndView mv = new ModelAndView();
        mv.setViewName("edit-employee.jsp");
        mv.addObject("floreo", fl);
        return mv;
    }
	
	@RequestMapping("DeleteFloreo.do")
	public ModelAndView deleteFloreo(@RequestParam("id") int id, @RequestParam("fname") String fname, 
    		@RequestParam("lname") String lname, @RequestParam("city") String city, @RequestParam("neighborhood") String neighborhood,
    		@RequestParam("latitude") String latitude, @RequestParam("longitude") String longitude, @RequestParam("jobsNum") int jobsNum,
    		@RequestParam("motto") String motto) {
		
		Floreo f = new Floreo();
		f.setId(id);
		f.setFname(fname);
		f.setLname(lname);
		f.setCity(city);
		f.setNeighborhood(neighborhood);
		f.setLatitude(latitude);
		f.setLongitude(longitude);
		f.setJobsNum(jobsNum);
		f.setMotto(motto);
	
		floreoDao.deleteFloreo(f);
		System.out.println(f);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employee.jsp");
		mv.addObject("floreo", floreoDao.getAllFloreos());
		return mv;
	}
	
	@RequestMapping("addFloreo.do") 
    public ModelAndView addFloreo(@RequestParam("fname") String fname, 
    		@RequestParam("lname") String lname, @RequestParam("city") String city, @RequestParam("neighborhood") String neighborhood,
    		@RequestParam("latitude") String latitude, @RequestParam("longitude") String longitude, @RequestParam("jobsNum") int jobsNum,
    		@RequestParam("motto") String motto) {
		
		int count = 6;
		
		Floreo f = new Floreo();
		f.setId(count++);
		f.setFname(fname);
		f.setLname(lname);
		f.setCity(city);
		f.setNeighborhood(neighborhood);
		f.setLatitude(latitude);
		f.setLongitude(longitude);
		f.setJobsNum(jobsNum);
		f.setMotto(motto);
		
		floreoDao.addFloreo(f);
		System.out.println(f);
		
		ModelAndView mv = new ModelAndView();
       
        mv.setViewName("employee.jsp");
		mv.addObject("floreo", floreoDao.getAllFloreos());	
        return mv;
    }
	
	@RequestMapping("PostEditFloreo.do") 
    public ModelAndView postEditFloreo(@RequestParam("id") int id, @RequestParam("fname") String fname, 
    		@RequestParam("lname") String lname, @RequestParam("city") String city, @RequestParam("neighborhood") String neighborhood,
    		@RequestParam("latitude") String latitude, @RequestParam("longitude") String longitude, @RequestParam("jobsNum") int jobsNum,
    		@RequestParam("motto") String motto) {
			
		Floreo f = new Floreo();
		f.setId(id);
		f.setFname(fname);
		f.setLname(lname);
		f.setCity(city);
		f.setNeighborhood(neighborhood);
		f.setLatitude(latitude);
		f.setLongitude(longitude);
		f.setJobsNum(jobsNum);
		f.setMotto(motto);
		
		floreoDao.addFloreo(f);
		System.out.println(f);
		
		ModelAndView mv = new ModelAndView();
       
//        mv.setViewName("employee.jsp");
//		mv.addObject("floreo", floreoDao.getAllFloreos());
//        
		mv.setViewName("results.jsp");
		mv.addObject("floreo", floreoDao.getFloreoById(id));
        return mv;
    }
	

}
