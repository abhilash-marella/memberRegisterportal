package com.memberServices.exceptionsHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.memberServices.exceptions.MemberException;
import com.memberServices.model.MyErrorMessages;

@ControllerAdvice
public class MemberExceptionHandler {
@ExceptionHandler(MemberException.class)
public ResponseEntity<MyErrorMessages> handleMemberExcpetion(MemberException me)
{
	return new ResponseEntity<>(
		new MyErrorMessages(me.getMessage(),me),HttpStatus.BAD_REQUEST);
	}
}
