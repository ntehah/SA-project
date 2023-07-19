package com.SA.Teacher.Service;

import com.SA.Teacher.DAO.IteacherDAO;
import com.SA.Teacher.Entity.Teacher;
import com.SA.Teacher.exeption.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private IteacherDAO teacherDAO;

    public List<Teacher> getAll(){
        return teacherDAO.findAll();
    }

    public Teacher get(String id) throws NotFoundException {
        return teacherDAO.findById(id).orElseThrow(() -> new NotFoundException("Action not found"));
    }

    public List<Teacher> findBySchoolId(String school_id){
        return teacherDAO.findTeacherBySchoolId(school_id);
    }

    public void add(Teacher student) {
        teacherDAO.save(student);
    }


    public void update(Teacher student) {
        teacherDAO.save(student);
    }

    public void delete(String id) {
        teacherDAO.deleteById(id);
    }
}
