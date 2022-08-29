package com.kpcnc.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kpcnc.vo.MemberVO;

@Repository
public class MemverDAOImpl implements MemberDAO {

	@Inject SqlSession sql;

	// 회원가입 
	@Override
	public void register(MemberVO vo) throws Exception {
		sql.insert("memberMapper.register", vo);
	}

	// 로그인
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		return sql.selectOne("memberMapper.login", vo);
	}

	// 회원 정보 수정 
	// Service 에서 보낸 파라미터들을 memberUpdate(MemberVO)에 담는다.
	@Override
	public void memberUpdate(MemberVO vo) throws Exception {
		// vo 에 담긴 파라미터들은 memberMapper.xml에 memberMapper라는 namespace에
		// 아이디가 memberUpdate인 쿼리에 파라미터들을 넣어줍니다.
		sql.update("memberMapper.memberUpdate", vo);
	}

	// 회원 탈퇴 
	@Override
	public void memberDelete(MemberVO vo) throws Exception {
		// MemberVO 에 담긴 값들을 보내줍니다.
		// 그럼 xml에서 memberMapper.memberDelete에 보시면
		// #{userId}, #{userPass}에 파라미터 값이 매칭이 되겠지요.
		sql.delete("memberMapper.memberDelete", vo);
	}

	// 패스워드 체크 
	@Override
	public int passChk(MemberVO vo) throws Exception {
		int result = sql.selectOne("memberMapper.passChk", vo);
		return result;
	}

	// 아이디 중복 체크
	@Override
	public int idChk(MemberVO vo) throws Exception {
		int result = sql.selectOne("memberMapper.idChk", vo);
		return result;
	}
	
	
	
	
	
	
	
	
	
}
