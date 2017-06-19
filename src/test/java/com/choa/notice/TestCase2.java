package com.choa.notice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.ex4.MyAbstractTest;

public class TestCase2 extends MyAbstractTest{
	
	@Autowired
	private NoticeServiceImpl noticeServiceImpl;
	
	@Test
	public void test() throws Exception{
		
		int result = noticeServiceImpl.delete(213);
		assertEquals(1, result);
	}

}
