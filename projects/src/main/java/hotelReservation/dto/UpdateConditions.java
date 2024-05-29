package hotelReservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateConditions {
	private String hid;
	private String location;
	private int grade;
	
	public UpdateConditions(String hid, String location, int grade) {
		this.hid = hid;
		this.location = location;
		this.grade = grade;
	}
	
}
