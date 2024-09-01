package com.dugout.dugoutcore.util;

import com.dugout.dugoutcore.dto.BowlerViewDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BowlerViewUtils {

  public BowlerViewDto getPlayerBowlerViewDtoFromAllBowlerViewDtos(List<BowlerViewDto> bowlerViewDtoList, Long playerId) {
    return bowlerViewDtoList.stream().filter(dto -> dto.getPlayer().getId().equals(playerId)).findFirst().orElse(null);
  }

  public void replaceBowlerViewDtoInBowlerViewDtoList(List<BowlerViewDto> bowlerViewDtoList, BowlerViewDto bowlerViewDto) {
    bowlerViewDtoList.replaceAll(dto -> dto.getPlayer().getId().equals(bowlerViewDto.getPlayer().getId()) ? bowlerViewDto : dto);
  }
  public void decreaseBowlerRuns(BowlerViewDto bowlerViewDto, Integer runs) {
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() - runs);
  }

  public void reduceBalls(BowlerViewDto bowlerViewDto) {
    bowlerViewDto.setNumBalls(bowlerViewDto.getNumBalls() - 1);
  }
}
