package com.dugout.dugoutcore.util;

import com.dugout.dugoutcore.dto.BatsmanViewDto;
import com.dugout.dugoutcore.dto.WicketDto;
import com.dugout.dugoutcore.pojo.enums.BatsmanViewBatsmanStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

import static com.dugout.dugoutcore.ApplicationConstants.FOUR_RUNS;
import static com.dugout.dugoutcore.ApplicationConstants.SIX_RUNS;

@Service
public class BatsmanViewUtils {
  public void incrementBallsFaced(BatsmanViewDto batsmanViewDto) {
    batsmanViewDto.setNumBalls(batsmanViewDto.getNumBalls() + 1);
  }

  public void decrementBallsFaced(BatsmanViewDto batsmanViewDto) {
    batsmanViewDto.setNumBalls(batsmanViewDto.getNumBalls() - 1);
  }

  public void increaseBatsmanRuns(BatsmanViewDto batsmanViewDto, Integer runs) {
    if (Objects.equals(runs, FOUR_RUNS)) {
      batsmanViewDto.setFours(batsmanViewDto.getFours() + 1);
    } else if (Objects.equals(runs, SIX_RUNS)) {
      batsmanViewDto.setSixes(batsmanViewDto.getSixes() + 1);
    }
    batsmanViewDto.setRuns(batsmanViewDto.getRuns() + runs);
  }

  public void decreaseBatsmanRuns(BatsmanViewDto batsmanViewDto, Integer runs) {
    if (Objects.equals(runs, FOUR_RUNS)) {
      batsmanViewDto.setFours(batsmanViewDto.getFours() - 1);
    } else if (Objects.equals(runs, SIX_RUNS)) {
      batsmanViewDto.setSixes(batsmanViewDto.getSixes() - 1);
    }
    batsmanViewDto.setRuns(batsmanViewDto.getRuns() - runs);
  }

  public void markBatsmanOut(BatsmanViewDto batsmanViewDto, WicketDto wicketDto) {
    batsmanViewDto.setEndTime(new Date());
    batsmanViewDto.setWicket(wicketDto);
    batsmanViewDto.setStatus(BatsmanViewBatsmanStatus.OUT);
  }

  public void markBatsmanAsNotOut(BatsmanViewDto batsmanViewDto) {
    batsmanViewDto.setWicket(null);
    batsmanViewDto.setEndTime(null);
    batsmanViewDto.setStatus(BatsmanViewBatsmanStatus.PLAYING);
  }
}
