package com.bibimbob.cashcow.repository;

import com.bibimbob.cashcow.domain.Stock.FavoriteStock;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Optional;


@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
public class StockJpaRepositoryTest {

    @Autowired StockJpaRepository stockJpaRepository;

    @Test
    public void findStockList() throws Exception{
        //given

        //when
        List<FavoriteStock> allByUserPk = stockJpaRepository.findByUserPk(6L);

        //then
        for (FavoriteStock stock : allByUserPk) {
            System.out.println("stock = " + stock);
        }
    }

    @Test
    public void findStock() throws Exception{
        //given

        //when
        Optional<FavoriteStock> findStock = stockJpaRepository.findOne(6L, "12345");

        //then
        if (findStock.isPresent()){
            Assertions.assertThat(findStock.get().getId()).isEqualTo(28);
        }
    }
}