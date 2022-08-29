package com.kpcnc.dao;

import java.util.List;
import java.util.Map;

import com.kpcnc.vo.BoardVO;
import com.kpcnc.vo.Criteria;
import com.kpcnc.vo.SearchCriteria;

public interface BoardDAO {

	// 寃뚯떆湲� �옉�꽦
	public void write(BoardVO boardVO) throws Exception;

	// 寃뚯떆臾� 紐⑸줉 議고쉶
	public List<BoardVO> list(SearchCriteria scri) throws Exception;
	
	// 寃뚯떆臾� 珥� 媛��닔 
	public int listCount(SearchCriteria scri) throws Exception;
	
	// 寃뚯떆臾� 議고쉶
	public BoardVO read(int bno) throws Exception;
	
	// 寃뚯떆臾� �닔�젙
	public void update(BoardVO boardVO) throws Exception;
		
	// 寃뚯떆臾� �궘�젣
	public void delete(int bno) throws Exception;
	
	// 泥⑤��뙆�씪 �뾽濡쒕뱶
	public void insertFile(Map<String,Object> map) throws Exception;
	
	// 泥⑤��뙆�씪 議고쉶
	public List<Map<String, Object>> selectFileList(int bno) throws Exception;

	// 첨부파일 다운 
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception;
	
	// 첨부파일 수정 
	public void updateFile(Map<String, Object> map) throws Exception;

	// 게시판 조회수 
	public void boardHit(int bno) throws Exception;
}
