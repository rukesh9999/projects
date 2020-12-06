package com.crm.rest.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptonHandler {
   // add an exception Handler for customerNotFoundException
   @ExceptionHandler 
   public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException CustomerNotFoundException)
   {
	  //create customer error response
	  CustomerErrorResponse error =new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(),CustomerNotFoundException.getMessage(),System.currentTimeMillis());
	  
	    //return response entity
	   
	    return new ResponseEntity<CustomerErrorResponse>(error,HttpStatus.NOT_FOUND);
    }


      
      // add another exception Handler to catch any Exception (catch all)
      @ExceptionHandler 
      public ResponseEntity<CustomerErrorResponse> handleException(Exception CustomerNotFoundException)
      {
	    //create customer error response
	    CustomerErrorResponse error =new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(),CustomerNotFoundException.getMessage(),System.currentTimeMillis());
	  
	    //return response entity
	   
	    return new ResponseEntity<CustomerErrorResponse>(error,HttpStatus.BAD_REQUEST);
      }
	
}
