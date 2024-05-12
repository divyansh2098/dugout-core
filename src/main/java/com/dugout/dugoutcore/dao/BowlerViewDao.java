package com.dugout.dugoutcore.dao;

import com.dugout.dugoutcore.dto.BowlerViewDto;
import com.dugout.dugoutcore.models.BowlerView;
import com.dugout.dugoutcore.repository.BowlerViewRepository;
import org.springframework.stereotype.Service;

@Service
public class BowlerViewDao extends BaseDao<BowlerView, BowlerViewDto, BowlerViewRepository> {

    BowlerViewDao(BowlerViewRepository bowlerViewRepository) {
        super(bowlerViewRepository, BowlerView.class, BowlerViewDto.class);
    }

    public BowlerViewDto getPlayerBowlerViewFromInningAndPlayer(Long inningId, Long playerId) {
        return convertToDto(repository.findBowlerViewByInningIdAndPlayerId(inningId, playerId));
    }
}
