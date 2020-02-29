package com.l3a.coinRanking;

import com.l3a.coinRanking.models.Coin;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CoinRepository extends CrudRepository<Coin, Long>{

    List<Coin> findAll();

    List<Coin> findByName(String name);

}
