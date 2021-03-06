package com.choa.freeboard;


import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.choa.board.BoardDAO;
import com.choa.board.BoardDTO;
import com.choa.util.ListInfo;
import com.choa.util.RowMaker;

@Repository
public class FreeboardDAOImpl implements BoardDAO{
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "FreeboardMapper.";
	
	@Override
	public List<BoardDTO> list(ListInfo listInfo) throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"list", listInfo);
	}

	@Override
	public int write(BoardDTO boardDTO) throws Exception {
	
		return sqlSession.insert(NAMESPACE+"write", boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		
		return sqlSession.update(NAMESPACE+"update", boardDTO);
	}

	@Override
	public BoardDTO view(int num) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"view", num);
	}

	@Override
	public int delete(int num) throws Exception {
		// TODO Auto-generated method stub
		
		return sqlSession.delete(NAMESPACE+"delete", num);
	}

	@Override
	public int count(ListInfo listInfo) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"count",listInfo);
	}

	@Override
	public int hit(int num) throws Exception {
	
		return sqlSession.update(NAMESPACE+"hit",num);
				
	}



}
