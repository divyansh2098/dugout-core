package com.dugout.dugoutcore.service.impl;

import com.dugout.dugoutcore.dao.WicketDao;
import com.dugout.dugoutcore.dto.WicketDto;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WicketService {

    @NonNull WicketDao wicketDao;
    public WicketDto create(WicketDto wicketDto) {
        return wicketDao.create(wicketDto);
    }
}
