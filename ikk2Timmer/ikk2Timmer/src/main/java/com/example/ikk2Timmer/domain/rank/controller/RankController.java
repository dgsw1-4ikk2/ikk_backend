package com.example.ikk2Timmer.domain.rank.controller;

import com.example.ikk2Timmer.domain.rank.service.RankService;
import com.example.ikk2Timmer.domain.record.Entity.Record;
import com.example.ikk2Timmer.domain.record.Entity.ro.RecordRo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/rank")
public class RankController {

    private final RankService rankService;

    public RankController(RankService rankService) {
        this.rankService = rankService;
    }

    @PostMapping("/today")
    public List<Record> todayRank() {
        return rankService.list();
    }

    @PostMapping("/total")
    public List<RecordRo> totalRank() {
        return rankService.findTotalRank();
    }
}
