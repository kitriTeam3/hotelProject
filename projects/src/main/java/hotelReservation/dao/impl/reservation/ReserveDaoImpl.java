
package hotelReservation.dao.impl.reservation;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hotelReservation.dao.reservation.ReserveDao;
import hotelReservation.dto.CreateRid;
import hotelReservation.dto.CustomerInfo;
import hotelReservation.dto.Rdate;
import hotelReservation.dto.Reserve;
import lombok.Getter;
import lombok.Setter;

@Repository
@Getter
@Setter
public class ReserveDaoImpl implements ReserveDao {
	
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	// 로그인한 고객 정보 가져오기
	@Override
	public CustomerInfo customerInfo(String cid) {
		CustomerInfo cInfo = sqlSessionTemplate.selectOne("reserve.customerInfo", cid);
		return cInfo;
	}
	
	
	// 예약아이디 생성
	@Override
	public String createRid(CreateRid cr) {
		String rid = sqlSessionTemplate.selectOne("reserve.createRid", cr);
		return rid;
	}


	@Override
	public int reserveInfo(Reserve reserve) {
		int cnt = sqlSessionTemplate.insert("reserve.reserveInfo", reserve);
		return cnt;
	}


	@Override
	public int cancel(String rid) {
		int cnt = sqlSessionTemplate.update("reserve.cancel", rid);
		return cnt;
	}

	@Override
	public void stock() {
	
		
	}

	@Override
	public List<Reserve> bookByCustomer(String cid) {
		List<Reserve> bookList = sqlSessionTemplate.selectList("reserve.bookByCustomer", cid);
		return bookList;
	}

	@Override
	public Reserve bookById(String rid) {
		Reserve reservation = sqlSessionTemplate.selectOne("reserve.bookById", rid);
		return reservation;
	}

	@Override
	public List<Reserve> bookByYear(int year) {
		List<Reserve> bookList = sqlSessionTemplate.selectList("reserve.bookByYear", year);
		return bookList;
	}

	@Override
	public List<Reserve> bookByMonth(Rdate rdate) {
		List<Reserve> bookList = sqlSessionTemplate.selectList("reserve.bookByCustomer", rdate);
		return bookList;
	}


}

