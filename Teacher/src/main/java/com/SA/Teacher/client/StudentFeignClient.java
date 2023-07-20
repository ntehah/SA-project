package com.SA.Teacher.client;

import com.SA.Teacher.DTO.Student;
import com.SA.Teacher.DTO.StudentDTO;
import com.SA.Teacher.exeption.NotFoundException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("Student")
public interface StudentFeignClient {
    @GetMapping("/students")
    public List<Student> getAll();

    @GetMapping("/students/{studentNumber}")
    public Student get(@PathVariable String studentNumber) throws NotFoundException;

    @GetMapping("/students/school/{school_id}")
    public List<Student> getBySchoolId(@PathVariable String school_id) throws NotFoundException;

    @PostMapping("/students/add")
    public void add(@RequestBody StudentDTO studentDTO) throws NotFoundException;

    @PutMapping("/students/update")
    public void update(@RequestBody Student student);

    @PostMapping("/students/updateStudentScore/{id}")
    public void updateStudentScore(@PathVariable String id, @RequestBody Double score);

    @PostMapping("/students/addRewardToStudent/{studentId}")
    public void addRewardToStudent(@PathVariable String studentId, @RequestBody String rewardId) throws NotFoundException;

    @DeleteMapping("/students/{id}")
    public void delete(@PathVariable String id);
}
