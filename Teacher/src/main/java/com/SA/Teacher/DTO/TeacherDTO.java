package com.SA.Teacher.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TeacherDTO {
    private String teacher_id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String schoolId;
    private String teaching_class;
}
