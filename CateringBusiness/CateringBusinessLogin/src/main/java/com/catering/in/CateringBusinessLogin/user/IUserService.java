package com.catering.in.CateringBusinessLogin.user;

import java.util.List;

public interface IUserService {

    User getUserById(int id);
    List<User> getAllUser();

}
