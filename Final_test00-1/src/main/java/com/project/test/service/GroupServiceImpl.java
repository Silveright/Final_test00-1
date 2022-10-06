package com.project.test.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.test.domain.Group;
import com.project.test.domain.GroupJoin;
import com.project.test.domain.GroupUser;
import com.project.test.mybatis.mapper.GroupAdminMapper;
import com.project.test.mybatis.mapper.GroupMapper;

@Service
public class GroupServiceImpl implements GroupService {

	private GroupAdminMapper dao;
	private GroupMapper gdao;
	private static final Logger logger = LoggerFactory.getLogger(GroupServiceImpl.class);

	@Autowired
	public GroupServiceImpl(GroupAdminMapper dao, GroupMapper gdao) {
		this.dao = dao;
		this.gdao = gdao;
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
		int startrow = (page - 1) * limit + 1;
		int endrow = startrow + limit - 1;
		map.put("start", startrow);
		map.put("end", endrow);
		return dao.getJoinList(map);
	}

	@Override
	public int getSearchListCount(int index, String search_word, int group_no) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("group_no", group_no);
		if (index != -1) {
			String[] search_field = new String[] { "userid", "area_name", "gender" };
			map.put("search_field", search_field[index]);
			map.put("search_word", "%" + search_word + "%");
		}
		return dao.getSearchListCount(map);
	}

	@Override
	public List<GroupUser> getSearchList(int index, String search_word, int page, int limit, int group_no) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("group_no", group_no);
		if (index != -1) {
			String[] search_field = new String[] { "userid", "area_name", "gender" };
			map.put("search_field", search_field[index]);
			map.put("search_word", "%" + search_word + "%");
		}
		int startrow = (page - 1) * limit + 1;
		int endrow = startrow + limit - 1;
		map.put("start", startrow);
		map.put("end", endrow);
		return dao.getSearchList(map);
	}

	@Override
	public int getSearchListCount(int index, String search_word) {
		// TODO Auto-generated method stub
		return 0;
	}

	//=======================================================================	
		//모임 생성
		@Override
		public void insertGroup(Group group) {
			gdao.insertGroup(group);
			
		}
		
		@Override
		public boolean isGroupWriter(int num, String userid) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("num", num);
			map.put("userid", userid);
			Group result = gdao.isGroupWriter(map);
			if(result==null)
				return false;
			else
				return true;
		}


		@Override
		public List<String> getDeleteFileList() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void deleteFileList(String filename) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int groupModify(Group modifygroup) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int groupDelete(int num) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public List<Group> getGroupList(int page, int limit) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			int startrow = (page - 1) * limit + 1;
			int endrow = startrow + limit - 1;
			map.put("start", startrow);
			map.put("end", endrow);
			return gdao.getGroupList(map);
		}

		@Override
		public int getListCount() {
			return gdao.getListCount();
		}


		@Override
		public Group getDetail(int num) {
			return gdao.getDetail(num);
		}
		


		@Override
		public int getListCount(int num) {
			return gdao.getListCount();
		}

		@Override
		public GroupUser getUserRole(int group_no, String userid) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("group_no", group_no);
			map.put("userid", userid);
			return gdao.getUserRole(map);
		}

		@Override
		public int getMemberCount(int num) {
			// TODO Auto-generated method stub
			return gdao.getMemberCount(num);
		}


}