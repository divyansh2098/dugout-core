package com.dugout.dugoutcore.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseDto {
  Long id;
  Date createdOn;
  Date updatedOn;
}
