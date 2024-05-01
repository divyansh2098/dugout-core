package com.dugout.dugoutcore.dao;

import com.dugout.dugoutcore.dto.BatsmanViewDto;
import com.dugout.dugoutcore.models.BatsmanView;
import com.dugout.dugoutcore.repository.BatsmanViewRepository;
import org.springframework.stereotype.Service;

@Service
public class BatsmanViewDao extends BaseDao<BatsmanView, BatsmanViewDto, BatsmanViewRepository> {

    BatsmanViewDao(BatsmanViewRepository batsmanViewRepository) {
        super(batsmanViewRepository, BatsmanView.class, BatsmanViewDto.class);
    }

    public BatsmanView getPlayerBatsmanViewForInningAndPlayer(Long inningId, Long playerId) {
        return repository.findBatsmanViewByInningIdAndPlayerId(inningId, playerId);
    }
}
