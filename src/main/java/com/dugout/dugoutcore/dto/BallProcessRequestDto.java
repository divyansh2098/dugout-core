package com.dugout.dugoutcore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BallProcessRequestDto extends BallProcessRequest {
  Long inningId;
  Integer ballNumber;
  Long bowlerId;
  Long wicketKeeperId;
  Long strikerId;
  Long nonStrikerId;
  Integer runs;
  String comment;

  WicketMetaRequestDto wicketMeta;

  Boolean isFreeHit;
}
