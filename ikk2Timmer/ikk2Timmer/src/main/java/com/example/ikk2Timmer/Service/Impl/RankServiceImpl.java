package com.example.ikk2Timmer.Service.Impl;

import com.example.ikk2Timmer.Domain.Record;
import com.example.ikk2Timmer.Repository.RankRepository;
import com.example.ikk2Timmer.Service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RankServiceImpl implements RankService {

    @Autowired
    private RankRepository rankRepository;

    @Override
    public Record list() {
        LocalDate reg = LocalDate.now();
        return rankRepository.findByRegDate(reg);
    }
}
