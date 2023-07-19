package com.SA.Student.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SendEmailDTO {
    private String email;
    private String message;
}
