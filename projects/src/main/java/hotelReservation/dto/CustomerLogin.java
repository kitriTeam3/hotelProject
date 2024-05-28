package hotelReservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerLogin {
	
	private String cid;
	private String cpw;
	
	public CustomerLogin() {
		
	}
	
	public CustomerLogin(String cid, String cpw) {
		this.cid = cid;
		this.cpw = cpw;
	}
}
