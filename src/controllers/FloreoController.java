package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import data.FloreoDAO;
import data.State;
import data.StateDAO;

@Controller
@SessionAttributes("current")
public class FloreoController {
	@Autowired
	private FloreoDAO floreoDao;

	@ModelAttribute("current")
	public Integer initSessionObject(){
		return 1;
	}

	@RequestMapping(path="GetFloreoData.do, params="id", method=RequestMethod.GET)
	public ModelAndView getFloreoById(@RequestParam("id") int n) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("results.jsp");
		mv.addObject("floreo", floreoDao.getFloreoById(n));
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
	
	
//	@RequestMapping(path="submit.do", params="next")
//	public ModelAndView next(@ModelAttribute("current") Integer current) {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("result.jsp");
//		mv.addObject("current", ++current);
//		
//		System.out.println(current);
//		
//		Floreo s = floreoDao.getStateById(current);
//		System.out.println(s.getAbbreviation());
//		if (s.equals(null)){
//			mv.setViewName("index.html");
//		}
//		else{
//			mv.addObject("state", s);
//		}
//		return mv;
//	}
//
//	@RequestMapping(path="GetStateData.do", params="name", method=RequestMethod.GET) 
//	public ModelAndView getByName(@RequestParam("name") String n) {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("result.jsp");
//		mv.addObject("state", stateDao.getStateByName(n));
//		return mv;
//	}
//	
//	@RequestMapping(path="GetStateData.do", params="abbrev", method=RequestMethod.GET)
//	public ModelAndView getByAbbrev(@RequestParam("abbrev") String a) {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("result.jsp");
//		mv.addObject("state", stateDao.getStateByAbbreviation(a));
//		return mv;
//	}
//	
//	@RequestMapping(path="NewState.do", method=RequestMethod.POST)
//	public ModelAndView newState(State state) {
//		stateDao.addState(state);
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("result.jsp");
//		return mv;
//	}
}
