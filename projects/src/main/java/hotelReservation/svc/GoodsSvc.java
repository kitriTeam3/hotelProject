package hotelReservation.svc;

import java.util.List;

import hotelReservation.dto.Hotel;
import hotelReservation.dto.Search;
import hotelReservation.dto.SearchResult;
import hotelReservation.dto.Tdetails;
import hotelReservation.dto.Type;
import hotelReservation.dto.UpdateConditions;

public interface GoodsSvc {
	Hotel selectHotel(String hid);
	int updateHotel(UpdateConditions updateConditions);
	String findMaxTcode(String hid);
	int registerGoods(Type type);
	int deleteGoods(String tcode);
	String findTcode(String hid);
	int registerGoodsDetail(Tdetails tdetails);
	List<SearchResult> hotelList();
	List<SearchResult> searchList(Search search);
	List<Type> hotelDetail(String hid);
	Type goodsType(String tcode);
	Tdetails goodsDetail(String tcode);
}
