package com.gura.spring03.exception;
/*
 *  예외를 처리하는 컨트롤러
 *  
 *  1. @ControllerAdvice 어노테이션을 붙이고
 *  2. component scan을 해서 bean으로 만들고
 *  3. @ExceptionHandler(예외 type)을 메소드에 붙여준다
 */

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {
	
	// ForbiddenException type 오류가 발생했을 때 실행되는 메소드
	@ExceptionHandler(ForbiddenException.class)
	public ModelAndView error403(ForbiddenException fe) {
		ModelAndView mView=new ModelAndView();
		
		mView.setViewName("error/403");
		return mView;
	}
	
	/*
	 *  @Repository 어노테이션이 붙어있는 Dao에서, 
	 *  DB관련 Exception이 발생하면 
	 *  스프링이 DataAccessException으로 바꿔서 발생시킨다
	 */
	@ExceptionHandler(DataAccessException.class)
	public ModelAndView errorDataAccess(DataAccessException dae) {
		ModelAndView mView=new ModelAndView();
		//예외 정보(문자열)을 request에 담기
		mView.addObject("msg", dae.getMessage());
		
		mView.setViewName("error/data_access");
		return mView;
	}
}
