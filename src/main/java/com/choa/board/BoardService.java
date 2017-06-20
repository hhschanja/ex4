package com.choa.board;

import java.util.List;

import com.choa.freeboard.FreeboardDTO;
import com.choa.util.ListInfo;

public interface BoardService {

	//list
	public List<BoardDTO> list(ListInfo listInfo) throws Exception;
	
	//write
	public int write(BoardDTO boardDTO) throws Exception;
	
	//view
	public BoardDTO view(int num) throws Exception;
	
	//update
	public int update(BoardDTO boardDTO) throws Exception;
	
	//delete
	public int delete(int num) throws Exception;
	
	
	
}
