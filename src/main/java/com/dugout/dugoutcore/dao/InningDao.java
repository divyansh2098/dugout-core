package com.dugout.dugoutcore.dao;

import com.dugout.dugoutcore.dto.InningsDto;
import com.dugout.dugoutcore.models.Innings;
import com.dugout.dugoutcore.repository.InningsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InningDao extends BaseDao<Innings, InningsDto, InningsRepository> {

    @Autowired
    InningDao(InningsRepository inningsRepository) {
        super(inningsRepository, Innings.class, InningsDto.class);
    }
}
