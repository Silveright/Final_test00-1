package com.project.test.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
	
	//@Autowired
	private MemberService memberService;
    //private GroupService groupService;
	
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


	//모임 생성
		@GetMapping(value = "/groupMake") // 
//		@RequestMapping(value = "/write", method = RequestMethod.GET)
		public String group_make() {
			return "group/group_make";
		}
		
		@PostMapping("/add")
//		@RequestMapping(value = "/add", method = RequestMethod.POST)
		public String add(Group group, HttpServletRequest request)
				throws Exception{
			
			MultipartFile uploadfile = group.getUploadfile();
			logger.info("uploadfile = " + uploadfile);
			if(!uploadfile.isEmpty()) {
				String fileName = uploadfile.getOriginalFilename(); // 원래 파일명
				group.setGroup_original(fileName);// 원래 파일명 저장
				/* String saveFolder = request.getSession().getServletContext().getRealPath("resources")
						 + "/upload"; */
				String saveFolder = mysavefolder.getSavefolder();

				String fileDBName = fileDBName(fileName, saveFolder);
				logger.info("fileDBName = " + fileDBName);
				
				// transferTo(File path) : 업로드한 파일을 매개변수의 경로에 저장합니다.
				uploadfile.transferTo(new File(saveFolder + fileDBName));
				logger.info("fileDBName = " + saveFolder + fileDBName);
				//바뀐 파일명으로 저장
				group.setGroup_img(fileDBName);
			}
			logger.info(group.getArea_name());
			logger.info(group.getCatename());
			logger.info(group.getGroup_content());
			logger.info(group.getGroup_img());
			logger.info(group.getGroup_name());
			logger.info(group.getGroup_original());
			String userid=group.getUserid().substring(1);
			group.setUserid(userid);
			logger.info(group.getUserid());
			groupservice.insertGroup(group); // 저장메서드 호출
			logger.info(group.toString()); // selectKey로 정의한 BOARD_NUM 값 확인해 봅니다.
			return "redirect:/main/list";
		}
		
		
		private String fileDBName(String fileName, String saveFolder) {
			// 새로운 폴더 이름 : 오늘 년+월+일
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR); // 오늘 년도 구합니다.
			int month = c.get(Calendar.MONTH) + 1; // 오늘 월을 구합니다.
			int date = c.get(Calendar.DATE); // 오늘 일 구합니다.
			
			String homedir = saveFolder + "/" + year + "-" + month + "-" + date;
			logger.info(homedir);
			File path1 = new File(homedir);
			if(!(path1.exists())) {
				path1.mkdir(); // 새로운 폴더를 생성
			}
			
			// 난수를 구합니다.
			Random r = new Random();
			int random = r.nextInt(10000000);
			
			/**** 확장자 구하기 시작 ****/
			int index = fileName.lastIndexOf(".");
			// 문자열에서 특정 문자열의 위치 값(index)를 반환합니다.
			// indexOf가 처음 발견되는 문자열에 대한 index를 반환하는 반면,
			// lastIndexOf는 마지막으로 발견되는 문자열의 index를 반환합니다.
			// (파일명에 점에 여러개 있을 경우 맨 마지막에 발견되는 문자열의 위치를 리턴합니다.)
			logger.info("index = " + index);
			
			String fileExtension = fileName.substring(index + 1);
			logger.info("fileExtension = " + fileExtension);
			/**** 확장자 구하기 끝 ****/
			
			// 새로운 파일명
			String refileName = "bbs" + year + month + date + random + "." + fileExtension;
			logger.info("refileName = " + refileName);
			
			// 오라클 디비에 저장될 파일 명
//			String fileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;
			String fileDBName = File.separator + year + "-" + month + "-" + date + File.separator + refileName;
			logger.info("fileDBName = " + fileDBName);
			return fileDBName;
		}
		
		// detail?num=9요청시 파라미터 num의 값을 int num에 저장합니다.
		@GetMapping("/group_detail")
		public ModelAndView Detail(
				int num, ModelAndView mv,
				HttpServletRequest request,
				@RequestHeader(value = "referer") String beforeURL)
		// String bsforeURL = request.getHeader("referer"); 의미로
		// 어느 주소에서 detail로 이동했지만 header의 정보 중에서 "referer"를 통해 알 수 있습니다.
		{
			
			Group group = groupservice.getDetail(num);
			// board=null; // error 페이지 이동 확인하고자 임의로 지정합니다.
			if(group == null) {
				logger.info("가입신청 페이지 이동 실패");
				mv.setViewName("error/error");
				mv.addObject("url",request.getRequestURL());
				mv.addObject("message","가입신청 페이지 이동 실패입니다.");
			}else {
				logger.info("가입신청 성공");
				int count = groupservice.getMemberCount(num);
				mv.setViewName("group/group_detail");
				mv.addObject("count", count);
				mv.addObject("group_no", group.getGroup_no());
				mv.addObject("groupdata", group);
			}
			return mv;
		}
	
//==================================================================================

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
	      mv.addObject("group_no",group_no);
	      return mv;
	   }

	
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
       map.put("group_no",group_no);
       map.put("limit",limit);
       return map;
    }
 
 
		@RequestMapping(value="/groupjoinagree")
		public ModelAndView test(int group_no,
				ModelAndView mv) {
			mv.addObject("group_no", group_no);
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
		


		@ResponseBody
		@GetMapping(value="/main")
		public int getUserRole(@RequestParam("group_no") int group_no, String userid) {
			GroupUser user= groupservice.getUserRole(group_no, userid);
			return (user==null) ? -1: user.getGroup_role();
	}

		//그룹 가입신청
		@RequestMapping(value = "/insert", method = RequestMethod.GET)
		public String member_delete(String userid, int group_no) {
			groupservice.insert(userid, group_no);
			
			return "redirect:/group/group_detail?num="+group_no;
		}

}
