package cs544.auth;

import cs544.auth.model.AppUser;
import cs544.auth.model.AppUserRole;
import cs544.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
@EnableFeignClients
@EnableDiscoveryClient
public class AuthenticationApplication implements CommandLineRunner {

    final UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(AuthenticationApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Override
    public void run(String... params) {
        if (!userService.existByUsername("admin")) {
            AppUser admin = new AppUser();
            admin.setUsername("admin");
            admin.setPassword("admin");
            admin.setEmail("admin@email.com");
            admin.setAppUserRoles(new ArrayList<>(List.of(AppUserRole.ADMIN)));

            userService.signUp(admin);
        }

        if (!userService.existByUsername("student")){
            AppUser student = new AppUser();
            student.setUsername("student");
            student.setPassword("student");
            student.setEmail("student@email.com");
            student.setAppUserRoles(new ArrayList<>(List.of(AppUserRole.STUDENT)));

            userService.signUp(student);
        }

        if (!userService.existByUsername("teacher")) {
            AppUser teacher = new AppUser();
            teacher.setUsername("teacher");
            teacher.setPassword("teacher");
            teacher.setEmail("teacher@email.com");
            teacher.setAppUserRoles(new ArrayList<>(List.of(AppUserRole.TEACHER)));

            userService.signUp(teacher);
        }

    }
}
