package com.project.test.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.test.domain.Calendar;
import com.project.test.domain.CalendarLoad;
import com.project.test.service.CalendarService;

@Controller
@RequestMapping(value="/calendar")
public class CalendarController {
	private static final Logger logger = LoggerFactory.getLogger(CalendarController.class);
	private CalendarService calendarService;
	
	@Autowired
	public CalendarController(CalendarService calendarService) {
		this.calendarService = calendarService;
	}
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public ModelAndView login(ModelAndView mv) {
		mv.setViewName("calendar/calendar");
		return mv;
	}

	@RequestMapping(value="/view2", method=RequestMethod.GET)
	public ModelAndView view2(@RequestParam("group_no") String group_no, ModelAndView mv) {
		logger.info("모임번호는"+group_no);
		mv.addObject("group_no",group_no);
		mv.setViewName("calendar/calendar2");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = "/loadevent", method = RequestMethod.GET)
    public List<CalendarLoad> Calendarlist(@RequestParam("group_no") String group_no) {
		logger.info("모임번호는"+group_no);
        List<CalendarLoad> list = calendarService.getCalendarList(group_no);
        return list;
    }

	@ResponseBody
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public Calendar Calendardetail(@RequestParam("group_no") String group_no,
										  @RequestParam("calendar_no") String calendar_no) {
		Calendar calendar = calendarService.getCalendarDetail(calendar_no);
		logger.info("시작시간"+calendar.getStartdate());
		return calendar;
	}

	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public int CalendarAdd(Calendar calendar) {
		//logger.info("시작시간"+calendar.getStartdate());
		return calendarService.CalendarAdd(calendar);
	}

	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public int CalendarDelete(@RequestParam("calendar_no") int calendar_no) {
		//logger.info("시작시간"+calendar.getStartdate());
		return calendarService.CalendarDelete(calendar_no);
	}

	@ResponseBody
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public int CalendarModify(Calendar calendar) {
		//logger.info("시작시간"+calendar.getStartdate());
		return calendarService.CalendarModify(calendar);
	}

	@ResponseBody
	@RequestMapping(value = "/modifydate", method = RequestMethod.GET)
	public int CalendarModifyDate(String startdate, int calendar_no) {
		logger.info("일정번호"+calendar_no);
		return calendarService.CalendarModifyDate(startdate,calendar_no);
	}
}
