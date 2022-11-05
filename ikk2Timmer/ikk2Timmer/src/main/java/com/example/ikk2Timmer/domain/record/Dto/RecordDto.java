package com.example.ikk2Timmer.domain.record.Dto;

import com.example.ikk2Timmer.domain.record.Entity.Record;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RecordDto {
    private Integer h;
    private Integer m;

    public Record toEntity() {
        return Record.builder()
                .h(h)
                .m(m)
                .build();
    }

    @Builder
    public RecordDto(Integer h, Integer m) {
        this.h = h;
        this.m = m;
    }
}
