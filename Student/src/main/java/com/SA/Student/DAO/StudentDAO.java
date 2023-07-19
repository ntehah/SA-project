package com.SA.Student.DAO;

import com.SA.Student.Entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDAO extends MongoRepository<Student, String> {
    public List<Student> findStudentBySchoolId(String school_id);
}
