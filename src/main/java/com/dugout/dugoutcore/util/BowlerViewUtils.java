package com.dugout.dugoutcore.util;

import com.dugout.dugoutcore.dto.BowlerViewDto;
import org.springframework.stereotype.Service;

@Service
public class BowlerViewUtils {
  public void decreaseBowlerRuns(BowlerViewDto bowlerViewDto, Integer runs) {
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() - runs);
  }

  public void reduceBalls(BowlerViewDto bowlerViewDto) {
    bowlerViewDto.setNumBalls(bowlerViewDto.getNumBalls() - 1);
  }
}
