package com.l3a.coinRanking;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.l3a.coinRanking.models.Coin;
import com.l3a.coinRanking.models.CoinRankingRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersistenceModule {
    @Autowired
    private CoinRepository repo;

    private List<Coin> cache;
    Logger logger = LoggerFactory.getLogger(PersistenceModule.class);

    public Coin findById(Long id){
        return repo.findById(id).get();
    }

    public List<Coin> findAll(){ return repo.findAll(); }

    public List<Coin> getCache(){ return cache; }

    public boolean isCacheEmpty(){
        if (cache == null){
            return true;
        }
        else if (cache.size() == 0) return true;
        else return false;
    }

    public void replenishCache(){
        cache = repo.findAll();
    }

    public void getRankJson(String base) throws IOException {
        String url = "https://api.coinranking.com/v1/public/coins";
        UriComponentsBuilder builder =  UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("base", base);
        RestTemplate rT = new RestTemplate();
        logger.info("Attempting to send request API");
        ResponseEntity<String> resp = rT.getForEntity(builder.toUriString(), String.class);
        ObjectMapper mapper = new ObjectMapper();
        CoinRankingRequest request = mapper.readValue(resp.getBody(), CoinRankingRequest.class);
        logger.info("saving coins");
        for (int i = 0; i < 50; i++) {
            repo.save(request.getData().getCoins().get(i));
        }
    }




}
