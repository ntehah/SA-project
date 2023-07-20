package com.SA.Teacher.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@NoArgsConstructor
public class Student {
    @Id
    private String studentNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String classe;
    private String year;
    private String group;
    private Double score = 1000.0;
    private String schoolId;
    private String avatarId;
    private List<String> rewards;

    public void addReward(String reward_id){
        rewards.add(reward_id);
    }
}
