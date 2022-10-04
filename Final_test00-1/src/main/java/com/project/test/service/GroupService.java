package com.project.test.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.project.test.domain.Group;
import com.project.test.domain.GroupJoin;
import com.project.test.domain.GroupUser;

public interface GroupService {

	int getSearchListCount(int index, String search_word);

	int getJoinListCount(int group_no);

	List<GroupJoin> getJoinList(int group_no, int page, int limit);

	int acceptmembers(List<String> requestList, int group_no);

	int getSearchListCount(int index, String search_word, int group_no);

	List<GroupUser> getSearchList(int index, String search_word, int page, int limit, int group_no);

	
	//모임 생성
	Group groupBefore();

	void groupMake(Group group, HttpServletRequest request, String groupNo);

}
