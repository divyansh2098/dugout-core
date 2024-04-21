package com.dugout.dugoutcore.dto;

import com.dugout.dugoutcore.pojo.enums.BallType;
import lombok.Data;

@Data
public class BallProcessRequestDto {
  BallType ballType;
  Long inningId;
  Integer ballNumber;
  Long bowlerId;
  Long wicketkeeperId;
  Long strikerId;
  Long nonStrikerId;
  Integer runs;
  String comment;

  WicketMetaRequestDto wicketMeta;

  Boolean isFreeHit;
}
