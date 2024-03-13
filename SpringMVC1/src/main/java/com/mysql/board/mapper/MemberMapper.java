package com.mysql.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mysql.board.entity.Member;

@Mapper
public interface MemberMapper {
	public List<Member> getMemberList();
	public int vaildId(String id);
	public int loginCheck(Member member);
	public Member memberInfo(int num);
	public Member updateMemberInfo(String id);
	public void insertMember(Member member);
	public void updateMember(Member member);
	public void removeMember(String id);
}
