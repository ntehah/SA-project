package com.SA.SchoolService.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class School {
    @Id
    private String id;
    private String name;
    private String address;
    private String email;
    private Long phoneNumber;

}
