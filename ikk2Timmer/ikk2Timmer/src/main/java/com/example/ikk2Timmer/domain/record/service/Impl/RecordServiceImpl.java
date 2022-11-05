package com.example.ikk2Timmer.domain.record.service.Impl;

import com.example.ikk2Timmer.domain.rank.repository.RankRepository;
import com.example.ikk2Timmer.domain.record.Entity.Record;
import com.example.ikk2Timmer.domain.record.repository.RecordRepository;
import com.example.ikk2Timmer.domain.record.service.RecordService;
import org.springframework.stereotype.Service;

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
