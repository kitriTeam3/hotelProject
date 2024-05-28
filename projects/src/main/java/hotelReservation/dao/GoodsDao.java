package hotelReservation.dao;

import java.util.List;

import hotelReservation.dto.Hotel;
import hotelReservation.dto.Search;
import hotelReservation.dto.Tdetails;
import hotelReservation.dto.Type;
import hotelReservation.dto.UpdateConditions;

public interface GoodsDao {
	Hotel selectHotel(String hid);
	int updateHotel(UpdateConditions updateConditions);
	String findMaxTcode(String hid);
	int registerGoods(Type type);
	int deleteGoods(String tcode);
	int registerGoodsDetail(Tdetails tdetails);
	List<Hotel> hotelList();
	List<Hotel> searchList(Search search);
	List<Type> hotelDetail(String hid);
	Tdetails goodsDetail(String tcode);
}
