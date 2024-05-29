package hotelReservation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hotelReservation.dto.Search;
import hotelReservation.dto.Tdetails;
import hotelReservation.dto.Type;
import hotelReservation.dto.UpdateConditions;
import hotelReservation.svc.GoodsSvc;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Controller
public class GoodsCtrl {
	
	@Autowired
	private GoodsSvc goodsSvc;
	
	//객실 등록
	@RequestMapping(value = "/goodsregisterPage")
	public String goodsRegister(HttpSession session, ModelMap map) {
		//String hid = (String) session.getAttribute("hid");
		String hid = "KOR0001";
		if(hid != null) {
			map.addAttribute("hotel", goodsSvc.selectHotel(hid));
		} 
		return "goods/goodsregister";
	}
	
	@RequestMapping(value="/goodsregister", method=RequestMethod.POST)
	public String insertGoods(@RequestParam(value="type") Type type,
			@RequestParam(value="updateconditions") UpdateConditions update, ModelMap map) {
		map.addAttribute("update", goodsSvc.updateHotel(update));
		map.addAttribute("type", goodsSvc.registerGoods(type));
		return "goods/goodsregister";
	}
	
	// 객실 세부정보 등록
	@RequestMapping(value="/goodsdetailregisterPage")
	public String goodsDetailRegister() {
		return "goods/goodsdetailregister";
	}
	
	@RequestMapping(value="/goodsdetailregister", method=RequestMethod.POST)
	public String insertGoodsDetail(@RequestParam(value="tdetails") Tdetails tdetails, ModelMap map) {
		map.addAttribute("tdetails", goodsSvc.registerGoodsDetail(tdetails));
		return "goods/goodsdetailregister";
	}
	
	// 호텔리스트 출력
	@RequestMapping(value="/findhotelPage")
	public String findHotel() {
		return "goods/findhotel";
	}
	
	@RequestMapping(value="/findhotel", method=RequestMethod.POST)
	public String hotelList(ModelMap map) {
		map.addAttribute("hotellist", goodsSvc.hotelList());
		return "goods/findhotel";
	}
	// 검색 결과 출력
	@RequestMapping(value="/findhotel", method=RequestMethod.POST)
	public String searchList(@RequestParam(value="search") Search search, ModelMap map) {
		map.addAttribute("searchlist", goodsSvc.searchList(search));
		return "goods/findhotel";
	}
	
	// 호텔 객실 정보 출력
	@RequestMapping(value="/hoteldetailPage")
	public String hotelDetail() {
		return "goods/hoteldetail";
	}
	
	@RequestMapping(value="/hoteldetail", method=RequestMethod.POST)
	public String hotelDetailList(@RequestParam(value="hid") String hid, ModelMap map) {
		map.addAttribute(goodsSvc.hotelDetail(hid));
		return "goods/hoteldetail";
	}
	
	// 객실 세부정보 출력
	@RequestMapping(value="/goodsdetailPage")
	public String goodsDetail() {
		return "goods/goodsdetail";
	}
	
	@RequestMapping(value="/goodsdetail", method=RequestMethod.POST)
	public String goodsDetailList(@RequestParam(value="tcode") String tcode, ModelMap map) {
		map.addAttribute(goodsSvc.goodsDetail(tcode));
		return "goods/goodsdetail";
	}
}
