package test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.service.WritingService;

public class MainClass3 {
	public static void main(String[] args) {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("test/main/init.xml");
		
		// spring bean container로부터  
		//WritingService type 객체의 참조값 얻어내기
		WritingService service=context.getBean(WritingService.class);
		String result=service.writeAndGet(999); 
		//writeAndGet은 인자로 전달하는 타입은 int, return되는 타입은 String. 
		//before 블록에서는 int 인자 설정
		//after에서는 리턴 인자 설정. =>비포와 애프터의 기준은 메소드 호출 시점.
		
		System.out.println("main 메소드 result:"+result);
	}
}
