package test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WritingAspect {
	/*	접근 지정자			 : public
	 *  리턴 type			 : void
	 *  메소드 명  			 : write로 시작하는 메소드
	 *  메소드에 전달되는 인자	 : 없다
	 * 
	 *  위와 같은 모양의 메소드가 실행되기 이전에 적용되는 Advice
	 *  execution(public void write*()) =>는 전달받는 인자가 없는 메소드에서만 실행됨
	 *  execution(public void write*(..)) => 전달받는 인자가 있든 없든 해당 메소드에서 실행됨
	 */
	@Before("execution(public void write*(..))")
	public void preparePen() {
		System.out.println("[ 글을 쓰기 위해 펜을 준비해요 ]");
	}
	/*
	 *  접근 지정자 : 상관 없음
	 *  리턴 type : 상관 없음
	 *  메소드 명 : write로 시작
	 *  메소드에 전달되는 인자 : 없다
	 *  
	 *  위와 같은 메소드가 실행된 이후에 적용되는 Advice
	 */
	@After("execution(* write*())")
	public void endPen() {
		System.out.println("[ 글을 다 작성하고 펜을 닫아요 ]");
	}
	
	@Around("execution(* write*(java.lang.String))")
	public void aroundWrite(ProceedingJoinPoint joinPoint) 
		throws Throwable{
		//메소드가 실행되기 이전 블록 | @Before 역할
		
		//aop가 적용된 메소드에 전달된 인자를 object[]로 얻어내기
		Object[] args=joinPoint.getArgs();
		
		//반복문 돌면서 하나씩 참조해서
		for(Object tmp:args) {
			//만일 우리가 찾는 type이면 (이 예제에서는 String type)
			if(tmp instanceof String) {
				//원하는 작업을 한다
				System.out.println("aop에서 미리 조사함");
			
				System.out.println("전달된 name:"+tmp);
			}
		}
		
		
		System.out.println(" [ 준비 작업을 해요 ] ");
		
		// aop가 적용된 메소드 수행 !
		joinPoint.proceed();
		
		//메소드가 실행된 이후 블록 | @After 역할
		System.out.println(" [ 마무리 작업을 해요 ] ");
	}
	@Around("execution(String write*(int))")
	public Object aroundWrite2(ProceedingJoinPoint joinPoint) 
			throws Throwable{
		Object[] args=joinPoint.getArgs();
		//전달된 인자가 1개이고 type이 정수인게 확실하기 떄문에
		int num=(int)args[0];
		System.out.println("인자로 전달된 숫자:"+num);
		//aop가 적용된 메소드를 호출하고 그 메소드가 리턴해주는 객체를
		//Object type으로 받기
		Object obj=joinPoint.proceed();
		//return type이 String이므로 casting
		String result=(String)obj;
		System.out.println("리턴된 문자열 : "+result);
		
		//원한다면 다른 정보를 리턴해줄 수도 있다
		result="에이콘";
		
		return result;
	}
}
