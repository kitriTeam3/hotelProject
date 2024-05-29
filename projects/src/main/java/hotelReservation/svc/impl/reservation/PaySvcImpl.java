
package hotelReservation.svc.impl.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotelReservation.dao.reservation.PayDao;
import hotelReservation.dto.Pay;
import hotelReservation.svc.reservation.PaySvc;
import lombok.Getter;
import lombok.Setter;


@Service
@Getter
@Setter
public class PaySvcImpl implements PaySvc {

	@Autowired
	private PayDao payDao;
	
	@Override
	public int priceInfo(String tcode) {
		int price = payDao.priceInfo(tcode); 
		return price;
	}
	
	@Override
	public int payInfo(Pay pay) {
		int cnt = payDao.payInfo(pay);
		return cnt;
	}


	@Override
	public int cancel(String pid) {
		int cnt = payDao.cancel(pid);
		return cnt;
	}

}
