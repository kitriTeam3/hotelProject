package hotelReservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelLogin {
	
	private String hid;
	private String hpw;
	
	public HotelLogin() {
		
	}
	
	public HotelLogin(String hid, String hpw) {
		this.hid = hid;
		this.hpw = hpw;
	}
}
