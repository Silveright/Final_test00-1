package com.project.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.test.domain.Group;
import com.project.test.service.BoardService;
import com.project.test.service.GroupService;
import com.project.test.service.MySaveFolder;

@Controller
@RequestMapping(value="/main")
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	private GroupService groupService;
	private MySaveFolder mysavefolder;
	private BoardService boardService;
	/*
	 * @Autowired public GroupController(GroupService groupservice) {
	 * this.groupservice = groupservice; }
	 */
	
	@Autowired
	public MainController(BoardService boardService,
						  GroupService groupService,
						  MySaveFolder mysavefolder) {
		this.boardService = boardService;
		this.groupService = groupService;
		this.mysavefolder = mysavefolder;
	}
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public ModelAndView main(ModelAndView mv) {
		mv.setViewName("main/main");
		return mv;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView groupList(
									@RequestParam(value = "page", defaultValue = "1", required = false) int page,
									ModelAndView mv) {
		int limit = 10; // 한 화면에 출력할 로우 갯수
		
		int listcount = groupService.getListCount(); // 총 리스트 수를 받아옴
		
		// 총 페이지 수
		int maxpage = (listcount + limit -1) / limit;
		
		// 현재 페이지에 보여줄 시작 페이지 수(1, 11, 21 등...)
		int startpage = ((page - 1) / 10) * 10 +1;
		
		// 현재 페이지에 보여줄 마지막 페이지 수(10,20,30 등..)
		int endpage = startpage + 10 -1;
		
		if(endpage > maxpage)
			endpage = maxpage;
		
		List<Group> grouplist = groupService.getGroupList(page, limit); // 리스트를 받아옴
		
		mv.setViewName("main/main");
		mv.addObject("page", page);
		mv.addObject("maxpage", maxpage);
		mv.addObject("startpage", startpage);
		mv.addObject("endpage", endpage);
		mv.addObject("listcount", listcount);
		mv.addObject("grouplist", grouplist);
		mv.addObject("limit", limit);
		return mv;
		
	}
	
}
