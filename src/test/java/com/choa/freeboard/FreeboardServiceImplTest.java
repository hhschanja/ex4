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
	
	
	public void test() throws Exception{
		
		List<BoardDTO> ar = freeboardServiceImpl.list(1);
		
		assertEquals(0, ar.size());
		
	}
	
	
	public void test2() throws Exception{
		
		int result = freeboardServiceImpl.delete(190);
		
		assertEquals(1, result);
		
	}
	
	@Test
	public void test3() throws Exception{
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setTitle("title");
		boardDTO.setContents("contents");
		boardDTO.setWriter("writer");
		
		int result = freeboardServiceImpl.write(boardDTO);
		
		assertEquals(1, result);
		
	}
	
}
