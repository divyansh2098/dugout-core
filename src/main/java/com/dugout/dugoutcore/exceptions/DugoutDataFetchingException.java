package com.dugout.dugoutcore.exceptions;

import com.dugout.dugoutcore.pojo.DugoutError;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class DugoutDataFetchingException extends Exception {
  DugoutError error;

  HttpStatus status;

  public DugoutDataFetchingException(DugoutError errors, HttpStatus status) {
    this.error = errors;
    this.status = status;
  }
}
