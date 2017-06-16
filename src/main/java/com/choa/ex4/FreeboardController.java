package com.choa.ex4;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.choa.board.BoardDTO;
import com.choa.freeboard.FreeboardDAOImpl;
import com.choa.freeboard.FreeboardDTO;
import com.choa.freeboard.FreeboardServiceImpl;
import com.choa.util.PageMaker;
import com.choa.util.RowMaker;

@Controller
@RequestMapping(value="/freeboard/**")
public class FreeboardController {

	@Inject
	private FreeboardServiceImpl freeboardService;
	
	@RequestMapping(value="freeboardList")
	public String list(Model model, @RequestParam(defaultValue="1")Integer curPage) throws Exception{
		
		model.addAttribute("list", freeboardService.list(curPage)); //이렇게 바로 쓸 수 있음
		model.addAttribute("board","freeboard");
		//경로도 바꿔줘야지 board로 
		return "board/boardList";
		
	}
	
	@RequestMapping(value="freeboardWrite",method=RequestMethod.GET)
	public void write(Model model){
		
	}
	
	@RequestMapping(value="freeboardWrite",method=RequestMethod.POST)
	public void write(Model model, BoardDTO boardDTO) throws Exception{
		
		int result = freeboardService.write(boardDTO);
		
	}
	
	@RequestMapping(value="freeboardUpdate",method=RequestMethod.GET)
	public void update(Integer num) throws Exception{
		BoardDTO boardDTO = freeboardService.view(num);

	}
	
	@RequestMapping(value="freeboardUpdate",method=RequestMethod.POST)
	public void update(BoardDTO boardDTO) throws Exception{
		int result = freeboardService.update(boardDTO);
		
	}
	
	@RequestMapping(value="freeboardDelete")
	public void delete(Integer num) throws Exception{
		int result = freeboardService.delete(num);
	}
	
	
}
