package com.choa.notice;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.choa.util.PageMaker;
import com.choa.util.PageResult;
import com.choa.util.RowMaker;

@Service //NoticeService noticeService = new NoticeService();
public class NoticeService {

	@Inject
	private NoticeDAO noticeDAO;
	
	public List<NoticeDTO> noticeList(int curPage,String kind,String search) throws Exception{
		
		int totalCount = noticeDAO.noticeCount();
		PageMaker pm = new PageMaker(curPage);
		RowMaker rowMaker = pm.getRowMaker(kind, search);
		PageResult pr = pm.getMakePage(totalCount);
		
		return noticeDAO.noticeList(rowMaker);
	}
	
	public int noticeWrite(NoticeDTO noticeDTO)throws Exception{
		return noticeDAO.noticeWrite(noticeDTO);
	}
	
	
	public int noticeUpdate(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.noticeUpdate(noticeDTO);
	}
	
	public int noticeDelete(int num) throws Exception{
		return noticeDAO.noticeDelete(num);
	}
	
	public NoticeDTO noticeView(int num) throws Exception{
		return noticeDAO.noticeView(num);
	}
	
	public int noticeCount() throws Exception{
		return noticeDAO.noticeCount();
	}

	
	
}
