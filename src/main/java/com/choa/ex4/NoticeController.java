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
		return "notice/noticeWrite";
			
	}
	
	@RequestMapping(value="noticeWrite",method=RequestMethod.POST)
	public String noticeWrite(BoardDTO boardDTO,Model model,RedirectAttributes rd) throws Exception{
		int result = noticeService.write(boardDTO);
		
		String message = "FAIL";
		if(result>0){
			message="SUCCESS";
		}else{

		}
		
		//SPRING은 리다이렉트에서도 값을 내보낼 수 있어
		//flash는 주소창에 남지를 않아, 그냥 add는 주소창에 남아
		
		rd.addFlashAttribute("message", message);
		
		return "redirect:/notice/noticeList";
		
	}
	
	@RequestMapping(value="noticeUpdate",method=RequestMethod.GET)
	public String noticeUpdate(Model model,int num) throws Exception{
		BoardDTO boardDTO = noticeService.view(num);
		model.addAttribute("dto", boardDTO);
		model.addAttribute("path", "Write");
		
		return "notice/noticeWrite";
	}
	
	@RequestMapping(value="noticeUpdate",method=RequestMethod.POST)
	public String noticeUpdate(BoardDTO boardDTO,RedirectAttributes rd) throws Exception{
		
		int result = noticeService.update(boardDTO);
		
		String message = "FAIL";
		
		if(result>0){
			message = "SUCCESS";
		}else{
			
		}
		
		rd.addFlashAttribute("message",message);
		
		return "redirect:/notice/noticeList"; 
	}
	
	@RequestMapping(value="noticeDelete")
	public String noticeDelete(Integer num,RedirectAttributes rd) throws Exception{
		int result = noticeService.delete(num);
		
		String message = "FAIL";
		if(result>0){
			message = "SUCCESS";
		}else{
			
		}
		
		rd.addFlashAttribute("message", message);
		
		return "redirect:./noticeList";
	}
	
	@RequestMapping(value="noticeView")
	public void noiceView(Model model, Integer num) throws Exception{
		BoardDTO boardDTO = noticeService.view(num);
		model.addAttribute("dto",boardDTO);
		
	}
	
}