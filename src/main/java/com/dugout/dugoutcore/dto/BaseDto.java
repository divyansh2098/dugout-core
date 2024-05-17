package com.dugout.dugoutcore.dto;

import java.util.Date;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseDto {
  Long id;
  Date createdOn;
  Date updatedOn;
}
