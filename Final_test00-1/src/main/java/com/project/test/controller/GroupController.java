package com.project.test.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.test.domain.Group;
import com.project.test.domain.Member;
import com.project.test.service.GroupService;
import com.project.test.service.MySaveFolder;

@Controller
@RequestMapping(value="/group")
public class GroupController {
	private static final Logger logger = LoggerFactory.getLogger(GroupController.class);
	private GroupService groupservice;
	private MySaveFolder mysavefolder;
	
	 @Autowired 
	 public GroupController(GroupService groupservice, MySaveFolder mysavefolder) {
	 this.groupservice = groupservice;
	 this.mysavefolder = mysavefolder; 
	 }
	 
	
	//@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView grouplist(ModelAndView mv) {
		mv.setViewName("main/grouplist");
		return mv;
		
	}
	
	@GetMapping(value="/groupmake")
	public String groupmake () {
		return "/group/groupmake";
	}
 /*
	수정해야함	(모임 생성)
	@PostMapping("/add")
	public String add(Group group, HttpServletRequest request)
			throws Exception{
		
		MultipartFile uploadfile = group.getUploadfile();
		
		if(!uploadfile.isEmpty()) {
			String fileName = uploadfile.getOriginalFilename(); // 원래 파일명
			group.setG(fileName);// 원래 파일명 저장
			// String saveFolder = request.getSession().getServletContext().getRealPath("resources")
			//		 + "/upload";
			String saveFolder = mysavefolder.getSavefolder();

			String fileDBName = fileDBName(fileName, saveFolder);
			logger.info("fileDBName = " + fileDBName);
			
			// transferTo(File path) : 업로드한 파일을 매개변수의 경로에 저장합니다.
			uploadfile.transferTo(new File(saveFolder + fileDBName));
			logger.info("fileDBName = " + saveFolder + fileDBName);
			//바뀐 파일명으로 저장
			board.setBOARD_FILE(fileDBName);
		}
		
		boardService.insertBoard(board); // 저장메서드 호출
		logger.info(board.toString()); // selectKey로 정의한 BOARD_NUM 값 확인해 봅니다.
		return "redirect:list";
	}
*/
	
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
