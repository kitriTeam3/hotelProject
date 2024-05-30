package hotelReservation.dao.reservation;

import java.util.List;

import hotelReservation.dto.CreateRid;
import hotelReservation.dto.CustomerInfo;
import hotelReservation.dto.MyReserve;
import hotelReservation.dto.Rdate;
import hotelReservation.dto.Reserve;



public interface ReserveDao {

	String createRid(CreateRid cr);
	CustomerInfo customerInfo(String cid);
	int reserveInfo(Reserve reserve);
	int cancel(String rid);
	void stock();
	
	List<MyReserve> myReservation(String cid);
	List<Reserve> bookByCustomer(String cid);
	Reserve bookById(String rid);
	List<Reserve> bookByYear(int year);
	List<Reserve> bookByMonth(Rdate rdate);
	
}
