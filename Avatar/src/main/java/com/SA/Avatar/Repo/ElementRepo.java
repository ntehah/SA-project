package com.SA.Avatar.Repo;

import com.SA.Avatar.Entity.Element;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementRepo extends MongoRepository<Element,String> {
}
