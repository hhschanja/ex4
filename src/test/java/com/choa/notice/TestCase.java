package com.choa.notice;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.choa.ex4.MyAbstractTest;

public class TestCase extends MyAbstractTest{

	@Inject
	private SqlSession sqlSession;
	
	@Test
	public void connectionTest(){
		assertNotNull(sqlSession);
	}

	
	
}
