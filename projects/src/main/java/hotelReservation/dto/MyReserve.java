package hotelReservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyReserve {

	private String rid;
	private String hname;
	private String exp;
	private String bedtype;
	private int person;
	private String rdate;
	private char cancel;
	private int price;
	
	
	public MyReserve(String rid, String hname, String exp, String bedtype, int person, String rdate, char cancel,
			int price) {
		this.rid = rid;
		this.hname = hname;
		this.exp = exp;
		this.bedtype = bedtype;
		this.person = person;
		this.rdate = rdate;
		this.cancel = cancel;
		this.price = price;
	}
	
	
	
}
