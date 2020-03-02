package com.l3a.coinRanking;


import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.Comparator;
import java.util.List;

@Controller
public class RankController {

    Logger logger = LoggerFactory.getLogger(RankController.class);

    @Autowired
    PersistenceModule persistenceModule;

//    @Autowired
//    private CoinRepository repo;

    @GetMapping("/rank")
    public String baseCoin(@RequestParam(name="base", required=false, defaultValue="EUR") String base, Model model) throws IOException {
        model.addAttribute("base", base);
//        CoinRankingRequest req = getRankJson(base);
//        List<Coin> lc = getRankJson(base).getData().getCoins();
//        StringBuilder sb = new StringBuilder();

//        for(int i = 0; i < 10; i++){
//            sb.append(lc.get(i).getRank());
//            sb.append(". ");
//            sb.append(lc.get(i).getName());
//            sb.append(" ");
//        }
//        sb.append(repo.findById((long) 1).get().getName());
        if(persistenceModule.isCacheEmpty()) {
            //model.addAttribute("ranking", persistenceModule.findById((long) 1).getName());
            List<Coin> temp = persistenceModule.findAll();
            temp.sort(Comparator.comparing(Coin::getRank));
            model.addAttribute("coins", temp);
        }
        else {
            //model.addAttribute("ranking", persistenceModule.getCache().get(0).getName());
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

/*    private CoinRankingRequest getRankJson(String base) throws IOException {
        String url = "https://api.coinranking.com/v1/public/coins";
        UriComponentsBuilder builder =  UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("base", base);
        RestTemplate rT = new RestTemplate();
        logger.info("Attempting to send request API");
        ResponseEntity<String>  resp = rT.getForEntity(builder.toUriString(), String.class);
        ObjectMapper mapper = new ObjectMapper();
        CoinRankingRequest request = mapper.readValue(resp.getBody(), CoinRankingRequest.class);
        logger.info("saving coins");
        for (int i = 0; i < 3; i++) {
            repo.save(request.getData().getCoins().get(i));
        }
        return request;
    }*/
}
