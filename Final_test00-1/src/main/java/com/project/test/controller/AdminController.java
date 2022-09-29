package com.project.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.test.domain.AdminChartAreaDate;
import com.project.test.domain.AdminChartCategory;
import com.project.test.domain.AdminMember;
import com.project.test.domain.Calendar;
import com.project.test.service.AdminService;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	private AdminService adminService;
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	
	@Autowired
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@RequestMapping(value="/dashboard", method=RequestMethod.GET)
	public ModelAndView login(ModelAndView mv) {
		mv.setViewName("admin/admin");
		return mv;
	}
	@ResponseBody
	@GetMapping(value="/map")
	public Map<String, Object> Map(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Calendar> chart = adminService.getChartSchedule();
		
		map.put("chart", chart);
		return map;
	}
	@ResponseBody
	@PostMapping(value="/total")
	public Map<String, Object> Total(){
		Map<String, Object> map = new HashMap<String, Object>();
		int totaluser = adminService.gettotaluser();
		int totalgroup = adminService.gettotalgroup();
		int totalschedule = adminService.gettotalschedule();
		String bestgroup = adminService.getbestgroup();
		map.put("totalUser", totaluser);
		map.put("totalGroup", totalgroup);
		map.put("totalSchedule", totalschedule);
		map.put("bestGroup", bestgroup);
		return map;
	}

	@ResponseBody
	@PostMapping(value="/areachart")
	public Map<String, Object> AreaChart(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<AdminChartAreaDate> chartdate = adminService.getChartareaDate();
		
		map.put("chartdate", chartdate);
		return map;
	}

	@ResponseBody
	@PostMapping(value="/piechart")
	public Map<String, Object> PieChart(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<AdminChartCategory> piechart = adminService.getPieChart();
		
		map.put("piechart", piechart);
		return map;
	}

	@ResponseBody
	@PostMapping(value="/piechart2")
	public Map<String, Object> PieChart2(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<AdminChartCategory> piechart = adminService.getPieChart2();
		
		map.put("piechart", piechart);
		return map;
	}

	@RequestMapping(value="/noticelist", method=RequestMethod.GET)
	public ModelAndView NoticeList(ModelAndView mv) {
		mv.setViewName("admin/notice");
		return mv;
	}

	@RequestMapping(value="/noticewrite", method=RequestMethod.GET)
	public ModelAndView NoticeWrite(ModelAndView mv) {
		mv.setViewName("admin/noticewrite");
		return mv;
	}

	@RequestMapping(value="/noticedetail", method=RequestMethod.GET)
	public ModelAndView NoticeDetail(ModelAndView mv) {
		mv.setViewName("admin/noticedetail");
		return mv;
	}

	@RequestMapping(value="/noticemodify", method=RequestMethod.GET)
	public ModelAndView NoticeModify(ModelAndView mv) {
		mv.setViewName("admin/noticemodify");
		return mv;
	}

	
	@RequestMapping(value="/memberinfo")
	public ModelAndView memberList(@RequestParam(value="page", defaultValue="1",required=false) int page,
									@RequestParam(value="limit", defaultValue="3", required=false) int limit,
									ModelAndView mv,
									@RequestParam(value="search_field", defaultValue="-1", required=false) int index,
									@RequestParam(value="search_word", defaultValue="", required=false) String search_word) {
		
		int listcount=adminService.getSearchListCount(index, search_word);//총 리스트 수를 받아옴
		List<AdminMember> list = adminService.getSearchList(index, search_word, page, limit);
		
		int maxpage = (listcount + limit -1)/limit;
		int startpage = ((page-1)/10) *10 +1;
		int endpage = startpage +10-1;
		
		if(endpage>maxpage)
			endpage=maxpage;
		
		mv.setViewName("admin/memberinfo");
		mv.addObject("page",page);
		mv.addObject("maxpage",maxpage);
		mv.addObject("startpage",startpage);
		mv.addObject("endpage",endpage);
		mv.addObject("listcount",listcount);
		mv.addObject("memberlist",list);
		mv.addObject("search_field",index);
		mv.addObject("search_word",search_word);
		return mv;
	}
	
	@RequestMapping(value="/groupmanager")
	public ModelAndView groupmanager(@RequestParam(value="page", defaultValue="1",required=false) int page,
			@RequestParam(value="limit", defaultValue="3", required=false) int limit,
			ModelAndView mv,
			@RequestParam(value="search_field", defaultValue="-1", required=false) int index,
			@RequestParam(value="search_word", defaultValue="", required=false) String search_word) {
			
			int listcount=adminService.getGroupSearchListCount(index, search_word);//총 리스트 수를 받아옴
			List<AdminMember> list = adminService.getGroupSearchList(index, search_word, page, limit);
			
			int maxpage = (listcount + limit -1)/limit;
			int startpage = ((page-1)/10) *10 +1;
			int endpage = startpage +10-1;
			
			if(endpage>maxpage)
				endpage=maxpage;
			
			mv.setViewName("admin/groupmanager");
			mv.addObject("page",page);
			mv.addObject("maxpage",maxpage);
			mv.addObject("startpage",startpage);
			mv.addObject("endpage",endpage);
			mv.addObject("listcount",listcount);
			mv.addObject("memberlist",list);
			mv.addObject("search_field",index);
			mv.addObject("search_word",search_word);
			return mv;
	}
	@RequestMapping(value="/inquiry", method=RequestMethod.GET)
	public ModelAndView Inquiry(ModelAndView mv) {
		mv.setViewName("admin/inquerylist");
		return mv;
	}
	
	@GetMapping(value="/delete")
	public String Delete(String userid) {
		logger.info("userid="+userid);
		adminService.delete(userid);
		return "redirect:memberinfo";
	}
}
