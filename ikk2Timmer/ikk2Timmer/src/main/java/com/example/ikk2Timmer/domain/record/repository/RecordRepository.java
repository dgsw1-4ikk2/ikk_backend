package com.example.ikk2Timmer.domain.record.repository;

import com.example.ikk2Timmer.domain.record.Entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {

}
