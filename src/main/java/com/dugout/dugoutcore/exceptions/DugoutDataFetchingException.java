package com.dugout.dugoutcore.exceptions;

import com.dugout.dugoutcore.pojo.DugoutError;
import lombok.Data;

@Data
public class DugoutDataFetchingException extends Exception {
  DugoutError errors;

  public DugoutDataFetchingException(DugoutError errors) {
    this.errors = errors;
  }
}
