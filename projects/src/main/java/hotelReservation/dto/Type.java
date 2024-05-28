package hotelReservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Type {
	private String tcode;
	private String tname;
	private int max;
	private double tprice;
	private int amounts;
	private String tpicture;
	private String hid;
}
