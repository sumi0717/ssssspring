package test.service;

import org.springframework.stereotype.Component;

//component scan을 했을 때 bean으로 만들기 위한 어노테이션
//이렇게 bean화(객체 생성)되면 object타입, writingServiceImpl 타입, writingService 타입
@Component
public class WritingServiceImpl implements WritingService{

	@Override
	public void write() {
		System.out.println("글쓰기 작업 중");
		try {
			Thread.sleep(5000); 
			//로직 수행하는데 5초 걸린다고 가정. 일부러 시간 지연시킴
		}catch(Exception e) {};
	}

	@Override
	public void writeToFriend() {
		System.out.println("친구에게 글쓰기 작업 중");
		try {
			Thread.sleep(5000); 
			//로직 수행하는데 5초 걸린다고 가정. 일부러 시간 지연시킴
		}catch(Exception e) {};
		
	}

	@Override
	public void writeToTeacher(String name) {
		System.out.println(name+"선생님에게 글쓰기 작업 중");
		try {
			Thread.sleep(5000); 
			//로직 수행하는데 5초 걸린다고 가정. 일부러 시간 지연시킴
		}catch(Exception e) {};
	}

	@Override
	public String writeAndGet(int num) {
		System.out.println("글쓰기 작성하고 문자열을 돌려줍니다");
		return "Acorn";
	}	
}
