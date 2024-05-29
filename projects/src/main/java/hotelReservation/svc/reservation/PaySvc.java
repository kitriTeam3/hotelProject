
package hotelReservation.svc.reservation;

import hotelReservation.dto.CustomerLogin;
import hotelReservation.dto.Pay;

public interface PaySvc {

	String payCid(String cid);
	String payLogin(CustomerLogin cl);
	int priceInfo(String tcode);
	int payInfo(Pay pay);
	int cancel(String pid);
}
