package hotelReservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpLogin {
	private String eid;
	private String epw;
	
	public EmpLogin() {
		
	}
	
	public EmpLogin(String eid, String epw) {
		this.eid = eid;
		this.epw = epw;
	}
}
