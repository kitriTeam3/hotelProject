package hotelReservation.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hotelReservation.dao.GoodsDao;
import hotelReservation.dto.Hotel;
import hotelReservation.dto.Search;
import hotelReservation.dto.SearchResult;
import hotelReservation.dto.Tdetails;
import hotelReservation.dto.Type;
import hotelReservation.dto.UpdateConditions;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Repository
public class GoodsDaoImpl implements GoodsDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public Hotel selectHotel(String hid) {
		Hotel hotel = sqlSessionTemplate.selectOne(
				"goods.selectHotel", hid);
		
		return hotel;
	}

	@Override
	public int updateHotel(UpdateConditions updateConditions) {
		int count = sqlSessionTemplate.update(
				"goods.updateHotel", updateConditions);
				
		return count;
	}

	@Override
	public String findMaxTcode(String hid) {
		String findTcode = sqlSessionTemplate.selectOne(
				"goods.findMaxTcode", hid);
		return findTcode;
	}
		
	@Override
	public int registerGoods(Type type) {
		int count = sqlSessionTemplate.insert(
				"goods.registerGoods", type);
		
		return count;
	}
	
	@Override
	public int deleteGoods(String tcode) {
		int count = sqlSessionTemplate.delete(
				"goods.deleteGoods", tcode);
		
		return  count;
	}

	@Override
	public String findTcode(String hid) {
		String findTcode = sqlSessionTemplate.selectOne(
				"goods.findTcode", hid);
		return findTcode;
	}
	
	@Override
	public int registerGoodsDetail(Tdetails tdetails) {
		int count = sqlSessionTemplate.insert(
				"goods.registerGoodsDetail", tdetails);
		
		return count;
	}

	@Override
	public List<SearchResult> hotelList() {
		List<SearchResult> hotelList = 
				sqlSessionTemplate.selectList(
						"goods.hotelList");
		
		return hotelList;
	}

	@Override
	public List<SearchResult> searchList(Search search) {
		List<SearchResult> searchList = 
				sqlSessionTemplate.selectList(
						"goods.searchList", search);
		
		return searchList;
	}

	@Override
	public List<Type> hotelDetail(String hid) {
		List<Type> detailList = 
				sqlSessionTemplate.selectList(
						"goods.hotelDetail", hid);
		
		return detailList;
	}

	@Override
	public Tdetails goodsDetail(String tcode) {
		Tdetails tdetails = sqlSessionTemplate.selectOne(
				"goods.goodsDetail", tcode);
		
		return tdetails;
	}
}
