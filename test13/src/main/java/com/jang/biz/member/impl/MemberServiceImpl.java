package com.jang.biz.member.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jang.biz.member.MemberService;
import com.jang.biz.member.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO3 memberDAO; // 핵심로직을 수행할 객체
	
	@Override
	public void signUp(MemberVO vo) {
		memberDAO.signUp(vo);
	}

	@Override
	public void updateMember(MemberVO vo) {
		memberDAO.updateMember(vo);
	}

	@Override
	public void deleteMember(MemberVO vo) {
		memberDAO.deleteMember(vo);
	}

	@Override
	public MemberVO login(MemberVO vo) {
		return memberDAO.login(vo);
	}

}
