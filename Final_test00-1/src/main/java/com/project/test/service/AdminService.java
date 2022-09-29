package com.project.test.service;

import java.util.List;

import com.project.test.domain.AdminChartAreaDate;
import com.project.test.domain.AdminChartCategory;
import com.project.test.domain.AdminMember;
import com.project.test.domain.Calendar;
import com.project.test.domain.Member;

public interface AdminService {

	int gettotaluser();

	int gettotalschedule();

	String getbestgroup();

	int gettotalgroup();

	List<AdminChartAreaDate> getChartareaDate();


	List<AdminChartCategory> getPieChart();

	int getSearchListCount(int index, String search_word);

	List<AdminMember> getSearchList(int index, String search_word, int page, int limit);

	int getGroupSearchListCount(int index, String search_word);

	List<AdminMember> getGroupSearchList(int index, String search_word, int page, int limit);

	void delete(String userid);

	List<Calendar> getChartSchedule();

	List<AdminChartCategory> getPieChart2();

}
