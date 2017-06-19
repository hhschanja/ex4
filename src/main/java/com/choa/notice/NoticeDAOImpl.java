package com.choa.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.choa.board.BoardDAO;
import com.choa.board.BoardDTO;
import com.choa.util.DBConnect;
import com.choa.util.RowMaker;

@Repository //NoticeDAO noticeDAO = new NoticeDAO(); 인거야
public class NoticeDAOImpl implements BoardDAO{
	
	@Inject //바로 주입
	private SqlSession sqlSession;
	private static final String NAMESPACE = "NoticeMapper."; //final 바뀌지마라~ final은 상수로 쓰라는건데 상수는 전부 대문자~
	
	@Override
	public List<BoardDTO> list(RowMaker rowMaker) throws Exception {
			
		return sqlSession.selectList(NAMESPACE+"list", rowMaker);
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
		
		BoardDTO boardDTO = sqlSession.selectOne(NAMESPACE+"view", num); //NoticeMapper.view 
		//리턴을 보드로 해줘야하니까~
		
		return boardDTO;
	}

	@Override
	public int delete(int num) throws Exception {
		
		return sqlSession.delete(NAMESPACE+"delete",num);
	}

	@Override
	public int count() throws Exception {
	
		return sqlSession.selectOne(NAMESPACE+"count");
	}

	@Override
	public int hit(int num) throws Exception {
		
		return sqlSession.update(NAMESPACE+"hit",num);
	}

	
	
}