package com.callor.memo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.memo.dao.MemoDao;
import com.callor.memo.model.MemoVO;
import com.callor.memo.service.MemoService;

@Service
public class MemoServiceImpl implements MemoService {

	private final MemoDao memoDao;

	public MemoServiceImpl(MemoDao memoDao) {
		super();
		this.memoDao = memoDao;
	}

	@Override
	public List<MemoVO> selectAll() {
		return memoDao.selectAll();
	}

	@Override
	public MemoVO findBySeq(int m_seq) {
		MemoVO memoVO = memoDao.findBySeq(m_seq);
		return memoVO;
	}

}
