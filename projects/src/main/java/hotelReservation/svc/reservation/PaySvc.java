
package hotelReservation.svc.reservation;

import hotelReservation.dto.Pay;

public interface PaySvc {

	int priceInfo(String tcode);
	int payInfo(Pay pay);
	int cancel(String pid);
}
