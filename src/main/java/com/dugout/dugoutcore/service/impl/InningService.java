package com.dugout.dugoutcore.service.impl;

import com.dugout.dugoutcore.dao.InningDao;
import com.dugout.dugoutcore.dto.InningsDto;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InningService {

    @NonNull InningDao inningDao;

    public InningsDto getInningById(Long id) {
        //TODO complete this
        return null;
    }

}