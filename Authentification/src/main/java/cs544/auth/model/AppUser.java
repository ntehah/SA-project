package cs544.auth.model;

import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document
@Data
@NoArgsConstructor
public class AppUser {

    @Id
    private String id;

    @Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
    private String username;

    private String email;

    @Size(min = 8, message = "Minimum password length: 8 characters")
    private String password;

    List<AppUserRole> appUserRoles;

}
