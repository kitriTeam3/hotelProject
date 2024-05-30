
package hotelReservation.svc.impl.reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotelReservation.dao.reservation.ReserveDao;
import hotelReservation.dto.CreateRid;
import hotelReservation.dto.CustomerInfo;
import hotelReservation.dto.MyReserve;
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
	

	// 로그인 고객 정보 가져오기
	@Override
	public CustomerInfo customerInfo(String cid) {
		CustomerInfo cInfo = reserveDao.customerInfo(cid);
		return cInfo;
	}
	
	// 예약번호 생성
	@Override
	public String createRid(CreateRid cr) {
		String rid = reserveDao.createRid(cr);
		return rid;
	}

	
	// 예약 작성 정보 insert
	@Override
	public int reserveInfo(Reserve reserve) {
		int cnt = reserveDao.reserveInfo(reserve);
		return cnt;
	}

	// 예약 취소 update
	@Override
	public int cancel(String rid) {
	    int cnt = reserveDao.cancel(rid);
		return cnt;
	}

	// 예약 순간 객실 재고 변동
	@Override
	public void stock() {
		// TODO Auto-generated method stub
		
	}

	// 내 예약정보 조회
	@Override
	public List<MyReserve> myReservation(String cid) {
		List<MyReserve> myReservation = reserveDao.myReservation(cid);
		return myReservation;
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
