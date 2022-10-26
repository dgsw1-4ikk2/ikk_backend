package com.example.ikk2Timmer.Repository;

import com.example.ikk2Timmer.Domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface RankRepository extends JpaRepository<Record,Long> {
    public Record findByRegDate(LocalDate regDate);
}
