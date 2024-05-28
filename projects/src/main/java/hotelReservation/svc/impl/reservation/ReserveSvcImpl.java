
package hotelReservation.svc.impl.reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotelReservation.dao.reservation.ReserveDao;
import hotelReservation.dto.CustomerInfo;
import hotelReservation.dto.Rdate;
import hotelReservation.dto.Reserve;
import hotelReservation.svc.reservation.ReserveSvc;
import lombok.Getter;
import lombok.Setter;


@Service
@Getter
@Setter
public class ReserveSvcImpl implements ReserveSvc {

	@Autowired
	private ReserveDao reserveDao;
	

	@Override
	public CustomerInfo customerInfo(String cid) {
		CustomerInfo cInfo = reserveDao.customerInfo(cid);
		return cInfo;
	}
	
	@Override
	public int reserveInfo(Reserve reserve) {
		int cnt = reserveDao.reserveInfo(reserve);
		return cnt;
	}


	@Override
	public int cancel(String rid) {
	    int cnt = reserveDao.cancel(rid);
		return cnt;
	}

	@Override
	public void stock() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Reserve> bookByCustomer(String cid) {
		List<Reserve> bookList = reserveDao.bookByCustomer(cid);
		return bookList;
	}

	@Override
	public Reserve bookById(String rid) {
		Reserve reservation = reserveDao.bookById(rid);
		return reservation;
	}

	@Override
	public List<Reserve> bookByYear(int year) {
		List<Reserve> bookList = reserveDao.bookByYear(year);
		return bookList;
	}

	@Override
	public List<Reserve> bookByMonth(Rdate rdate) {
		List<Reserve> bookList = reserveDao.bookByMonth(rdate);
		return bookList;
	}



}
