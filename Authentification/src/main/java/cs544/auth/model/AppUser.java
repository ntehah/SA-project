package cs544.auth.model;

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

    private String username;

    private String email;

    private String password;

    List<AppUserRole> appUserRoles;

}
