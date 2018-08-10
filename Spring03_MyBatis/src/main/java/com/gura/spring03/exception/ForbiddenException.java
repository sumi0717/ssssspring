package com.gura.spring03.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 *  403 FORBIDDEN 응답을 프로그래머가 하고 싶을 때
 *  
 *  throw new ForbiddenException() 하면 된다
 */
@ResponseStatus(HttpStatus.FORBIDDEN)
public class ForbiddenException extends RuntimeException{
	
}
