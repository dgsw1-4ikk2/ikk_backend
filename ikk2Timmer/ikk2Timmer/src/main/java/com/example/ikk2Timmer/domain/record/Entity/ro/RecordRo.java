package com.example.ikk2Timmer.domain.record.Entity.ro;

import com.example.ikk2Timmer.domain.record.Entity.Record;
import com.example.ikk2Timmer.domain.user.Entity.Member;
import lombok.Getter;

import java.util.Set;

@Getter
public class RecordRo {

    private final String name;
    private final int hour;
    private final int minutes;

    public RecordRo(Member member) {
        this.name = member.getUsername();
        final Set<Record> records = member.getRecords();
        this.hour = records.stream().mapToInt(Record::getH).sum();
        this.minutes = records.stream().mapToInt(Record::getM).sum();
    }
}
