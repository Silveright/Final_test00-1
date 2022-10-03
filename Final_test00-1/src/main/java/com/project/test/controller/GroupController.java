package com.project.test.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.test.domain.Group;
import com.project.test.domain.GroupJoin;
import com.project.test.domain.GroupUser;
import com.project.test.domain.Member;
import com.project.test.domain.Session;
import com.project.test.service.BoardService;
import com.project.test.service.GroupService;
import com.project.test.service.MemberService;
import com.project.test.service.MySaveFolder;

@Controller
@RequestMapping(value="/group")
public class GroupController {
	
	@Autowired
	private MemberService memberService;
    private GroupService groupService;
	
	private static final Logger logger = LoggerFactory.getLogger(GroupController.class);
	private GroupService groupservice;
	private MySaveFolder mysavefolder;
	

	 @Autowired 
	 public GroupController(GroupService groupservice, MySaveFolder mysavefolder) {
	 this.groupservice = groupservice;
	 this.mysavefolder = mysavefolder; 
	 }

		/*
		 * @Autowired public GroupController(GroupService groupservice) {
		 * this.groupservice = groupservice; }
		 */

	 
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView grouplist(ModelAndView mv) {
		mv.setViewName("main/grouplist");
		return mv;
		
	}

//=================================================================================

	 @RequestMapping(value = "/groupMake.do", method = RequestMethod.GET)
	    public String groupMake(Model model, HttpServletRequest request) {

	        HttpSession session = request.getSession();
	        Session Session = (Session) session.getAttribute("userData");
	        String userid = Session.getUserid();

	        Member member = memberService.userInfoBasic(userid);
	        int groupAdmin = member.getCnt();

	        Group group = groupService.groupBefore();
	        String beforeGroupNo = group.getGroup_no();

	        //직전에 생성된 모임 번호에 +1
	        String tmpNo1 = beforeGroupNo.substring(0, 1); //B
	        int tmpNo2 = Integer.parseInt(beforeGroupNo.substring(1)) + 1; //0000+1
	        String tmpNo3 = String.format("%05d", tmpNo2);
	        String groupNo = tmpNo1.concat(tmpNo3);

	        //모임장으로 속해있는 그룹이 있다면 에러페이지 이동
	        if (groupAdmin == 1) {
	            return "error/alreadyGroupError";
	        }

	        model.addAttribute("areaList", BoardService.getAreaList());
	        model.addAttribute("groupNo", groupNo);

	        return "group/group_make";
	    }
 
	    @RequestMapping(value = "/groupMake.do", method = RequestMethod.POST, consumes = {"multipart/form-data"})
	    public String insertGroup(Group group,
	                              String groupNo,
	                              HttpServletRequest request) throws Exception {

	        String userid = group.getUserid();
	        groupService.groupMake(group, request, groupNo);

	        return "redirect:/groupJoin.do?userid=" + userid;
	    }

	    /*
	    @RequestMapping(value = "groupCategory.do", method = RequestMethod.GET)
	    public String categoryChoice(Model model) {

	        List<InterestCategoryDto> list = new ArrayList<>();
	        InterestCategoryDto interestCategory = new InterestCategoryDto();
	        list.add(interestCategory);

	        model.addAttribute("interestCategory", userService.getInterestCategory());

	        return "group/interestCategory";
	    }
		*/
	
//==================================================================================

	/*
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
*/
	@RequestMapping(value="/groupuserinfo")
	   public ModelAndView memberList(@RequestParam(value="group_no", defaultValue="1",required=false) int group_no,
	                           @RequestParam(value="page", defaultValue="1",required=false) int page,
	                           @RequestParam(value="limit", defaultValue="10", required=false) int limit,
	                           ModelAndView mv,
	                           @RequestParam(value="search_field", defaultValue="-1", required=false) int index,
	                           @RequestParam(value="search_word", defaultValue="", required=false) String search_word) {
	      
	      int listcount=groupservice.getSearchListCount(index, search_word, group_no);//총 리스트 수를 받아옴
	      List<GroupUser> list = groupservice.getSearchList(index, search_word, page, limit, group_no);
	      
	      int maxpage = (listcount + limit -1)/limit;
	      int startpage = ((page-1)/10) *10 +1;
	      int endpage = startpage +10-1;
	      
	      if(endpage>maxpage)
	         endpage=maxpage;
	      
	      mv.setViewName("group/groupuserinfo");
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

	
//	@RequestMapping(value="/list", method=RequestMethod.GET)
//	public ModelAndView grouplist(ModelAndView mv) {
//		mv.setViewName("main/grouplist");
//		return mv;
//		
//	}
	
	
//	@RequestMapping(value="/groupuserinfo", method =RequestMethod.GET)
//	public ModelAndView groupuserinfo(ModelAndView mv) {
//		mv.setViewName("group/groupuserinfo");
//		return mv;
//	}
	

	@RequestMapping(value="/groupDisband", method =RequestMethod.GET)
	public ModelAndView groupDisband(ModelAndView mv) {
		mv.setViewName("group/groupDisband");
		return mv;
	}
	
	@ResponseBody//각 메서드의 실행 결과는 JSON으로 변환되어 HTTP Response BODY에 설정된다
    @RequestMapping(value="/list_ajax", method=RequestMethod.GET)
    public Map<String,Object> boardListAjax(
          @RequestParam(value="group_no", defaultValue="1",required=false) int group_no,//모임 기능 구현되면 group_no는 파라미터로 넘어온 값으로 변경해야함(현재: 임의값 1로setting)
          @RequestParam(value="page", defaultValue="1", required=false)   int page,
          @RequestParam(value="limit", defaultValue="3", required=false)   int limit
          ) {
       
       int listcount=groupservice.getJoinListCount(group_no); //총 리스트 수를 받아옴
       //총 페이지 수
       int maxpage=(listcount+limit-1)/limit;
       //현재 페이지에 보여줄 시작 페이지 수
       int startpage=((page-1)/10)*10 +1;
       //현재 페이지에 보여줄 마지막 페이지 수
       int endpage=startpage +10-1;
       
       if(endpage>maxpage)
          endpage=maxpage;
       
       List<GroupJoin> list = groupservice.getJoinList(group_no, page,limit);//리스트를 받아옴
       
       Map<String,Object> map = new HashMap<String,Object>();
       map.put("page", page);
       map.put("maxpage",maxpage);
       map.put("startpage",startpage);
       map.put("endpage",endpage);
       map.put("listcount",listcount);
       map.put("list",list);
       map.put("limit",limit);
       return map;
    }
 
 
		@RequestMapping(value="/groupjoinagree")
		public ModelAndView test(
				ModelAndView mv) {
		mv.setViewName("group/groupjoinagree");
		return mv;
	}
		
		@ResponseBody
		@GetMapping(value = "/joinAccept")
		public int JoinAccept(@RequestParam("group_no") int group_no,
		@RequestParam("requestList[]") List<String> requestList) {
		      
		int result=groupservice.acceptmembers(requestList, group_no);
		return result;
		      
	}
		
		@RequestMapping(value="/groupjoin")
		public ModelAndView test2(
				ModelAndView mv) {
		mv.setViewName("group/groupjoin");
		return mv;
	}



}
