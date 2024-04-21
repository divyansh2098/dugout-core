package com.dugout.dugoutcore.dao;

import com.dugout.dugoutcore.dto.WicketDto;
import com.dugout.dugoutcore.models.Wicket;
import com.dugout.dugoutcore.repository.WicketRepository;
import org.springframework.stereotype.Service;

@Service
public class WicketDao extends BaseDao<Wicket, WicketDto, WicketRepository> {
    WicketDao(WicketRepository wicketRepository) {
        super(wicketRepository, Wicket.class, WicketDto.class);
    }
}
