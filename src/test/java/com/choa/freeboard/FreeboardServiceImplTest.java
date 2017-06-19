package com.choa.freeboard;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.choa.board.BoardDTO;
import com.choa.ex4.MyAbstractTest;

public class FreeboardServiceImplTest extends MyAbstractTest{

	@Inject
	private FreeboardServiceImpl freeboardServiceImpl;
	private FreeboardDAOImpl freeboardDAOImpl;
	

	public void list() throws Exception{
		
		List<BoardDTO> ar = freeboardServiceImpl.list(1);
		
		assertNotEquals(0, ar.size());
		
	}
	

	public void delete() throws Exception{
		
		int result = freeboardServiceImpl.delete(996);
		
		assertEquals(1, result);
		
	}
	

	public void write() throws Exception{
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setTitle("title");
		boardDTO.setContents("contents");
		boardDTO.setWriter("writer");
		
		int result = freeboardServiceImpl.write(boardDTO);
		
		assertEquals(1, result);
		
	}
	

	public void update() throws Exception{
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(997);
		boardDTO.setTitle("title");
		boardDTO.setContents("contents");
		boardDTO.setWriter("writer");
		
		int result = freeboardServiceImpl.update(boardDTO);
		
		assertEquals(1, result);
		
	}
	
	@Test
	public void count() throws Exception{
		
		int result = freeboardDAOImpl.count();
		
		assertNotEquals(0, result);
		
	}
	
	
}
