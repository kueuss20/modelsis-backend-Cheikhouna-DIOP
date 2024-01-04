package modelsis.cheikhounadiop.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import modelsis.cheikhounadiop.exception.ProductException;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(ProductException.class)
    public ResponseEntity<String> handleUserError(ProductException ex) {
           
    	return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
	@ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleUnknowError(ProductException ex) {
           
    	return new ResponseEntity<>("Internal server error", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
