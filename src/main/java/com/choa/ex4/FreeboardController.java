package com.choa.ex4;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.choa.board.BoardDTO;
import com.choa.freeboard.FreeboardServiceImpl;


@Controller
@RequestMapping(value="/freeboard/**")
public class FreeboardController {

	@Inject
	private FreeboardServiceImpl freeboardService;
	
	@RequestMapping(value="freeboardList")
	public String list(Model model, @RequestParam(defaultValue="1")Integer curPage,String search, String kind) throws Exception{
		
		model.addAttribute("list", freeboardService.list(curPage,search,kind)); //이렇게 바로 쓸 수 있음
		model.addAttribute("board","freeboard");
		//경로도 바꿔줘야지 board로 
		return "board/boardList";
		
	}
	
	@RequestMapping(value="freeboardWrite",method=RequestMethod.GET)
	public String write(Model model){
		
		model.addAttribute("board", "freeboard");
		model.addAttribute("path", "Write");
		
		return "board/boardWrite";
		
	}
	
	@RequestMapping(value="freeboardWrite",method=RequestMethod.POST)
	public String write(Model model, BoardDTO boardDTO) throws Exception{
		
		int result = freeboardService.write(boardDTO);
		
		if(result>0){
			model.addAttribute("message", "SUCCESS");
		}else{
			model.addAttribute("message", "FAIL");
		}
		
		model.addAttribute("path", "freeboardList");
		
		
		return "common/result";
		
	}
	
	@RequestMapping(value="freeboardUpdate",method=RequestMethod.GET)
	public String update(Integer num, Model model) throws Exception{
		BoardDTO boardDTO = freeboardService.view(num);
		model.addAttribute("dto", boardDTO);
		model.addAttribute("path", "Update");
		model.addAttribute("board", "notice");
		
		return "board/boardWrite";
		
	}
	
	@RequestMapping(value="freeboardUpdate",method=RequestMethod.POST)
	public String update(BoardDTO boardDTO,Model model) throws Exception{
		int result = freeboardService.update(boardDTO);
		
		String message = "FAIL";
		
		if(result>0){
			message = "SUCCESS";
		}
		
		model.addAttribute("path", "freeboardList");
		model.addAttribute("message", message);
		
		return "common/result";
		
	}
	
	@RequestMapping(value="freeboardDelete")
	public String delete(Integer num,Model model) throws Exception{
		int result = freeboardService.delete(num);
		
		String message = "FAIL";
		
		if(result>0){
			message = "SUCCESS";
		}
		
		model.addAttribute("message", message);
		model.addAttribute("path", "freeboardList");
		
		return "common/result";
	}
	
	@RequestMapping(value="freeboardView")
	public String view(Integer num,Model model) throws Exception{
		BoardDTO boardDTO = freeboardService.view(num);
		
		model.addAttribute("dto", boardDTO);
		model.addAttribute("board", "freeboard");
		
		return "board/boardView";
		
	}
	
}
