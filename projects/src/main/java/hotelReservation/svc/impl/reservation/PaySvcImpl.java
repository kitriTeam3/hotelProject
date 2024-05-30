
package hotelReservation.svc.impl.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotelReservation.dao.reservation.PayDao;
import hotelReservation.dto.CreatePid;
import hotelReservation.dto.CustomerLogin;
import hotelReservation.dto.HotelInfo;
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
	public String payCid(String cid) {
		String rCid = payDao.payCid(cid);
		return rCid;
	}

	@Override
	public String payLogin(CustomerLogin cl) {
		String cpw = payDao.payLogin(cl);
		return cpw;
	}

	@Override
	public int priceInfo(String tcode) {
		int price = payDao.priceInfo(tcode); 
		return price;
	}
	
	
	@Override
	public String createPid(CreatePid cp) {
		String pid = payDao.createPid(cp);
		return pid;
	}
	
	
	@Override
	public int payInfo(Pay pay) {
		int cnt = payDao.payInfo(pay);
		return cnt;
	}


	@Override
	public HotelInfo completeInfo(String tcode) {
		HotelInfo hInfo = payDao.completeInfo(tcode);
		return hInfo;
	}

	
	@Override
	public String cancelPid(String rid) {
		String pid = payDao.cancelPid(rid);
		return pid;
	}
	
	@Override
	public int cancel(String pid) {
		int cnt = payDao.cancel(pid);
		return cnt;
	}





}
