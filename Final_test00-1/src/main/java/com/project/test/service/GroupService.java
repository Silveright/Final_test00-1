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
	public void insertGroup(Group group);
	
	public List<String> getDeleteFileList();

	public void deleteFileList(String filename);
	
	//모임 수정
	public int groupModify(Group modifygroup);
	
	//모임 삭제
	public int groupDelete(int num);
	
	//모임장인지 확인
	public boolean isGroupWriter(int num, String userid);
	
	//그룹 리스트 
	List<Group> getGroupList(int page, int limit);

	int getListCount();


}
