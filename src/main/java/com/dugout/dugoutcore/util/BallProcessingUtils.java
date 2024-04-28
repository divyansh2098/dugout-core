package com.dugout.dugoutcore.util;

import org.springframework.stereotype.Service;

@Service
public class BallProcessingUtils {
  public Boolean getIsOverComplete(Integer ballNumber) {
    return (ballNumber + 1) % 6 == 0;
  }
}
