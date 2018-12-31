package com.andyRadulescu.changAndRobertsTowerControl.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FinishController {

    @PostMapping("/finishTowerControl")
    public String showLeader(@RequestBody String value) {
        System.out.println(value);
        return value;
    }
}
