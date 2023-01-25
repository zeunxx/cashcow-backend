package com.bibimbob.cashcow.repository;

import com.bibimbob.cashcow.domain.User;
import com.bibimbob.cashcow.domain.UserAssets.UserAssets;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import static java.time.LocalDateTime.now;

@Repository
@RequiredArgsConstructor
public class UserRepository  {

    private final EntityManager em;

    public void save(User user){
        em.persist(user);
    }

    public void saveAsset(UserAssets userAssets){
        em.persist(userAssets);
    }

    public UserAssets findOneAssets(Long assetsId){
        // 변경 감지 이용
        UserAssets findAssets = em.find(UserAssets.class, assetsId);
        return findAssets;
    }

    public User findOne(Long id){
        return em.find(User.class,id);
    }
}
