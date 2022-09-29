package com.project.test.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.test.domain.Member;
import com.project.test.mybatis.mapper.AdminMapper;

@Service
public class GroupServiceImpl implements GroupService{
	
	private AdminMapper dao;
	
	@Autowired
	public GroupServiceImpl(AdminMapper dao) {
		this.dao = dao;
	}
	
	@Override
	public int getSearchListCount(int index, String search_word) {
		Map<String, String> map = new HashMap<String, String>();
		if(index!=-1) {
			String[] search_field = new String[] {"userid", "area_name", "gender"};
			map.put("search_field", search_field[index]);
			map.put("search_word", "%"+ search_word+"%");
		}
		return dao.getSearchListCount(map);
	}
	
	@Override
	public List<Member> getSearchList(int index, String search_word, int page, int limit) {
		Map<String, Object> map = new HashMap<String, Object>();
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

}
