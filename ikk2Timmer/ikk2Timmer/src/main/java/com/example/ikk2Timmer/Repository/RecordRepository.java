package com.example.ikk2Timmer.Repository;

import com.example.ikk2Timmer.Domain.Record;
import com.example.ikk2Timmer.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecordRepository extends JpaRepository<Record, Long> {
//    Optional<Record> findByUsername(String name);
}
