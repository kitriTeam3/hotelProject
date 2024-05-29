package hotelReservation.svc.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotelReservation.dao.GoodsDao;
import hotelReservation.dto.Hotel;
import hotelReservation.dto.Search;
import hotelReservation.dto.SearchResult;
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
	public String findTcode(String hid) {
		String findTcode = goodsDao.findTcode(hid);
		return findTcode;
	}
	
	@Override
	public int registerGoodsDetail(Tdetails tdetails) {
		int count = goodsDao.registerGoodsDetail(tdetails);
		return count;
	}

	@Override
	public List<SearchResult> hotelList() {
		List<SearchResult> hotelList = goodsDao.hotelList();
		return hotelList;
	}

	@Override
	public List<SearchResult> searchList(Search search) {
		List<SearchResult> searchList = goodsDao.searchList(search);
		return searchList;
	}

	@Override
	public List<Type> hotelDetail(String hid) {
		List<Type> detailList = goodsDao.hotelDetail(hid);
		return detailList;
	}
	
	@Override
	public Type goodsType(String tcode) {
		Type type = goodsDao.goodsType(tcode);
		return type;
	}

	@Override
	public Tdetails goodsDetail(String tcode) {
		Tdetails tdetails = goodsDao.goodsDetail(tcode);
		return tdetails;
	}

}
