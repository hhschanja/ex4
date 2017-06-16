package com.choa.notice;



import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.choa.board.BoardDTO;
import com.choa.board.BoardService;
import com.choa.freeboard.FreeboardDTO;
import com.choa.util.PageMaker;
import com.choa.util.PageResult;
import com.choa.util.RowMaker;


@Service 
public class NoticeServiceImpl implements BoardService{

	@Inject
	private NoticeDAOImpl noticeDAO;
	
	@Override
	public List<BoardDTO> list(int curPage) throws Exception {
		// TODO Auto-generated method stub
		
		int totalCount = noticeDAO.count();
		PageMaker pm = new PageMaker(curPage);
		RowMaker rowMaker = pm.getRowMaker("", "");
		PageResult pr = pm.getMakePage(totalCount);
		return noticeDAO.list(rowMaker);
	}

	@Override
	public int write(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.write(boardDTO);
	}

	@Override
	public BoardDTO view(int num) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.view(num);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.update(boardDTO);
	}

	@Override
	public int delete(int num) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.delete(num);
	}
	
	
}
