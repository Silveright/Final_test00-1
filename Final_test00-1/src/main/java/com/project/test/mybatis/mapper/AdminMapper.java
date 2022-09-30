package com.project.test.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.project.test.domain.AdminChartAreaDate;
import com.project.test.domain.AdminChartCategory;
import com.project.test.domain.AdminMember;
import com.project.test.domain.Calendar;

@Mapper
public interface AdminMapper {

	int getTotaluser();

	int getTotalschedule();

	String getBestgroup();

	int getTotalgroup();

	List<AdminChartAreaDate> getChartareadate();


	List<AdminChartCategory> getPieChart();

	int getSearchListCount(Map<String, String> map);

	List<AdminMember> getSearchList(Map<String, Object> map);

	int getGroupSearchListCount(Map<String, String> map);

	List<AdminMember> getGroupSearchList(Map<String, Object> map);

	void delete(String userid);

	List<Calendar> getChartSchedule();

	List<AdminChartCategory> getChartGender();

}
