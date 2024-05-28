package hotelReservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rdate {

		private int year;
		private int month;

		public Rdate() {}
		public Rdate(int year, int month) {
			this.year = year;
			this.month = month;
		}
	}

