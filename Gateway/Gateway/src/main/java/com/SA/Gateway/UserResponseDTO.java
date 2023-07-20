package com.SA.Gateway;


import java.util.List;

public class UserResponseDTO {

  private String id;
  private String username;
  private String email;
  List<String> appUserRoles;

  public UserResponseDTO(String id, String username, String email, List<String> appUserRoles) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.appUserRoles = appUserRoles;
  }

  public UserResponseDTO() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<String> getAppUserRoles() {
    return appUserRoles;
  }

  public void setAppUserRoles(List<String> appUserRoles) {
    this.appUserRoles = appUserRoles;
  }
}
