package com.SA.SchoolService.Repository;

import com.SA.SchoolService.Model.School;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SchoolRepository extends MongoRepository<School, String> {
}
