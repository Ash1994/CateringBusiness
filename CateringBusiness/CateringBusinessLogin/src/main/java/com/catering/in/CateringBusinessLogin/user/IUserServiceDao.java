package com.catering.in.CateringBusinessLogin.user;

import com.catering.in.CateringBusinessLogin.user.model.User;

import java.util.List;

public interface IUserServiceDao {
    User getUserById(int id);
    List<User> getAllUser();
    void saveAll(User user);
}
