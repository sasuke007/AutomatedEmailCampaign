package dev.rohit.automatedemailcampaign.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AutomatedEmailCampaignException extends RuntimeException{
  private String error;
  private String message;
  private HttpStatus status;
}
