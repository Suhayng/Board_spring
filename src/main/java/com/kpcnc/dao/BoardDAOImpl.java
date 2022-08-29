package com.kpcnc.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kpcnc.vo.BoardVO;
import com.kpcnc.vo.Criteria;
import com.kpcnc.vo.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sqlSession;
	
	// 寃뚯떆湲� �옉�꽦
	@Override
	public void write(BoardVO boardVO) throws Exception {
		sqlSession.insert("boardMapper.insert", boardVO);
		
	}

	// 寃뚯떆臾� 紐⑸줉 議고쉶 
	@Override
	public List<BoardVO> list(SearchCriteria scri) throws Exception {
		
		return sqlSession.selectList("boardMapper.listPage", scri);
	}
	
	// 寃뚯떆臾� 珥� 媛��닔 
	@Override
	public int listCount(SearchCriteria scri) throws Exception {
		return sqlSession.selectOne("boardMapper.listCount", scri);
	}


	// 寃뚯떆臾� 議고쉶 
	@Override
	public BoardVO read(int bno) throws Exception {
		
		return sqlSession.selectOne("boardMapper.read", bno);
	}


	// 寃뚯떆臾� �닔�젙
	@Override
	public void update(BoardVO boardVO) throws Exception {
		
		sqlSession.update("boardMapper.update", boardVO);
	}

	// 寃뚯떆臾� �궘�젣
	@Override
	public void delete(int bno) throws Exception {
		
		sqlSession.delete("boardMapper.delete", bno);
	}

	// 泥⑤��뙆�씪 �뾽濡쒕뱶 
	@Override
	public void insertFile(Map<String, Object> map) throws Exception {
		sqlSession.insert("boardMapper.insertFile", map);
	}

	// 泥⑤��뙆�씪 議고쉶 
	@Override
	public List<Map<String, Object>> selectFileList(int bno) throws Exception {
		return sqlSession.selectList("boardMapper.selectFileList", bno);
	}

	// 첨부파일 다운로드
	@Override
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("boardMapper.selectFileInfo", map);
	}

	// 첨부파일 수정 
	@Override
	public void updateFile(Map<String, Object> map) throws Exception {
		sqlSession.update("boardMapper.updateFile", map);
	}

	// 게시판 조회수 
	@Override
	public void boardHit(int bno) throws Exception {
		sqlSession.update("boardMapper.boardHit", bno);
	}

	
	
	
	
	

	
}