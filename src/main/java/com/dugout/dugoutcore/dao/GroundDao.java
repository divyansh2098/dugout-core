package com.dugout.dugoutcore.dao;

import com.dugout.dugoutcore.dto.GroundDto;
import com.dugout.dugoutcore.models.Ground;
import com.dugout.dugoutcore.repository.GroundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroundDao extends BaseDao<Ground, GroundDto, GroundRepository> {
  @Autowired
  GroundDao(GroundRepository groundRepository) {
    super(groundRepository, Ground.class, GroundDto.class);
  }
}
