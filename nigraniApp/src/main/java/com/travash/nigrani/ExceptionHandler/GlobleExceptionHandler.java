package com.travash.nigrani.ExceptionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import jakarta.persistence.RollbackException;

@ControllerAdvice 
public class GlobleExceptionHandler {

	
	@ExceptionHandler(AttendenceNotFoundException.class)
	public ResponseEntity<MyErrorDetails> AttendenceNotFoundExceptionHandler(AttendenceNotFoundException ex, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(CameraNotFoundException.class)
	public ResponseEntity<MyErrorDetails> CameraNotFoundExceptionHandler(CameraNotFoundException ex, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SiteDetailsNotFoundException.class)
	public ResponseEntity<MyErrorDetails> SiteDetailsNotFoundExceptionHandler(SiteDetailsNotFoundException ex, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(SiteLocationNotFoundException.class)
	public ResponseEntity<MyErrorDetails> SiteLocationNotFoundExceptionHandler(SiteLocationNotFoundException ex, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(SiteNotFoundException.class)
	public ResponseEntity<MyErrorDetails> SiteNotFoundExceptionHandler(SiteNotFoundException ex, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(StaffDepartmentNotFoundException.class)
	public ResponseEntity<MyErrorDetails> StaffDepartmentNotFoundExceptionHandler(StaffDepartmentNotFoundException ex, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(StaffNotFoundException.class)
	public ResponseEntity<MyErrorDetails> StaffNotFoundExceptionHandler(StaffNotFoundException ex, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<MyErrorDetails> UserNotFoundExceptionHandler(UserNotFoundException ex, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> myExpHandlerMain(Exception ie, WebRequest wr) {
		System.out.println("inside myHandler method...EXP");
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), ie.getMessage(), wr.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException manv,
			WebRequest wr) {
		String message = manv.getBindingResult().getFieldError().getDefaultMessage();
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), message, wr.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(RollbackException.class)
	public ResponseEntity<MyErrorDetails> handleRollbackException(Exception exp, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(),
				"Improper arguments passed in jason. Validation failed", req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> mynotFoundHandler(NoHandlerFoundException nfe, WebRequest req) {
		System.out.println("Inside No Handler Found Exception. Exception is being handled");
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);

	}
	
}
