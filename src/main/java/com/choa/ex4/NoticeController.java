package com.choa.ex4;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.board.BoardDTO;
import com.choa.notice.NoticeDTO;
import com.choa.notice.NoticeServiceImpl;


@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {

	@Inject
	private NoticeServiceImpl noticeService;	
	
	@RequestMapping(value="noticeList")
	public String noticeList(Model model,@RequestParam(defaultValue="1")Integer curPage) throws Exception{
		List<BoardDTO> ar = noticeService.list(curPage);
		model.addAttribute("list", ar);
		model.addAttribute("board","notice");
		//경로도 바꿔줘야지 board로 
		return "board/boardList";
	}
	
	@RequestMapping(value="noticeWrite",method=RequestMethod.GET)
	public String noticeWrite(Model model) throws Exception{
		
		model.addAttribute("path", "Write");
		model.addAttribute("board", "notice");
		return "board/boardWrite";
			
	}
	
	@RequestMapping(value="noticeWrite",method=RequestMethod.POST)
	public String noticeWrite(BoardDTO boardDTO,Model model) throws Exception{
		int result = noticeService.write(boardDTO);
		
		if(result>0){
			model.addAttribute("message", "SUCCESS");
		}else{
			model.addAttribute("message", "FAIL");
		}
		
		model.addAttribute("path", "noticeList");
		
		
		return "common/result";
		
	}
	
	@RequestMapping(value="noticeUpdate",method=RequestMethod.GET)
	public String noticeUpdate(Model model,int num) throws Exception{
		BoardDTO boardDTO = noticeService.view(num);
		model.addAttribute("dto", boardDTO);
		model.addAttribute("path", "Update");
		model.addAttribute("board", "notice");
			
		return "board/boardWrite";
	}
	
	@RequestMapping(value="noticeUpdate",method=RequestMethod.POST)
	public String noticeUpdate(BoardDTO boardDTO,Model model) throws Exception{
		
		int result = noticeService.update(boardDTO);

		String message = "FAIL";
		
		if(result>0){
			message = "SUCCESS";
		}
		
		model.addAttribute("path", "noticeList");
		model.addAttribute("message", message);
		
		return "common/result";
	}
	
	@RequestMapping(value="noticeDelete")
	public String noticeDelete(Integer num,Model model) throws Exception{
		int result = noticeService.delete(num);
		
		String message = "FAIL";
		if(result>0){
			message = "SUCCESS";
		}else{
			
		}
		
		model.addAttribute("message", message);
		model.addAttribute("path", "noticeList");
		
		return "common/result";
	}
	
	@RequestMapping(value="noticeView")
	public void noiceView(Model model, Integer num) throws Exception{
		BoardDTO boardDTO = noticeService.view(num);
		model.addAttribute("dto",boardDTO);
		
	}
	
}