package com.project.test.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.test.domain.Member;
import com.project.test.service.GroupService;

@Controller
@RequestMapping(value="/group")
public class GroupController {
	private static final Logger logger = LoggerFactory.getLogger(GroupController.class);
	private GroupService groupservice;
	
	 @Autowired public GroupController(GroupService groupservice) {
	 this.groupservice = groupservice; }
	 
	
	//@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView grouplist(ModelAndView mv) {
		mv.setViewName("main/grouplist");
		return mv;
		
	}
	
//	@RequestMapping(value="/groupuserinfo")
//	public ModelAndView memberList(@RequestParam(value="page", defaultValue="1",required=false) int page,
//									@RequestParam(value="limit", defaultValue="3", required=false) int limit,
//									ModelAndView mv,
//									@RequestParam(value="search_field", defaultValue="-1", required=false) int index,
//									@RequestParam(value="search_word", defaultValue="", required=false) String search_word) {
//		
//		int listcount=groupservice.getSearchListCount(index, search_word);//총 리스트 수를 받아옴
//		List<Member> list = groupservice.getSearchList(index, search_word, page, limit);
//		
//		int maxpage = (listcount + limit -1)/limit;
//		int startpage = ((page-1)/10) *10 +1;
//		int endpage = startpage +10-1;
//		
//		if(endpage>maxpage)
//			endpage=maxpage;
//		
//		mv.setViewName("group/groupuserinfo");
//		mv.addObject("page",page);
//		mv.addObject("maxpage",maxpage);
//		mv.addObject("startpage",startpage);
//		mv.addObject("endpage",endpage);
//		mv.addObject("listcount",listcount);
//		mv.addObject("memberlist",list);
//		mv.addObject("search_field",index);
//		mv.addObject("search_word",search_word);
//		return mv;
//	}
	
	@RequestMapping(value="/groupjoinagree")
	public String test() {
		return "/group/groupjoinagree";
	}
	
	@RequestMapping(value="/groupuserinfo")
	public String test2() {
		return "/group/groupuserinfo";
	}

}
