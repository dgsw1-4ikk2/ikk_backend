package com.example.ikk2Timmer.domain.record.service.Impl;

import com.example.ikk2Timmer.domain.rank.repository.RankRepository;
import com.example.ikk2Timmer.domain.record.Entity.Record;
import com.example.ikk2Timmer.domain.record.repository.RecordRepository;
import com.example.ikk2Timmer.domain.record.service.RecordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RecordServiceImpl implements RecordService {

    private RecordRepository recordRepository;


    @Override
    public void record(Record record) {
        recordRepository.save(record);
    }
}
