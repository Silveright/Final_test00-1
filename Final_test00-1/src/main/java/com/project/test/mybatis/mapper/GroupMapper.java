package com.project.test.mybatis.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.project.test.domain.*;

@Mapper
public interface GroupMapper {
	//모임 생성
    public int insertGroup(Group Group);

	public Group isGroupWriter(HashMap<String, Object> map);}
