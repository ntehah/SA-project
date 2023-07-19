package com.SA.Teacher.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
public class Teacher {
    @Id
    private String teacher_id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String schoolId;
    private String teaching_class;

}
