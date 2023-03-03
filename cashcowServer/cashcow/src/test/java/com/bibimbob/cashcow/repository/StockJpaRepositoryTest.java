package com.bibimbob.cashcow.repository;

import com.bibimbob.cashcow.domain.Stock.FavoriteStock;
import com.bibimbob.cashcow.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
public class StockJpaRepositoryTest {

    @Autowired StockJpaRepository stockJpaRepository;
    @Autowired UserJpaRepository userJpaRepository;

    Pageable pageable = new Pageable() {
        @Override
        public int getPageNumber() {
            return 0;
        }

        @Override
        public int getPageSize() {
            return 0;
        }

        @Override
        public long getOffset() {
            return 0;
        }

        @Override
        public Sort getSort() {
            return null;
        }

        @Override
        public Pageable next() {
            return null;
        }

        @Override
        public Pageable previousOrFirst() {
            return null;
        }

        @Override
        public Pageable first() {
            return null;
        }

        @Override
        public Pageable withPage(int pageNumber) {
            return null;
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }
    };

    @Test
    public void findStockList() throws Exception{
        //given

        //when
        Page<FavoriteStock> findAll =  stockJpaRepository.findByUserPk(pageable,6L);

        //then
        for (FavoriteStock stock : findAll) {
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
            assertThat(findStock.get().getId()).isEqualTo(28);
        }
    }

    @Test
    public void deleteStockList() throws Exception{
        //given
        long userId = 6L;

        //when
        Optional<User> findUser = userJpaRepository.findById(userId);
        if (findUser.isPresent()){
            stockJpaRepository.deleteAllByUser(findUser.get());
        }

        Page<FavoriteStock> findStockList = stockJpaRepository.findByUserPk(pageable,userId);

        //then
        assertThat(findStockList.getTotalElements()).isEqualTo(0);
    }
}