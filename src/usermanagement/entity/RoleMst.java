package usermanagement.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RoleMst {
	
	private int roleId;           //1    //2
	private String roleName;      //admin//user

}
