package hotelReservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerSignUp {
	
	private String cid;
	private String cpw;
	private String cname;
	private String firstname;
	private String lastname;
	private String cmail;
	private String cphone;
	
	public CustomerSignUp() {
		
	}
	
	public CustomerSignUp(String cid, String cpw, String cname, String firstname, String lastname, String cmail, String cphone) {
		this.cid = cid;
		this.cpw = cpw;
		this.cname = cname;
		this.firstname = firstname;
		this.lastname = lastname;
		this.cmail = cmail;
		this.cphone = cphone;
	}
}
