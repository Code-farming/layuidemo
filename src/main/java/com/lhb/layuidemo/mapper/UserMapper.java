package com.lhb.layuidemo.mapper;

import com.lhb.layuidemo.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> selectAllUser();

    void insertOneUser(User user);

    void deleteById(int id);

    User selectOneUser(Integer id);

    void updateUser(User user);
}
