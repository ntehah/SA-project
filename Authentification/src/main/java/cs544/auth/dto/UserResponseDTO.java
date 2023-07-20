package cs544.auth.dto;

import java.util.List;

import cs544.auth.model.AppUserRole;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserResponseDTO {

  @ApiModelProperty(position = 0)
  private String id;
  @ApiModelProperty(position = 1)
  private String username;
  @ApiModelProperty(position = 2)
  private String email;
  @ApiModelProperty(position = 3)
  List<AppUserRole> appUserRoles;

}
