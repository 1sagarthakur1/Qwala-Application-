package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetail> notFoundExceptionHandler(NoHandlerFoundException nhfe, WebRequest req){
		MyErrorDetail myError= new MyErrorDetail();
		myError.setTimeStamp(LocalDateTime.now());
		myError.setMessage(nhfe.getMessage());
		myError.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(myError, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetail> allExceptionHandler(Exception e, WebRequest req){
		MyErrorDetail myError= new MyErrorDetail();
		myError.setTimeStamp(LocalDateTime.now());
		myError.setMessage(e.getMessage());
		myError.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(myError, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<MyErrorDetail> customerExceptionHandlar(EmployeeException employeeException,WebRequest webRequest){
		MyErrorDetail myError= new MyErrorDetail();
		myError.setTimeStamp(LocalDateTime.now());
		myError.setMessage(employeeException.getMessage());
		myError.setDetails(webRequest.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(myError, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DpartmentExecption.class)
	public ResponseEntity<MyErrorDetail> DpartmentExceptionHandlar(DpartmentExecption employeeException,WebRequest webRequest){
		MyErrorDetail myError= new MyErrorDetail();
		myError.setTimeStamp(LocalDateTime.now());
		myError.setMessage(employeeException.getMessage());
		myError.setDetails(webRequest.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(myError, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(WorkExecption.class)
	public ResponseEntity<MyErrorDetail> WorkExceptionHandlar(WorkExecption workExecption,WebRequest webRequest){
		MyErrorDetail myError= new MyErrorDetail();
		myError.setTimeStamp(LocalDateTime.now());
		myError.setMessage(workExecption.getMessage());
		myError.setDetails(webRequest.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(myError, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetail> myMANVExceptionHandler(MethodArgumentNotValidException me)  {
           MyErrorDetail err=new MyErrorDetail(LocalDateTime.now(),me.getBindingResult().getFieldError().getDefaultMessage(),"Validation Error");
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
			
	}
	
}
