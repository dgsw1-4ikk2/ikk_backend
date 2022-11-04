package com.example.ikk2Timmer.Service.Impl;

import com.example.ikk2Timmer.Domain.Record;
import com.example.ikk2Timmer.Repository.RankRepository;
import com.example.ikk2Timmer.Repository.UserRepository;
import com.example.ikk2Timmer.Service.RankService;
import com.example.ikk2Timmer.ro.RecordRo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RankServiceImpl implements RankService {

    @Autowired
    private RankRepository rankRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Record> list() {
        LocalDate reg = LocalDate.now();
        return rankRepository.findByRegDate(reg, Sort.by(Sort.Direction.DESC,"h","m"));
    }

    @Override
    public List<RecordRo> findTotalRank() {
        // 따라하지 말 것

        return userRepository.findAll().stream().map(RecordRo::new)
                .collect(Collectors.toList());
    }
}
