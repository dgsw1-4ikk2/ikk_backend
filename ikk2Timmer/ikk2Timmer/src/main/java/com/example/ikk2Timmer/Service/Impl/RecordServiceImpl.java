package com.example.ikk2Timmer.Service.Impl;

import com.example.ikk2Timmer.Domain.Record;
import com.example.ikk2Timmer.Repository.RankRepository;
import com.example.ikk2Timmer.Repository.RecordRepository;
import com.example.ikk2Timmer.Service.RecordService;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class RecordServiceImpl implements RecordService {

    private RecordRepository recordRepository;


    public final RankRepository rankRepository;

    public RecordServiceImpl(RecordRepository recordRepository, RankRepository rankRepository) {
        this.recordRepository = recordRepository;
        this.rankRepository = rankRepository;
    }


    @Override
    public void record(Record record) {
        recordRepository.save(record);
    }
}
