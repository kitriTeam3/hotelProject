package hotelReservation.dao.impl.reservation;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hotelReservation.dao.reservation.PayDao;
import hotelReservation.dto.Pay;
import lombok.Getter;
import lombok.Setter;

@Repository
@Getter
@Setter
public class PayDaoImpl implements PayDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	
	@Override
	public int priceInfo(String tcode) {
		int price = sqlSessionTemplate.selectOne("pay.priceInfo", tcode);
		return price;
	}

	
	@Override
	public int payInfo(Pay pay) {
		int cnt = sqlSessionTemplate.insert("pay.payInfo", pay);
		return cnt;
	}

	@Override
	public int cancel(String pid) {
		int cnt = sqlSessionTemplate.delete("pay.cancel", pid);
		return cnt;
	}


}

