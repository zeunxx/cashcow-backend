package com.bibimbob.cashcow.repository;

import com.bibimbob.cashcow.domain.Stock.FavoriteStock;
import com.bibimbob.cashcow.domain.User;
import com.bibimbob.cashcow.dto.StockDto.UserStockDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.List;

import static java.time.LocalDateTime.now;

@Repository
@RequiredArgsConstructor
public class UserRepository  {

    private final EntityManager em;

    public void save(User user){
        em.persist(user);
    }

    public User findOne(Long id){
        return em.find(User.class,id);
    }
    /**
     *  회원 id로 검색(pk x)
     */
    public List<User> findById(String userId){
        return em.createQuery("select u from User u where u.userId=:userId", User.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    /**
     * 주식 즐겨찾기 저장
     */
    public void saveStock(FavoriteStock favoriteStock){
        em.persist(favoriteStock);
    }

    /**
     * 주식 즐겨찾기 삭제
     */
    public  void removeStock(FavoriteStock favoriteStock){
        em.remove(favoriteStock);
    }

    /**
     * 주식 즐겨찾기 1개 get
     */
    public List<FavoriteStock>  findOneStock(Long id, Long stockCode){
        User user = em.find(User.class, id);
        return em.createQuery("select s from FavoriteStock s where s.user = :user and s.stockCode = :stockCode", FavoriteStock.class)
                .setParameter("user", user)
                .setParameter("stockCode", stockCode)
                .getResultList();

    }

    /**
     * 주식 즐겨찾기 list get
     */
    public List<FavoriteStock>  findStockList(User user){
        return em.createQuery("select s from FavoriteStock s where s.user = :user", FavoriteStock.class)
                .setParameter("user", user)
                .getResultList();

    }
}
