package hotelReservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pay {

	private String pid;
	private String cardco;
	private String chargedate;
	private String expiredate;
	private int cardno;
	private int cvcno;
	private int price;
	private char cancel;
	
	public Pay() {}
	public Pay(String cardco, String chargedate, String expiredate, int cardno, int cvcno, int price, char cancel) {
		this.cardco = cardco;
		this.chargedate = chargedate;
		this.expiredate = expiredate;
		this.cardno = cardno;
		this.cvcno = cvcno;
		this.price = price;
		this.cancel = cancel;
	}
}