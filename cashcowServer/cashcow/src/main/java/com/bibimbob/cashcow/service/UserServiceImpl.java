package com.bibimbob.cashcow.service;

import com.bibimbob.cashcow.domain.User;
import com.bibimbob.cashcow.domain.UserAssets;
import com.bibimbob.cashcow.dto.UserAssetsDto;
import com.bibimbob.cashcow.dto.UserDto;
import com.bibimbob.cashcow.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

import static java.time.LocalDateTime.now;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public Long save(User user) throws Exception {
        userRepository.save(user);
        return user.getId();
    }

    @Override
    public User findOne(long id) throws Exception {
        User user = userRepository.findOne(id);
        return user;
    }

    @Override
    @Transactional
    public Long updateAssets(Long assetsId, UserAssetsDto userAssetsDto) throws Exception {
        UserAssets findAssets = userRepository.findOneAssets(assetsId);

        findAssets.change(userAssetsDto.getTotalHoldings(),
                userAssetsDto.getSalary(),
                userAssetsDto.getGoalAmount());
        return findAssets.getId();
    }
}
