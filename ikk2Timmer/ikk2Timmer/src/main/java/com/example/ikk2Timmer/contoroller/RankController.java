package com.example.ikk2Timmer.contoroller;

import com.example.ikk2Timmer.Service.RankService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;

import java.util.Collection;
import java.util.List;

@Controller
public class RankController {

    private final RankService rankService;

    public RankController(RankService rankService) {
        this.rankService = rankService;
    }

    @GetMapping("/today-rank")
    public String todayRank(Model model) {
        model.addAttribute("list",rankService.list());
        System.out.println(rankService.list());
        return "todayRank";
    }

    @GetMapping("/total-rank")
    public String totalRank(Model model) {
        return "";
    }
}
