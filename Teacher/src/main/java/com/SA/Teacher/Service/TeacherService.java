package com.SA.Teacher.Service;

import com.SA.Teacher.DAO.IteacherDAO;
import com.SA.Teacher.DTO.Reward;
import com.SA.Teacher.DTO.RewardOperationDTO;
import com.SA.Teacher.DTO.Student;
import com.SA.Teacher.DTO.StudentDTO;
import com.SA.Teacher.Entity.Teacher;
import com.SA.Teacher.client.RewardFeignClient;
import com.SA.Teacher.client.StudentFeignClient;
import com.SA.Teacher.exeption.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private IteacherDAO teacherDAO;
    private final StudentFeignClient studentFeignClient;
    private final RewardFeignClient rewardFeignClient;

    @Autowired
    public TeacherService(StudentFeignClient studentFeignClient, RewardFeignClient rewardFeignClient) {
        this.studentFeignClient = studentFeignClient;
        this.rewardFeignClient = rewardFeignClient;
    }
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

    //Feign Student beginning

    public List<Student> getAllStudents(){
        return studentFeignClient.getAll();
    }
    public List<Student> getStudentBySchoolId(String school_id) throws NotFoundException{
        return studentFeignClient.getBySchoolId(school_id);
    }
    public void addStudent(StudentDTO studentDTO) throws NotFoundException{
        studentFeignClient.add(studentDTO);
    }

    public void updateStudent(Student student){
        studentFeignClient.update(student);
    }

    public void updateStudentScore(String id, Double score){
        studentFeignClient.updateStudentScore(id,score);
    }
    public void addRewardToStudent(String studentId,String rewardId) throws NotFoundException{
        studentFeignClient.addRewardToStudent(studentId,rewardId);
    }

    public void deleteStudent(String id){
        studentFeignClient.delete(id);
    }

    //Feign Student ending

    //Feign Reward beginning

    public Reward viewReward(String id) throws NotFoundException{
        return rewardFeignClient.view(id);
    }

    public void addReward(Reward reward) {
        rewardFeignClient.add(reward);
    }

    public void updateReward(Reward reward) throws NotFoundException{
        rewardFeignClient.update(reward);
    }

    public void deleteReward(String id) throws NotFoundException{
        rewardFeignClient.delete(id);
    }

    public String buyRewardByStudent(RewardOperationDTO rewardOperationDTO) throws NotFoundException{
        return rewardFeignClient.buyRewardByStudent(rewardOperationDTO);
    }

    //Feign Reward ending
}
