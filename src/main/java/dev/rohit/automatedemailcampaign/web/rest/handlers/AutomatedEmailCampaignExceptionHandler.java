package dev.rohit.automatedemailcampaign.web.rest.handlers;

import dev.rohit.automatedemailcampaign.dto.ErrorResponse;
import dev.rohit.automatedemailcampaign.exceptions.AutomatedEmailCampaignException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Log4j2
@ControllerAdvice
public class AutomatedEmailCampaignExceptionHandler extends ResponseEntityExceptionHandler{

  @ExceptionHandler(AutomatedEmailCampaignException.class)
  public ResponseEntity<ErrorResponse> handleNotFoundException(AutomatedEmailCampaignException ex, HttpStatus status,
      WebRequest request){
    return null;
  }

}
