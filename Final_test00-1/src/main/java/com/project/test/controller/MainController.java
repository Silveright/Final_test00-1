package com.project.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.test.service.GroupService;

@Controller
@RequestMapping(value="/main")
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	private GroupService groupservice;
	/*
	 * @Autowired public GroupController(GroupService groupservice) {
	 * this.groupservice = groupservice; }
	 */
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView main(ModelAndView mv) {
		mv.setViewName("main/main");
		return mv;
		
	}
}
