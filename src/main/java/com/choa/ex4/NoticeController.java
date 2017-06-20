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
import com.choa.util.ListInfo;


@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {

	@Inject
	private NoticeServiceImpl noticeService;
	
	@RequestMapping(value="noticeList")
	public String noticeList(Model model,ListInfo listInfo) throws Exception{ // 파라미터로 넘어오는 값을 listInfo가 가지고 있으면 알아서 들어가 null값이어도 spring이 알아서 걸러서 jsp에 null이라고 안나와
		
		List<BoardDTO> ar = noticeService.list(listInfo);
		model.addAttribute("list", ar).addAttribute("board","notice").addAttribute("listInfo", listInfo); //컨트롤러의 listInfo랑 서비스의 listInfo랑 주소값이 같은 객체이니까 요거 하나 날리면되지
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
	public String noiceView(Model model, Integer num) throws Exception{
		BoardDTO boardDTO = noticeService.view(num);
		model.addAttribute("dto",boardDTO);
		model.addAttribute("board","notice");
		
		return "board/boardView";
	}
	
}