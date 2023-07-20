package com.SA.Avatar.Repo;

import com.SA.Avatar.Entity.Avatar;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvatarRepo extends MongoRepository<Avatar,String> {
}
