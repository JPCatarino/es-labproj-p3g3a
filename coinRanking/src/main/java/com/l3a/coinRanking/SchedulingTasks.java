package com.l3a.coinRanking;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.l3a.coinRanking.kafka.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulingTasks {
    private static final Logger log = LoggerFactory.getLogger(SchedulingTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    PersistenceModule persistenceModule;

    @Autowired
    private Producer producer;

    // CoinRanking only updates once a day, as far as i'm aware.
    @Scheduled(fixedRate = 180000)
    public void updateRank() throws IOException {
        log.info("Ranking Updated");
        producer.sendMessage(new Timestamp(new Date().getTime()) + " Ranking Updated", "system");
        persistenceModule.getRankJson("EUR");
    }

    @Scheduled(fixedRate = 120000)
    public void updateCache(){
        log.info("Replenishing cache");
        producer.sendMessage(new Timestamp(new Date().getTime()) + " Replenishing Cache", "system");
        persistenceModule.replenishCache();
    }
}

