package com.gura.spring02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gura.spring02.dto.MemberDto;

@Controller
public class JsonController {
	
	@RequestMapping("/json/test01")
	@ResponseBody // @ResponseBody로 설정하고 String을 리턴하면
	public String json01() {
		
		//리턴되는 문자열이 클라이언트에게 그대로 출력된다
		return "hello~!";
	}
	
	@RequestMapping("/json/test02")
	@ResponseBody 
	public Map<String, Object> json02() {
		//key값은 string / value는 object. 알아서 jason 형식으로 리턴해줌
		Map<String, Object> map=new HashMap<>();
		map.put("num", 1);
		map.put("name", "김구라");
		map.put("addr", "노량진");
		map.put("isMan", true);
		return map;
	}
	
	@RequestMapping("/json/test03")
	@ResponseBody 
	// Server는 Client에게 response하고, Client to Server : reqeust함
	// 두 부분으로 Response 함, header와 body. 
	// header는 응답할 정보 -> jsp 페이지 : view 페이지, 응답이 출력됨
	// Body는 직접 응답이 출력되는 부분. 리턴해주는 data를 Body에 직접 출력하는 방법.
	// 메소드 안에 작성한 내용을 view페이지를 거치지 않고 직접 응답하게 됨
	public List<String> json03(){
		
		List<String> list=new ArrayList<>();
		list.add("어쩌구");
		list.add("저쩌구");
		list.add("냠냠");
		list.add("쩝쩝");
		
		return list;
	}
	
	@RequestMapping("/json/test04")
	@ResponseBody
	public List<Map<String, Object>> json04(){
		List<Map<String, Object>> list=new ArrayList<>();
		Map<String, Object> map=new HashMap<>();
		map.put("num", 2);
		map.put("name", "만두만두");
		map.put("addr", "냠냠냠");
		map.put("isMan", false);
		
		Map<String, Object> map2=new HashMap<>();
		map2.put("num", 3);
		map2.put("name", "2만두만두2");
		map2.put("addr", "2냠냠냠2");
		map2.put("isMan", false);
		
		list.add(map);
		list.add(map2);
		
		return list;
		// {"xxx":[{},{},{}]}
	}
	
	@RequestMapping("/json/test05")
	@ResponseBody
	public MemberDto json05() {
		MemberDto dto=new MemberDto();
		dto.setNum(1);
		dto.setName("만두");
		dto.setAddr("뇸뇸뇸");
		//MemberDto dto=new MemberDto(1,"만두","뇸뇸뇸");
		
		return dto;
	}
	
	@RequestMapping("/json/test06")
	@ResponseBody
	public List<MemberDto> json06(){
		List<MemberDto> list=new ArrayList<>();
		MemberDto dto=new MemberDto(1,"만두","냠냠");
		MemberDto dto2=new MemberDto(2,"2만두2","냠냠");
		MemberDto dto3=new MemberDto(3,"3만두3","냠냠");
		
		list.add(dto);
		list.add(dto2);
		list.add(dto3);
		
		return list;
		
	}
}
