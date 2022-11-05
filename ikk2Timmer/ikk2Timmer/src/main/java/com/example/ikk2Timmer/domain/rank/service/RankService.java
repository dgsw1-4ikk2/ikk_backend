package com.example.ikk2Timmer.domain.rank.service;

import com.example.ikk2Timmer.domain.record.Entity.Record;
import com.example.ikk2Timmer.domain.record.Entity.ro.RecordRo;

import java.util.List;

public interface RankService {

    List<Record> list();

    List<RecordRo> findTotalRank();
}
