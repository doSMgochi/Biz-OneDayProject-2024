package com.callor.memo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.callor.memo.model.MemoVO;

public interface MemoDao {
	@Select("SELECT * FROM tbl_memo ORDER BY m_seq")
	public List<MemoVO> selectAll();
	
	public int insert(MemoVO memoVO);
	public int update(MemoVO memoVO);

	@Delete("DELETE FROM tbl_memo WHERE m_seq = #{m_seq}")
	public int delete(int m_seq);
	
	@Select("SELECT * FROM tbl_memo WHERE m_seq = #{m_seq}")
	public MemoVO findBySeq(int m_seq);
	
	public int findLastSeq();
}
