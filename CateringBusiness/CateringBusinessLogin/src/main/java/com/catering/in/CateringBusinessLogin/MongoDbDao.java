package com.catering.in.CateringBusinessLogin;

import com.catering.in.CateringBusinessLogin.user.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoDbDao extends MongoRepository<User, Integer> {
}
