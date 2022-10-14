package com.project.test.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.project.test.domain.GroupJoin;
import com.project.test.domain.GroupUser;

@Mapper
public interface GroupAdminMapper {


   void acceptMember(Map<String, Object> map);

   void deleteRequest(Map<String, Object> map);

   int getJoinListCount(int group_no);

   List<GroupJoin> getJoinList(Map<String, Object> map);

   int getSearchListCount(Map<String, Object> map);

   List<GroupUser> getSearchList(Map<String, Object> map);

int getUserSearchListCount(Map<String, Object> map);

List<GroupUser> getUserSearchList(Map<String, Object> map);





}