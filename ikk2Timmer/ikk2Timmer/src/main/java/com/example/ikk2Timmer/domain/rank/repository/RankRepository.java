package com.example.ikk2Timmer.domain.rank.repository;

import com.example.ikk2Timmer.domain.record.Entity.Record;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RankRepository extends JpaRepository<Record,Long> {
    public List<Record> findByRegDate(LocalDate regDate, Sort sort);

}
