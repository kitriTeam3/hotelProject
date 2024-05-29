package hotelReservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePid {

	private int cardco;
	private String chargedate;
	
	
	public CreatePid(int cardco, String chargedate) {
		this.cardco = cardco;
		this.chargedate = chargedate;
	}
	


}
