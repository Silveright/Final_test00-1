package com.project.test.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.test.domain.GroupJoin;
import com.project.test.domain.GroupUser;
import com.project.test.mybatis.mapper.GroupAdminMapper;

@Service
public class GroupServiceImpl implements GroupService{
   
   private GroupAdminMapper dao;
   private static final Logger logger = LoggerFactory.getLogger(GroupServiceImpl.class);
   @Autowired
   public GroupServiceImpl(GroupAdminMapper dao) {
      this.dao = dao;
   }
   

   @Override
   public int acceptmembers(List<String> requestList, int group_no) {
      Map<String, Object> map = new HashMap<String, Object>();
         map.put("requestid", requestList);
         map.put("group_no", group_no);
      dao.acceptMember(map);
      dao.deleteRequest(map);
      
      return 1;
   }
   

   @Override
   public int getJoinListCount(int group_no) {
      // TODO Auto-generated method stub
      return dao.getJoinListCount(group_no);
   }

   @Override
   public List<GroupJoin> getJoinList(int group_no, int page, int limit) {
      Map<String, Object> map = new HashMap<String, Object>();
      map.put("group_no", group_no);
      int startrow = (page-1)*limit+1;
      int endrow=startrow+limit-1;
      map.put("start", startrow);
      map.put("end", endrow);
      return dao.getJoinList(map);
   }

@Override
public int getSearchListCount(int index, String search_word, int group_no) {
   Map<String, Object> map = new HashMap<String, Object>();
   map.put("group_no", group_no);
   if(index!=-1) {
      String[] search_field = new String[] {"userid", "area_name", "gender"};
      map.put("search_field", search_field[index]);
      map.put("search_word", "%"+ search_word+"%");
   }
   return dao.getSearchListCount(map);
}

@Override
public List<GroupUser> getSearchList(int index, String search_word, int page, int limit, int group_no) {
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("group_no", group_no);
	if(index!=-1) {
		String[] search_field = new String[] {"userid", "area_name", "gender"};
		map.put("search_field", search_field[index]);
		map.put("search_word", "%"+ search_word+"%");
	}
	int startrow = (page-1)*limit+1;
	int endrow=startrow+limit-1;
	map.put("start", startrow);
	map.put("end", endrow);
	return dao.getSearchList(map);
}


@Override
public int getSearchListCount(int index, String search_word) {
	// TODO Auto-generated method stub
	return 0;
}

 


}