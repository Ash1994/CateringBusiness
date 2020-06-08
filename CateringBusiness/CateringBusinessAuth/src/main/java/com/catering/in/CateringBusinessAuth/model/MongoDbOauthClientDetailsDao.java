package com.catering.in.CateringBusinessAuth.model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoDbOauthClientDetailsDao extends MongoRepository<OauthClientDetails, Integer> {
}
