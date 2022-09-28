package com.project.test.service;

import java.util.List;

import com.project.test.domain.Member;

public interface GroupService {

	int getSearchListCount(int index, String search_word);

	List<Member> getSearchList(int index, String search_word, int page, int limit);
}
