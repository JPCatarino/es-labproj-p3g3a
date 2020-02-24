package com.l3a.coinRanking;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class RankController {
    @GetMapping("/rank")
    public String baseCoin(@RequestParam(name="base", required=false, defaultValue="EUR") String base, Model model) {
        model.addAttribute("base", base);
        model.addAttribute("ranking", getRank(base));
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
