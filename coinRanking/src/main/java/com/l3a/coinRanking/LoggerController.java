package com.l3a.coinRanking;

import com.l3a.coinRanking.kafka.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoggerController {
    private Logger logger = LoggerFactory.getLogger(RankController.class);

    @Autowired
    private Consumer consumer;

    @GetMapping("/logs")
    public String logging(Model model) {
        List<String> topics = new ArrayList<>();
        topics.add("logs");

        logger.info("LoggerController - Consuming messages");

        model.addAttribute("logCol", consumer.getConsumedMessages());

        return "logs";
    }


}
