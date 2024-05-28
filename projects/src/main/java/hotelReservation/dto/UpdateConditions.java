package hotelReservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateConditions {
	private String hid;
	private String location;
	private int grade;
}
