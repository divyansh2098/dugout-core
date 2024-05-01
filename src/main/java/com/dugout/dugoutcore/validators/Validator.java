package com.dugout.dugoutcore.validators;

import com.dugout.dugoutcore.pojo.DugoutError;

import java.util.List;

public interface Validator<T> {
  List<DugoutError> validate(T dto);
}
