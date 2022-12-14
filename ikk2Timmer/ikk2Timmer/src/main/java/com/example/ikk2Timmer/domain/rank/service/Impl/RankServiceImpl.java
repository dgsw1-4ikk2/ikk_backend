package com.example.ikk2Timmer.domain.rank.service.Impl;

import com.example.ikk2Timmer.domain.rank.repository.RankRepository;
import com.example.ikk2Timmer.domain.rank.service.RankService;
import com.example.ikk2Timmer.domain.record.Entity.Record;
import com.example.ikk2Timmer.domain.user.repository.MemberRepository;
import com.example.ikk2Timmer.domain.record.Entity.ro.RecordRo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RankServiceImpl implements RankService {

    private RankRepository rankRepository;

    private MemberRepository memberRepository;

    @Override
    public List<Record> list() {
        LocalDate reg = LocalDate.now();
        return rankRepository.findByRegDate(reg, Sort.by(Sort.Direction.DESC,"h","m"));
    }

    @Override
    public List<RecordRo> findTotalRank() {
        // 따라하지 말 것

        return memberRepository.findAll().stream().map(RecordRo::new)
                .collect(Collectors.toList());
    }
}
