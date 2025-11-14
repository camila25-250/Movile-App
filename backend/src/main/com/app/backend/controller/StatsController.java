package com.app.backend.controller;

import com.app.backend.Service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequesMapping;
import ore.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequesMapping("/api/stats")

public class StatsController{

    @Autowired
    private StatsService StatsService;

    @GetMapping("")
    public Map<String, Long> getStats(){
        return statsService.getStats();
    }
}