package hotelReservation.dao.reservation;


import hotelReservation.dto.CreatePid;
import hotelReservation.dto.CustomerLogin;
import hotelReservation.dto.Pay;

public interface PayDao {
	String payCid(String cid);
	String payLogin(CustomerLogin cl);
	int priceInfo(String tcode);
	
	String createPid(CreatePid cp);
	int payInfo(Pay pay);
	int cancel(String pid);
}
