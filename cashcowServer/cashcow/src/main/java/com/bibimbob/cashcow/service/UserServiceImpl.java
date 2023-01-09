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

    /**
     * 회원 가입(유저 저장)
     */
    @Override
    public Long save(User user) throws Exception {
        userRepository.save(user);
        return user.getId();
    }

    /**
     * 유저 조회
     */
    @Override
    public User findOne(long id) throws Exception {
        User user = userRepository.findOne(id);
        return user;
    }

    /**
     * 유저 자산 정보 수정
     */
    @Override
    public Long updateAssets(Long assetsId, UserAssetsDto userAssetsDto) throws Exception {
        UserAssets findAssets = userRepository.findOneAssets(assetsId);

        findAssets.change(userAssetsDto.getTotalHoldings(),
                userAssetsDto.getSalary(),
                userAssetsDto.getGoalAmount(),
                now());
        return findAssets.getId();
    }

    /**
     * 유저 정보 수정
     */
    @Override
    public Long updateUser(Long userId, UserDto userDto) throws Exception {
        User findUser = userRepository.findOne(userId);

        findUser.change(userDto.getPassword(),
                userDto.getName(),
                userDto.getNickname(),
                userDto.getGender(),
                userDto.getJob(),
                userDto.getStatus(),
                now(),
                userDto.getPhoneNumber());

        return findUser.getId();
    }
}
