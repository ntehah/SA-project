package com.SA.Student.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class StudentDTO {
    private String studentNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String classe;
    private String year;
    private String groupe;
    private Double score;
    private School school;
    private Avatar avatar;
    private List<String> rewards;
}
