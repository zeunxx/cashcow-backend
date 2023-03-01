package com.bibimbob.cashcow.repository;

import com.bibimbob.cashcow.domain.Stock.FavoriteStock;
import com.bibimbob.cashcow.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StockJpaRepository extends JpaRepository<FavoriteStock, Long> {

    @Query("select s from FavoriteStock s where s.user.id = :userPk and s.stockCode = :stockCode")
    Optional<FavoriteStock> findOne(@Param("userPk") Long userPk, @Param("stockCode") String stockCode);


    @Query("select s from FavoriteStock s where s.user.id = :userPk")
    List<FavoriteStock> findByUserPk(@Param("userPk") long userPk);

    void deleteAllByUser(User user);
}
