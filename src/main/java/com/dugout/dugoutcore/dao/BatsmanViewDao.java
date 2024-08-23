package com.dugout.dugoutcore.dao;

import com.dugout.dugoutcore.dto.BatsmanViewDto;
import com.dugout.dugoutcore.models.BatsmanView;
import com.dugout.dugoutcore.repository.BatsmanViewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BatsmanViewDao extends BaseDao<BatsmanView, BatsmanViewDto, BatsmanViewRepository> {

    BatsmanViewDao(BatsmanViewRepository batsmanViewRepository) {
        super(batsmanViewRepository, BatsmanView.class, BatsmanViewDto.class);
    }

    public BatsmanViewDto getPlayerBatsmanViewForInningAndPlayer(Long inningId, Long playerId) {
        return convertToDto(repository.findBatsmanViewByInningIdAndPlayerId(inningId, playerId));
    }

    public List<BatsmanViewDto> getAllBatsmanViewForInning(Long inningId) {
        return repository.findBatsmanViewsByInningId(inningId).stream().map(this::convertToDto).collect(Collectors.toList());
    }
}
