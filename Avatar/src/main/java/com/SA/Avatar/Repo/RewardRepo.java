package com.SA.Avatar.Repo;

import com.SA.Avatar.Entity.Reward;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardRepo extends MongoRepository<Reward,String> {
}
