package com.dugout.dugoutcore.dao;

import com.dugout.dugoutcore.dto.InningDto;
import com.dugout.dugoutcore.models.Inning;
import com.dugout.dugoutcore.repository.InningsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InningDao extends BaseDao<Inning, InningDto, InningsRepository> {

    @Autowired
    InningDao(InningsRepository inningsRepository) {
        super(inningsRepository, Inning.class, InningDto.class);
    }
}
