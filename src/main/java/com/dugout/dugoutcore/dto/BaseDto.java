package com.dugout.dugoutcore.dto;

import java.util.Date;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseDto {
  Long id;
  Date createdOn;
  Date updatedOn;
}
