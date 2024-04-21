package com.dugout.dugoutcore.dao;

import com.dugout.dugoutcore.dto.BallDto;
import com.dugout.dugoutcore.models.Ball;
import com.dugout.dugoutcore.repository.BallRepository;
import org.springframework.stereotype.Service;

@Service
public class BallDao extends BaseDao<Ball, BallDto, BallRepository> {

  BallDao(BallRepository ballRepository) {
    super(ballRepository, Ball.class, BallDto.class);
  }
}
