package com.catering.in.CateringBusinessLogin.user;

import java.util.List;

public interface IUserServiceDao {
    User getUserById(int id);
    List<User> getAllUser();
}
