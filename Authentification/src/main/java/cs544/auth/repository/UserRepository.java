package cs544.auth.repository;

import cs544.auth.model.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<AppUser, Integer> {

  boolean existsByUsername(String username);

  AppUser findByUsername(String username);


}
