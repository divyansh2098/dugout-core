package com.dugout.dugoutcore.config;

import com.dugout.dugoutcore.dto.BallDto;
import com.dugout.dugoutcore.models.Ball;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper
        .typeMap(Ball.class, BallDto.class)
        .addMapping(Ball::getWicketKeeper, BallDto::setWicketKeeper);
    return modelMapper;
  }
}
