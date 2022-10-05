package com.jang.biz.member.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jang.biz.member.MemberVO;

@Repository("memberDAO")
public class MemberDAO3 {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void signUp(MemberVO vo) {
		System.out.println("로그: dao3에 signUp함수 실행");
		mybatis.insert("MemberDAO.signUp", vo);
		// mybatis.commit(); transactionManager가 없어지므로 커밋할게없다.
		// 트랜잭션 매니저를 별도에 객채를 스프링설정파일에 만들어야 commit()을 사용할 수 있다.
		// commit()은 myBatis객체를 사용중일 때를 하나의 트랜잭션 단위로 보고 사용하기 위함
	}
	public void updateMember(MemberVO vo) {
		mybatis.update("MemberDAO.updateMember", vo);
		//mybatis.commit();
	}
	public void deleteMember(MemberVO vo) {
		mybatis.delete("MemberDAO.deleteMember", vo);
		//mybatis.commit();
	}
	
	// commit을 안하는 이유는 DB에 데이터가 바뀌지 않기 때문에 트랜잭션 필요 x
	public MemberVO login(MemberVO vo) { 
		return mybatis.selectOne("MemberDAO.login", vo);
	}

}
