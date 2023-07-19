package com.SA.Avatar.Repo;

import com.SA.Avatar.Entity.Reward;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RewardRepo extends MongoRepository<Reward,String> {
}
