package com.andyRadulescu.changAndRobertsNode3.controller;

import com.andyRadulescu.changAndRobertsNode3.service.PostToNextBackend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ElectionMessage {

    @Autowired
    PostToNextBackend postToNextBackend;

    @Value("${node.value}")
    private int nodeValue;

    @GetMapping(value = "/election")
    public void getMessage() {
        postToNextBackend.postToNextNode(nodeValue, "election");
    }

    @PostMapping(value = "/election")
    public int getNodeValue(@RequestBody String incomeNodeValueString) {
        System.out.println("node 3");
        int incomeNodeValue = Integer.parseInt(incomeNodeValueString);
        if (incomeNodeValue > nodeValue) {
            postToNextBackend.postToNextNode(incomeNodeValue, "election");
            System.out.println(incomeNodeValue);
        } else if (incomeNodeValue == nodeValue) {
            postToNextBackend.postToNextNode(incomeNodeValue, "leader");
            System.out.println(incomeNodeValue);
        } else {
            postToNextBackend.postToNextNode(nodeValue, "election");
            System.out.println(nodeValue);
        }
        return 1;
    }

    @PostMapping(value = "/leader")
    public int leaderMessage(@RequestBody String leaderValueString) {
        int leaderValue = Integer.parseInt(leaderValueString);
        if (leaderValue != nodeValue) {
            System.out.println("----> leader value" + leaderValue);
            postToNextBackend.postToNextNode(leaderValue, "leader");
        } else {
            System.out.println("FINISHED THE ALGORITHM WITH LEADER " + leaderValueString);
            postToNextBackend.finishTowerControl(leaderValue);
        }
        return 1;
    }
}
