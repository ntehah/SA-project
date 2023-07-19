package com.SA.Student.AOP;
import com.SA.Student.exeption.UnauthorizedException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class Authorization {

    private final AuthService authService;

    private final HttpServletRequest httpServletRequest;

//    @Around("execution(* com.SA.Student.Controller.*.*(..))")
//    public Object authorize(ProceedingJoinPoint joinPoint) throws Throwable {
//        String token = httpServletRequest.getHeader("Authorization");
//        System.out.println(token);
//
//        ResponseEntity<?> response = authService.isAuthorized(token);
//        System.out.println(response);
//
//        if (response.getStatusCode().isError()) {
//            throw new UnauthorizedException("Authorization failed");
//        }
//
//        return joinPoint.proceed();
//    }
}
