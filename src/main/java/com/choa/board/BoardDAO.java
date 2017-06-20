package com.choa.board;

import java.util.List;

import com.choa.util.ListInfo;
import com.choa.util.RowMaker;

public interface BoardDAO {
	
	//list
	public List<BoardDTO> list(ListInfo listInfo) throws Exception;
	
	//write
	public int write(BoardDTO boardDTO) throws Exception;
	
	//update
	public int update(BoardDTO boardDTO) throws Exception;
	
	//view
	public BoardDTO view(int num) throws Exception;
	
	//delete
	public int delete(int num) throws Exception;
	
	//count
	public int count(ListInfo listInfo) throws Exception;
	
	//hit
	public int hit(int num) throws Exception;
	
}
