package com.SA.Avatar.Client;

import com.SA.Avatar.DTO.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "Student",url = "http://localhost:8090")
public interface StudentClient {
    @GetMapping("/students/{id}")
    public StudentDTO getStudent(@PathVariable String id);

    @PostMapping("/students/update-student-score/{id}")
    public void updateStudentScore(@PathVariable String id, @RequestBody double score);

    @PostMapping("/students/add-reward-to-student/{id}")
    public void addRewardToStudent(@PathVariable String id, @RequestBody String rewardId);
}
