package com.catering.in.CateringBusinessLogin.user;

import com.catering.in.CateringBusinessLogin.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements IUserService{

    private final IUserServiceDao dao;

    public UserServiceImpl(IUserServiceDao dao) {
        this.dao = dao;
    }

    @Override
    public User getUserById(int id) {
       return dao.getUserById(id);
    }

    @Override
    public List<User> getAllUser() {
        return dao.getAllUser();
    }

    @Override
    public void saveAll(User user) {
        dao.saveAll(user);
    }
}
