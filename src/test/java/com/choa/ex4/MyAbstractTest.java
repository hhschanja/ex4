package com.choa.ex4;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //제이유닛 4와 함께 실행하겠다
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml","file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
//톰캣이 있다면 톰캣이 알아서 루트랑 서블렛 컨텍스트 보고 스캔을 해오는데 지금 톰캣을 실행 안하고 하잖아
//그러니까 얘가 읽을 수 있게 위치를 알려줘야해
//톰캣입장에서 서버단위로 쳐주는건 아니야.
public abstract class MyAbstractTest { //추상클래스로 만들어주는거야


}
