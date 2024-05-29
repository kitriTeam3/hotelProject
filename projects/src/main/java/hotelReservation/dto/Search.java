package hotelReservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Search {
	private String checkIn;
	private String checkOut;
	private int max;
	private String location;
	
	public Search(String checkIn, String checkOut, int max, String location) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.max = max;
		this.location = location;
	}
	
}
