package com.l3a.coinRanking;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.l3a.coinRanking.kafka.Producer;
import com.l3a.coinRanking.models.Coin;
import com.l3a.coinRanking.models.CoinRankingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Controller
public class RankController {

    Logger logger = LoggerFactory.getLogger(RankController.class);

    @Autowired
    private PersistenceModule persistenceModule;

    @Autowired
    private Producer producer;



    @GetMapping("/rank")
    public String baseCoin(@RequestParam(name="base", required=false, defaultValue="EUR") String base, Model model) throws IOException {
        model.addAttribute("base", base);

        producer.sendMessage(new Timestamp(new Date().getTime()) +" User is trying to check ranking");

        if(persistenceModule.isCacheEmpty()) {
            producer.sendMessage(new Timestamp(new Date().getTime()) +" Fetching Ranking from Database");
            List<Coin> temp = persistenceModule.findAll();
            temp.sort(Comparator.comparing(Coin::getRank));
            model.addAttribute("coins", temp);
        }
        else {
            producer.sendMessage(new Timestamp(new Date().getTime()) +" Fetching Ranking from Cache");
            List<Coin> temp = persistenceModule.getCache();
            temp.sort(Comparator.comparing(Coin::getRank));
            model.addAttribute("coins", temp);
        }
        return "rank";
    }

    private String getRank(String base){
        String url = "https://api.coinranking.com/v1/public/coins";
        UriComponentsBuilder builder =  UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("base", base);
        RestTemplate rT = new RestTemplate();
        ResponseEntity<String>  resp = rT.getForEntity(builder.toUriString(), String.class);
        return resp.getBody();
    }

}
