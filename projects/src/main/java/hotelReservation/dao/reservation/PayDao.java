package hotelReservation.dao.reservation;

import hotelReservation.dto.Pay;

public interface PayDao {

	int priceInfo(String tcode);
	int payInfo(Pay pay);
	int cancel(String pid);
}
