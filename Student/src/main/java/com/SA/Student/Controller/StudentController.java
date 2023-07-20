package com.SA.Student.Controller;

import com.SA.Student.DTO.ElementOperationDTO;
import com.SA.Student.DTO.SendEmailDTO;
import com.SA.Student.DTO.StudentDTO;
import com.SA.Student.Entity.Student;
import com.SA.Student.Service.KafkaProducer;
import com.SA.Student.Service.StudentService;
import com.SA.Student.client.ElementFeignClient;
import com.SA.Student.exeption.NotFoundException;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private KafkaProducer kafkaProducer;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ElementFeignClient elementClient;
    @GetMapping()
    public List<Student> getAll(){
        return studentService.getAll();
    }
    @GetMapping("/{studentNumber}")
    public Student get(@PathVariable String studentNumber) throws NotFoundException {
        return studentService.get(studentNumber);
    }

    @GetMapping("/school/{school_id}")
    public List<Student> getBySchoolId(@PathVariable String school_id) throws NotFoundException {
        return studentService.findBySchoolId(school_id);
    }

    @PostMapping("/add")
    public void add(@RequestBody StudentDTO studentDTO) throws NotFoundException {
        Student student = modelMapper.map(studentDTO, Student.class);
        studentService.add(student);
        SendEmailDTO sendEmailDTO = new SendEmailDTO();
        sendEmailDTO.setEmail(student.getEmail());
        sendEmailDTO.setMessage("your account was created, here is your and username: "+studentDTO.getEmail() +
                " and password: "+studentDTO.getPassword());
        String msg= new Gson().toJson(sendEmailDTO);
        kafkaProducer.sendMessage("emails",msg);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student) { studentService.update(student);}

    @PostMapping("/updateStudentScore/{id}")
    public void updateStudentScore(@PathVariable String id, @RequestBody Double score) throws NotFoundException{
        System.out.println(score);
        Student student = get(id);
        student.setScore(score);
        studentService.update(student);
    }

    @PostMapping("/addRewardToStudent/{studentId}")
    public void addRewardToStudent(@PathVariable String studentId, @RequestBody String rewardId) throws NotFoundException{
        System.out.println(rewardId);
        Student student = get(studentId);
        student.addReward(rewardId);
        studentService.update(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        studentService.delete(id);
    }

    @PostMapping("buy-element")
    public String buyElementByStudent(@RequestBody ElementOperationDTO elementOperationDTO){
        return elementClient.buyElementByStudent(elementOperationDTO);
    }

}
