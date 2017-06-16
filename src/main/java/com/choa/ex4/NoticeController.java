package com.choa.ex4;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.notice.NoticeDTO;
import com.choa.notice.NoticeService;


@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {

	@Inject
	private NoticeService noticeService;	
	
	@RequestMapping(value="noticeList")
	public void noticeList(Model model,@RequestParam(defaultValue="1")Integer curPage, @RequestParam(defaultValue="")String kind, @RequestParam(defaultValue="")String search) throws Exception{
		List<NoticeDTO> ar = noticeService.noticeList(curPage,kind,search);
		model.addAttribute("list", ar);
	}
	
	@RequestMapping(value="noticeWrite",method=RequestMethod.GET)
	public String noticeWrite(Model model){
		
		model.addAttribute("path", "Write");
		return "notice/noticeWrite";
			
	}
	
	@RequestMapping(value="noticeWrite",method=RequestMethod.POST)
	public String noticeWrite(NoticeDTO noticeDTO,Model model,RedirectAttributes rd) throws Exception{
		int result = noticeService.noticeWrite(noticeDTO);
		
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
		NoticeDTO noticeDTO = noticeService.noticeView(num);
		model.addAttribute("dto", noticeDTO);
		model.addAttribute("path", "Write");
		
		return "notice/noticeWrite";
	}
	
	@RequestMapping(value="noticeUpdate",method=RequestMethod.POST)
	public String noticeUpdate(NoticeDTO noticeDTO,RedirectAttributes rd) throws Exception{
		
		int result = noticeService.noticeUpdate(noticeDTO);
		
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
		int result = noticeService.noticeDelete(num);
		
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
		NoticeDTO noticeDTO = noticeService.noticeView(num);
		model.addAttribute("dto", noticeDTO);
		
	}
	
}