package com.example.ikk2Timmer.Service.Impl;

import com.example.ikk2Timmer.Domain.Record;
import com.example.ikk2Timmer.Repository.RankRepository;
import com.example.ikk2Timmer.Service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RankServiceImpl implements RankService {

    @Autowired
    private RankRepository rankRepository;

    @Override
    public List<Record> list() {
        LocalDate reg = LocalDate.now();
        return rankRepository.findByRegDate(reg, Sort.by(Sort.Direction.DESC,"h","m"));
    }
}
