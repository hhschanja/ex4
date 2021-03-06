package com.choa.freeboard;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.choa.board.BoardDTO;
import com.choa.board.BoardService;
import com.choa.util.ListInfo;
import com.choa.util.PageMaker;
import com.choa.util.PageResult;
import com.choa.util.RowMaker;

@Service
public class FreeboardServiceImpl implements BoardService{
	
	@Inject
	private FreeboardDAOImpl freeboardDAO;
	
	
	@Override
	public List<BoardDTO> list(ListInfo listInfo) throws Exception {
		// TODO Auto-generated method stub
		int totalCount = freeboardDAO.count(listInfo);
		listInfo.setRow();
		listInfo.pageResult(totalCount);
		return freeboardDAO.list(listInfo);
	}

	@Override
	public int write(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return freeboardDAO.write(boardDTO);
	}

	@Override
	public BoardDTO view(int num) throws Exception {
		// TODO Auto-generated method stub
		return freeboardDAO.view(num);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return freeboardDAO.update(boardDTO);
	}

	@Override
	public int delete(int num) throws Exception {
		// TODO Auto-generated method stub
		return freeboardDAO.delete(num);
	}

	
}
