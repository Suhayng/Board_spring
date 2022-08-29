package com.kpcnc.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kpcnc.dao.BoardDAO;
import com.kpcnc.util.FileUtils;
import com.kpcnc.vo.BoardVO;
import com.kpcnc.vo.Criteria;
import com.kpcnc.vo.SearchCriteria;

@Service
public class BoardServiceImpl implements BoardService {

	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	
	@Inject
	private BoardDAO dao;
	
	// 寃뚯떆湲� �옉�꽦
	@Override
	public void write(BoardVO boardVO, MultipartHttpServletRequest mpRequest) throws Exception {
		dao.write(boardVO);
		
		List<Map<String,Object>> list = fileUtils.parseInsertFileInfo(boardVO, mpRequest); 
		int size = list.size();
		for(int i=0; i<size; i++){ 
			dao.insertFile(list.get(i)); 
		}
	}

	// 寃뚯떆湲� 紐⑸줉 議고쉶 
	@Override
	public List<BoardVO> list(SearchCriteria scri) throws Exception {
		
		return dao.list(scri);
	}
	
	// 寃뚯떆臾� 珥� 媛��닔 
	@Override
	public int listCount(SearchCriteria scri) throws Exception {
		return dao.listCount(scri);
	}

	// 寃뚯떆臾� �닔�젙 
	@Override
	public void update(BoardVO boardVO) throws Exception {

		dao.update(boardVO);
	}

	// 寃뚯떆臾� �궘�젣 
	@Override
	public void delete(int bno) throws Exception {
		
		dao.delete(bno);
	}

	// 泥⑤��뙆�씪 議고쉶
	@Override
	public List<Map<String, Object>> selectFileList(int bno) throws Exception {
		return dao.selectFileList(bno);
	}

	//첨부파일 다운로드 
	@Override
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectFileInfo(map);
	}

	@Override
	public void update(BoardVO boardVO, 
					   String[] files, 
					   String[] fileNames,
					   MultipartHttpServletRequest mpRequest) throws Exception {
		dao.update(boardVO);
		
		List<Map<String, Object>> list = fileUtils.parseUpdateFileInfo(boardVO, files, fileNames, mpRequest);
		Map<String, Object> tempMap = null;
		int size = list.size();
		for(int i = 0; i<size; i++) {
			tempMap = list.get(i);
			if(tempMap.get("IS_NEW").equals("Y")) {
				dao.insertFile(tempMap);
			}else {
				dao.updateFile(tempMap);
			}
		}
	}
	
	// 게시물 조회
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public BoardVO read(int bno) throws Exception {
			dao.boardHit(bno);
		return dao.read(bno);
	}	


	
	
}