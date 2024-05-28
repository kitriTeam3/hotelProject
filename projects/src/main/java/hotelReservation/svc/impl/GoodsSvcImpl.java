package hotelReservation.svc.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotelReservation.dao.GoodsDao;
import hotelReservation.dto.Hotel;
import hotelReservation.dto.Search;
import hotelReservation.dto.Tdetails;
import hotelReservation.dto.Type;
import hotelReservation.dto.UpdateConditions;
import hotelReservation.svc.GoodsSvc;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class GoodsSvcImpl implements GoodsSvc {
	@Autowired
	@Resource
	private GoodsDao goodsDao;

	@Override
	public Hotel selectHotel(String hid) {
		Hotel hotel = goodsDao.selectHotel(hid);
		return hotel;
	}

	@Override
	public int updateHotel(UpdateConditions updateConditions) {
		int count = goodsDao.updateHotel(updateConditions);
		return count;
	}

	@Override
	public String findMaxTcode(String hid) {
		String findTcode = goodsDao.findMaxTcode(hid);
		return findTcode;
	}
	
	@Override
	public int registerGoods(Type type) {
		int count = goodsDao.registerGoods(type);
		return count;
	}

	@Override
	public int deleteGoods(String tcode) {
		
		return 0;
	}
	
	@Override
	public int registerGoodsDetail(Tdetails tdetails) {
		int count = goodsDao.registerGoodsDetail(tdetails);
		return count;
	}

	@Override
	public List<Hotel> hotelList() {
		List<Hotel> hotelList = goodsDao.hotelList();
		return hotelList;
	}

	@Override
	public List<Hotel> searchList(Search search) {
		List<Hotel> searchList = goodsDao.searchList(search);
		return searchList;
	}

	@Override
	public List<Type> hotelDetail(String hid) {
		List<Type> detailList = goodsDao.hotelDetail(hid);
		return detailList;
	}

	@Override
	public Tdetails goodsDetail(String tcode) {
		Tdetails tdetails = goodsDao.goodsDetail(tcode);
		return tdetails;
	}

}
