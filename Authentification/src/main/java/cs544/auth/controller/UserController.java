package cs544.auth.controller;


import cs544.auth.dto.UserDataDTO;
import cs544.auth.dto.UserResponseDTO;
import cs544.auth.model.AppUser;
import cs544.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.NotFoundException;

@RestController
@RequestMapping("/users")
@Api(tags = "users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;


    @PostMapping("/signin")
    @ApiOperation(value = "Authenticates user and returns its JWT token.")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 422, message = "Invalid username/password supplied")})
    public String login(//
                        @ApiParam("Username") @RequestParam String username, //
                        @ApiParam("Password") @RequestParam String password) {
        return userService.signIn(username, password);
    }

    @PostMapping("/signup")
    @ApiOperation(value = "Creates user and returns its JWT token")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 422, message = "Username is already in use")})
    public String signup(@ApiParam("Signup User") @RequestBody UserDataDTO user) {
        return userService.signUp(modelMapper.map(user, AppUser.class));
    }


    @GetMapping(value = "/validate-token")
    @ApiOperation(value = "Validate user token", response = UserResponseDTO.class, authorizations = {@Authorization(value = "jwt")})
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public UserResponseDTO validateToken(HttpServletRequest req) {
        return modelMapper.map(userService.validateToken(req), UserResponseDTO.class);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "get User by Id", response = UserResponseDTO.class, authorizations = {@Authorization(value = "jwt")})
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})

    public UserResponseDTO userById(@PathVariable Integer id) throws NotFoundException {
        return modelMapper.map(userService.userById(id), UserResponseDTO.class);
    }

}
