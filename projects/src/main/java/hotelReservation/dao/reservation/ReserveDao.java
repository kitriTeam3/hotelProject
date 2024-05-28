package hotelReservation.dao.reservation;

import java.util.List;

import hotelReservation.dto.CustomerInfo;
import hotelReservation.dto.Rdate;
import hotelReservation.dto.Reserve;



public interface ReserveDao {

	CustomerInfo customerInfo(String cid);
	int reserveInfo(Reserve reserve);
	int cancel(String rid);
	void stock();
	List<Reserve> bookByCustomer(String cid);
	Reserve bookById(String rid);
	List<Reserve> bookByYear(int year);
	List<Reserve> bookByMonth(Rdate rdate);
	
}
