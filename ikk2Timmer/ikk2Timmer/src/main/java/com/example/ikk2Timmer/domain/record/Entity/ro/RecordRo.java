package com.example.ikk2Timmer.domain.record.Entity.ro;

import com.example.ikk2Timmer.domain.record.Entity.Record;
import com.example.ikk2Timmer.domain.user.Entity.User;
import lombok.Getter;

import java.util.Set;

@Getter
public class RecordRo {

    private final String name;
    private final int hour;
    private final int minutes;

    public RecordRo(User user) {
        this.name = user.getName();
        final Set<Record> records = user.getRecords();
        this.hour = records.stream().mapToInt(Record::getH).sum();
        this.minutes = records.stream().mapToInt(Record::getM).sum();
    }
}
