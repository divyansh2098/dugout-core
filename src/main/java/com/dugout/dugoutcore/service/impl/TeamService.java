package com.dugout.dugoutcore.service.impl;

import com.dugout.dugoutcore.dao.TeamDao;
import com.dugout.dugoutcore.dto.TeamDto;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeamService {

  @NonNull TeamDao teamDao;

  public TeamDto createTeam(TeamDto teamDto) {
    return teamDao.create(teamDto);
  }
}
