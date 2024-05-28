package hotelReservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeSignUp {
	
	private String eid;
	private String epw;
	private String ename;
	private String email;
	private String ephone;
	
	public EmployeeSignUp() {
		
	}
	
	public EmployeeSignUp(String eid,
						String epw,
						String ename,
						String email,
						String ephone) {
		this.eid = eid;
		this.epw = epw;
		this.ename = ename;
		this.email = email;
		this.ephone = ephone;
	}
	
}
