package com.example.ikk2Timmer.domain.rank.controller;

import com.example.ikk2Timmer.domain.rank.service.RankService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/rank")
public class RankController {

    private final RankService rankService;

    public RankController(RankService rankService) {
        this.rankService = rankService;
    }

    @GetMapping("/today")
    public String todayRank(Model model) {
        model.addAttribute("list",rankService.list());
        return "todayRank";
    }

    @GetMapping("/total")
    public String totalRank(Model model) {
        model.addAttribute("list",rankService.findTotalRank());
        return "totalRank";
    }
}
