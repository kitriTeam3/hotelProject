package hotelReservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reserve {
	
	private String rid;
	private String rdate;
	private String firstname;
	private String lastname;
	private String email;
	private String country;
	private String request;
	private String checkin;
	private String checkout;
	private int person;
	private char cancel;
	private String pid;
	private String cid;
	private String tcode;
	
	public Reserve() {}

	public Reserve(String rid, String rdate, String firstname, 
			String lastname, String email, String country,
			String request, String checkin, String checkout, 
			int person, char cancel, String tcode) {
		this.rid = rid;
		this.rdate = rdate;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.country = country;
		this.request = request;
		this.checkin = checkin;
		this.checkout = checkout;
		this.person = person;
		this.cancel = cancel;
		this.tcode = tcode;
	}

}

