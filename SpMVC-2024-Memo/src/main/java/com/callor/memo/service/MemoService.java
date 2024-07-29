package com.callor.memo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.memo.model.MemoVO;
@Service
public interface MemoService {
	public List<MemoVO> selectAll();
	public MemoVO findBySeq(int m_seq);
}
