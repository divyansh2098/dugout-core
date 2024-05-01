package com.dugout.dugoutcore.validators.impl;

import com.dugout.dugoutcore.dto.UserDTO;
import com.dugout.dugoutcore.pojo.DugoutError;
import com.dugout.dugoutcore.validators.Validator;
import java.util.List;

public class UserValidatorImpl implements Validator<UserDTO> {
  @Override
  public List<DugoutError> validate(UserDTO dto) {
    return null;
  }
}
