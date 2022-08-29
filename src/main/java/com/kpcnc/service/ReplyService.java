package com.kpcnc.service;

import java.util.List;

import com.kpcnc.vo.ReplyVO;

public interface ReplyService {
	
	// �뙎湲� 議고쉶 
	public List<ReplyVO> readReply(int bno) throws Exception;
	
	// �뙎湲� �옉�꽦 
	public void writeReply(ReplyVO vo) throws Exception;
	
	// �뙎湲� �닔�젙 
	public void updateReply(ReplyVO vo) throws Exception;
	
	// �뙎湲� �궘�젣 
	public void deleteReply(ReplyVO vo) throws Exception;
	
	// �꽑�깮�맂 �뙎湲� 議고쉶
	public ReplyVO selectReply(int rno) throws Exception;
		
}
