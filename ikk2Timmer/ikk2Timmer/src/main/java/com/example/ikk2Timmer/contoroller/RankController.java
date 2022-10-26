package com.example.ikk2Timmer.contoroller;

import com.example.ikk2Timmer.Service.RankService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RankController {

    private final RankService rankService;

    public RankController(RankService rankService) {
        this.rankService = rankService;
    }

    @GetMapping("/today-rank")
    public String todayRank(Model model) {
        model.addAttribute("list",rankService.list());
        return "todayRank";
    }

}
