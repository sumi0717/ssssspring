package com.gura.spring03.users.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring03.users.dao.UsersDao;
import com.gura.spring03.users.dto.UsersDto;

@Service
public class UsersServiceImpl implements UsersService{
	//의존객체 DI
	@Autowired
	private UsersDao dao;
	
	@Override
	public boolean canUseId(String id) {
		//인자로 전달된 아이디의 사용가능 여부를 리턴해 준다.
		return dao.canUseId(id);
	}
	
	//회원 가입 처리를 하는 서비스 메소드
	@Override
	public void signup(ModelAndView mView, UsersDto dto) {
		//비밀번호 암호화를 도와주는 객체 생성
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		//UsersDto에 있는 비밀번호를 암호화한다
		String encodedPwd=encoder.encode(dto.getPwd());
		//암호화된 비밀번호를 UsersDto에 다시 담는다
		dto.setPwd(encodedPwd);
		//Dao를 이용해서 회원 정보를 저장한다
		dao.insert(dto);
		//request에 담을 내용을 ModelAndView객체에 담는다
		mView.addObject("msg",dto.getId()+"회원님 가입되었습니다");
		
	}
	
	//로그인 관련 처리를 하는 서비스 메소드
	@Override
	public void login(ModelAndView mView, UsersDto dto, //로그인 결과가 담긴 dto, 사용자가 입력한 dto
			HttpSession session) {
		//로그인 성공여부를 담을 지역변수
		boolean isLoginSuccess=false;
		
		//인자로 전달된 Dto에 있는 회원의 아이디를 이용해서 Select 한다
		UsersDto resultDto=dao.getData(dto.getId()); //셀렉트 결과가 담긴 dto, DB에 담겨있는 dto
		//해당 아이디가 DB에 존재한다면
		if(resultDto != null) {
			//사용자가 입력한 비밀번호와 DB에 저장된 암호화된 비밀번호를 비교,
			//비교해서 일치하는 지 판단!
			isLoginSuccess=
					BCrypt.checkpw(dto.getPwd(), resultDto.getPwd());
			
		}
		
		if(isLoginSuccess==true) {
			//로그인 처리를 해준다
			session.setAttribute("id", dto.getId());
		}
		//request에 담을 내용을 ModelAndView 객체에 담는다
		mView.addObject("isLoginSuccess", isLoginSuccess);
	}

	@Override
	public void info(ModelAndView mView, HttpSession session) {
		//세션에 저장된 아이디를 읽어와서
		String id=(String)session.getAttribute("id");
		//해당 회원정보를 얻어와서
		UsersDto dto=dao.getData(id);
		//ModelAndView 객체에 담는다 (request에 담는 작업 대신)
		mView.addObject("dto",dto);
		
	}

	@Override
	public void updateForm(ModelAndView mView, HttpSession session) {
		String id=(String)session.getAttribute("id");
		UsersDto dto=dao.getData(id);
		mView.addObject("dto",dto);
		
	}

	@Override
	public void update(UsersDto dto) {
		//비밀번호를 암호화 하고 
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String encodedPwd=encoder.encode(dto.getPwd());
		dto.setPwd(encodedPwd);
		//DB에 수정 반영한다
		dao.update(dto);
		
	}
	
	//인자로 전달된 비밀번호가 맞는 비밀번호인지 여부를 리턴하는 서비스 메소드
	@Override
	public boolean isValidPwd(String inputPwd, HttpSession session) {
		//세션 영역에 저장된 아이디를 읽어와서
		String id=(String)session.getAttribute("id");
		//DB에서 해당 정보를 얻어와서
		UsersDto dto=dao.getData(id);
		//일치하는지 여부를
		boolean isValid=BCrypt.checkpw(inputPwd, dto.getPwd());
		//리턴하기
		return isValid;
	}

	@Override
	public void updatePwd(String pwd, HttpSession session) {
		//세션에 저장된 아이디
		String id=(String)session.getAttribute("id");
		//비밀번호 암호화
		String encodedPwd=new BCryptPasswordEncoder().encode(pwd);
		//UsersDto 객체에 두 개의 정보 담기
		UsersDto dto=new UsersDto();
		dto.setId(id);
		dto.setPwd(encodedPwd);
		//UsersDto 객체를 인자로 전달해서 비밀번호 수정하기
		dao.updatePwd(dto);
	}

	@Override
	public void delete(ModelAndView mView, HttpSession session) {
		//세션에 저장된 아이디를 읽어온다
		String id=(String)session.getAttribute("id");
		//DB에서 해당 정보를 삭제한다
		dao.delete(id);
		//로그아웃 처리를 한다
		session.invalidate();
		//ModelAndView 객체에 메세지를 담는다
		mView.addObject("msg",id+" 님 회원 탈퇴 되었습니다");
		
	}

	@Override
	public String profileUpdate(HttpServletRequest request, MultipartFile mFile) {
		//로그인된 아이디
		String id=(String)request.getSession().getAttribute("id");
		
		// upload 폴더의 실제 경로 
		String realPath=
				request.getServletContext().getRealPath("/upload");
		String orgFileName=mFile.getOriginalFilename();
		// 저장할 파일의 상세 경로
		String filePath=realPath+File.separator;
		
		// 파일 시스템에 저장할 파일명을 만든다.
		String saveFileName=System.currentTimeMillis()+orgFileName;
		// 업로드 폴더가 존재 하지 않으면 만든다. 
		File uploadFolder=new File(filePath);
		if(!uploadFolder.exists()) {
			uploadFolder.mkdir();
		}
		try {
			//업로드 폴더에 파일을 저장한다.
			mFile.transferTo(new File(filePath+saveFileName));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//수정할 정보를 Dto 에 담기
		UsersDto dto=new UsersDto();
		dto.setId(id);
		dto.setProfileImage(saveFileName);
		
		//Dao 를 이용해서 수정하기 
		dao.updateProfile(dto);
		
		return saveFileName;
	}

}