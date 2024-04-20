package com.dugout.dugoutcore.dto;

import com.dugout.dugoutcore.pojo.enums.BallType;
import lombok.Data;

@Data
public class BallRequestDto {
  BallType ballType;
  WicketMetaRequestDto wicketMeta;
  Long strikerId;
  Long nonStriker;
  Long wicketKeeperId;
  Integer runs;
  Integer ballNumber;
  String comment;
}
