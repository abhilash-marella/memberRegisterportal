package com.memberServices.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.memberServices.model.Dependants;


public interface DependantRepository extends MongoRepository<Dependants, Integer> {
	public Optional<List<Dependants>> findByRegisteredUser(String registeredUser);
}
