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
}
