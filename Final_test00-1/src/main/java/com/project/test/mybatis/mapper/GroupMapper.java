package com.project.test.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.test.domain.*;

@Mapper
public interface GroupMapper {
	//모임 생성
    public void insertGroup(Group Group);

	public Group isGroupWriter(HashMap<String, Object> map);

	public List<Group> getGroupList(HashMap<String, Integer> map);

	public int getListCount();

	public Group getDetail(int num);

	public GroupUser getUserRole(HashMap<String, Object> map);

	public int getMemberCount(int num);

	public void insert(HashMap<String, Object> map);

	public List<Group_Board> getGroupBoardList(HashMap<String, Integer> map);

	public int getBoardListCount();
	
}
