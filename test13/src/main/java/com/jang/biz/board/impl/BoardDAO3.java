package com.jang.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jang.biz.board.BoardVO;

@Repository("boardDAO")
public class BoardDAO3 {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertBoard(BoardVO vo) {
		System.out.println("로그: dao3에 insertBoard함수 실행");
		System.out.println("insertBoard로그: ["+vo+"]");
		
		mybatis.insert("BoardDAO.insertBoard", vo);
		// mybatis.commit(); transactionManager가 없어지므로 커밋할게없다.
		// 트랜잭션 매니저를 별도에 객채를 스프링설정파일에 만들어야 commit()을 사용할 수 있다.
		// commit()은 myBatis객체를 사용중일 때를 하나의 트랜잭션 단위로 보고 사용하기 위함
	}
	public void updateBoard(BoardVO vo) {
		mybatis.update("BoardDAO.updateBoard", vo);
		//mybatis.commit();
	}
	public void deleteBoard(BoardVO vo) {
		mybatis.delete("BoardDAO.deleteBoard", vo);
		//mybatis.commit();
	}
	
	// commit을 안하는 이유는 DB에 데이터가 바뀌지 않기 때문
	public BoardVO selectOneBoard(BoardVO vo) { 
		return mybatis.selectOne("BoardDAO.selectOneBoard", vo);
	}
	public List<BoardVO> selectAllBoard(BoardVO vo) {
		return mybatis.selectList("BoardDAO.selectAllBoard", vo);
	}
}
