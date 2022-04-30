package dev.rohit.automatedemailcampaign.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse{

  private final int status;
  private final String message;
  private String stackTrace;
  private List<ValidationError> errors;


  private record ValidationError(String field, String message){
    @Override
    public String field(){
      return field;
    }

    @Override
    public String message(){
      return message;
    }

    private ValidationError(String field, String message){
      this.field = field;
      this.message = message;
    }
  }

  public void addValidationError(String field, String message){
    if(Objects.isNull(errors)){
      errors = new ArrayList<>();
    }
    errors.add(new ValidationError(field, message));
  }
}
