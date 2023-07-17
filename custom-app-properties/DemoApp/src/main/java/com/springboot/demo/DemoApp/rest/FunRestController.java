package com.springboot.demo.DemoApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

//    expose '/' that returns 'hello world'
    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }

//    inject custom application properties
    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;

//  expose new endpoint for teaminfo
    @GetMapping("team-info")
    public String getTeamInfo(){
        return "Coach: " + coachName + ", Team: " + teamName;
    }

}
