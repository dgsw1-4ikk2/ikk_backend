package com.example.ikk2Timmer.Repository;

import com.example.ikk2Timmer.Domain.Record;
import io.lettuce.core.GeoArgs;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RankRepository extends JpaRepository<Record,Long> {
    public List<Record> findByRegDate(LocalDate regDate, Sort sort);
}
