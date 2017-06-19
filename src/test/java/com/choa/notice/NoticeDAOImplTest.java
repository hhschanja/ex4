package com.choa.notice;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.choa.board.BoardDTO;
import com.choa.ex4.MyAbstractTest;
import com.choa.util.PageMaker;
import com.choa.util.RowMaker;

public class NoticeDAOImplTest extends MyAbstractTest{

	@Inject
	private NoticeDAOImpl noticeDAO;
	
	
	public void test() throws Exception{
		// view메소드를 테스트 하려면 NoticeDAO가 있어야지 근데 내가 여기서 만들 수 없어
		// 만들어봤자 datasource가 없잖아 그러니 DAO메소드 실행이 안돼지
		//그래서 만들어진 놈을 가지고와서 위에다가 주입 시켜주면돼
		
		//그런데 톰캣이 없으니까 안돼잖아?
		//그래서 서블렛이랑 루트 컨텍스트의 위치를 알려줘야해
		
		BoardDTO boardDTO = noticeDAO.view(180);
		System.out.println(boardDTO.getTitle());
		assertNotNull(boardDTO); //junit 메소드 중에 null인지 아닌지
	}
	
	 //반드시 test에는 줘야함, test가 적힌 애들은 다하는거야 그때그때 지우고 해주면돼
	public void test2()throws Exception{
		
		int result = noticeDAO.delete(173);
		assertEquals(1, result); //result가 1인지 확인해라~
	}
	
	
	public void test3()throws Exception{
		
		PageMaker pm = new PageMaker(1);
		RowMaker rm = pm.getRowMaker("", "");
		List<BoardDTO> ar = noticeDAO.list(rm);
		
		assertEquals(0, ar.size()); //성공했다면 아무것도 안가지고 온거지
		
	}
	

	public void connection() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		 noticeDTO.setWriter("choa");
		 noticeDTO.setTitle("hi");
		 noticeDTO.setContents("hi");
		int result = noticeDAO.write(noticeDTO);
		
		assertEquals(1, result);
		
	}
	

	public void connection1() throws Exception{
		
		int result = noticeDAO.delete(211);
		
		assertEquals(1, result);
		
	}
	
	@Test
	public void connection2() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		 noticeDTO.setNum(210);
		 noticeDTO.setWriter("gaga");
		 noticeDTO.setTitle("hi");
		 noticeDTO.setContents("hi");
		int result = noticeDAO.update(noticeDTO);
		
		assertEquals(1, result);
		
	}
	
	
	

}
