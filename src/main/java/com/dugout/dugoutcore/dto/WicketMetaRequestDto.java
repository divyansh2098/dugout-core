package com.dugout.dugoutcore.dto;

import com.dugout.dugoutcore.pojo.enums.WicketType;
import lombok.Data;

@Data
public class WicketMetaRequestDto {
  Long outPlayerId;
  WicketType wicketType;
  Long fielderId;
}
