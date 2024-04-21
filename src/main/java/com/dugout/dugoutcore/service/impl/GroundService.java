package com.dugout.dugoutcore.service.impl;

import com.dugout.dugoutcore.dao.GroundDao;
import com.dugout.dugoutcore.dto.GroundDto;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GroundService {
  @NonNull GroundDao groundDao;

  public GroundDto createGround(GroundDto groundDto) {
    return groundDao.create(groundDto);
  }

  public GroundDto getGroundById(Long id) {
    return groundDao.getById(id);
  }
}
