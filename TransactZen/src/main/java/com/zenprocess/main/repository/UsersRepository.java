package com.zenprocess.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zenprocess.main.document.User;

public interface UsersRepository extends MongoRepository<User, Integer> {

}
