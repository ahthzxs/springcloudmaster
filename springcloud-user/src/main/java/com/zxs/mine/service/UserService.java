package com.zxs.mine.service;

import com.zxs.mine.api.dto.UserDto;
import com.zxs.mine.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> searchByCondition(User user);

    List<User> search(User user);

    int create(UserDto userDto);
    int create(User user);

    List<User> findAll();

    Map saveList(List<User> successList);

    int removeByIds(String[] idArray);

    List<User> findByIds(String ids);

    int updateUser(User user);

    User findById(int id);
}
