package com.dugout.dugoutcore.pojo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DugoutError {
  String message;
  String debug;
}
