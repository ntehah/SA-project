package com.SA.Teacher.DAO;

import com.SA.Teacher.Entity.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IteacherDAO extends MongoRepository<Teacher, String> {
    public List<Teacher> findTeacherBySchoolId(String school_id);
}
