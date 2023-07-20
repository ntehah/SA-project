package com.SA.Student.Service;

import com.SA.Student.DAO.StudentDAO;
import com.SA.Student.DTO.ElementOperationDTO;
import com.SA.Student.Entity.Student;
import com.SA.Student.client.ElementFeignClient;
import com.SA.Student.exeption.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentDAO studentDAO;
    private ElementFeignClient elementFeignClient;
    @Autowired
    public StudentService(ElementFeignClient elementFeignClient){
        this.elementFeignClient = elementFeignClient;
    }

    public List<Student> getAll(){
        return studentDAO.findAll();
    }

    public Student get(String id) throws NotFoundException {
        return studentDAO.findById(id).orElseThrow(() -> new NotFoundException("Action not found"));
    }

    public List<Student> findBySchoolId(String school_id){
        return studentDAO.findStudentBySchoolId(school_id);
    }

    public void add(Student student) {
        studentDAO.save(student);
    }


    public void update(Student student) {
        studentDAO.save(student);
    }

    public void delete(String id) {
        studentDAO.deleteById(id);
    }

    //Element Feign Beginning
    public String buyElementByStudent(ElementOperationDTO elementOperationDTO){
        return elementFeignClient.buyElementByStudent(elementOperationDTO);
    }
}
