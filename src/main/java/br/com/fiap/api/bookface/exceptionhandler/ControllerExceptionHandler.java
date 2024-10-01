package br.com.fiap.api.bookface.exceptionhandler;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import br.com.fiap.api.bookface.exceptions.ControllerNotFoundException;
import br.com.fiap.api.bookface.exceptions.StandardError;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

	private StandardError standardError = new StandardError();
	
	public ResponseEntity<StandardError> entityNotFound(
			ControllerNotFoundException e,
			HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		standardError.setTimeStamp(Instant.now());
		standardError.setStatus(status.value());
		standardError.setError("Entity Not Found");
		standardError.setMessage(e.getMessage());
		standardError.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(this.standardError);
	}
	
}
