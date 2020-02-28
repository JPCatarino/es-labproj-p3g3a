package com.l3a.coinRanking;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulingTasks {
    private static final Logger log = LoggerFactory.getLogger(SchedulingTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    // CoinRanking only updates once a day, as far as i'm aware.
    @Scheduled(fixedRate = 86400)
    public void reportCurrentTime() {
        log.info("New day, new update {}", dateFormat.format(new Date()));
    }
}

