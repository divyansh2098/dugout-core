package com.dugout.dugoutcore.dao;

import com.dugout.dugoutcore.dto.MatchDto;
import com.dugout.dugoutcore.models.Match;
import com.dugout.dugoutcore.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchDao extends BaseDao<Match, MatchDto, MatchRepository> {

  @Autowired
  MatchDao(MatchRepository matchRepository) {
    super(matchRepository, Match::new, MatchDto::new);
  }
}
