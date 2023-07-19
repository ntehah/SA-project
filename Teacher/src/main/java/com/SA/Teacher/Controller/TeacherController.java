package com.SA.Teacher.Controller;

import com.SA.Teacher.DTO.SendEmailDTO;
import com.SA.Teacher.DTO.TeacherDTO;
import com.SA.Teacher.Entity.Teacher;
import com.SA.Teacher.Service.KafkaProducer;
import com.SA.Teacher.Service.TeacherService;
import com.SA.Teacher.exeption.NotFoundException;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ModelMapper modalMapper;
    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping()
    public List<Teacher> getAll(){
        return teacherService.getAll();
    }
    @GetMapping("/{id}")
    public Teacher get(@PathVariable String id, HttpServletRequest request) throws NotFoundException {
        return teacherService.get(id);
    }

    @GetMapping("school/{school_id}")
    public List<Teacher> getBySchoolId(@PathVariable String school_id, HttpServletRequest request) throws NotFoundException {
        return teacherService.findBySchoolId(school_id);
    }

    @PostMapping("/add")
    public void add(@RequestBody TeacherDTO teacherDTO) throws NotFoundException {
        Teacher teacher = modalMapper.map(teacherDTO, Teacher.class);
        teacherService.add(teacher);
        SendEmailDTO sendEmailDTO = new SendEmailDTO();
        sendEmailDTO.setEmail(teacher.getEmail());
        sendEmailDTO.setMessage("your account was created, here is your and username: "+teacherDTO.getEmail() +
                " and password: "+teacherDTO.getPassword());
        String msg= new Gson().toJson(sendEmailDTO);
        kafkaProducer.sendMessage("emails",msg);
    }

    @PutMapping("/update")
    public void update(@RequestBody Teacher student) { teacherService.update(student);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        teacherService.delete(id);
    }
}
