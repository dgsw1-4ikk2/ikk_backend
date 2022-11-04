package com.example.ikk2Timmer.Service;

import com.example.ikk2Timmer.Domain.Record;
import com.example.ikk2Timmer.ro.RecordRo;

import java.util.List;

public interface RankService {

    List<Record> list();

    List<RecordRo> findTotalRank();
}
