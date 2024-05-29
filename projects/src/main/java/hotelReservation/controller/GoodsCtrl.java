package hotelReservation.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import hotelReservation.dto.Search;
import hotelReservation.dto.SearchResult;
import hotelReservation.dto.Tdetails;
import hotelReservation.dto.Type;
import hotelReservation.dto.UpdateConditions;
import hotelReservation.svc.GoodsSvc;
import lombok.Getter;
import lombok.Setter;


@Controller
@Getter
@Setter
public class GoodsCtrl {
	@Autowired
	private GoodsSvc goodsSvc;
	
	//객실 등록
	@RequestMapping(value="/goodsregisterPage")
	public String goodsRegister(HttpSession session, Model model) {
		//String hid = (String) session.getAttribute("hid");
		String hid = "KOR0001";
		if(hid != null) {
			model.addAttribute("hotel", goodsSvc.selectHotel(hid));
		} 
		return "goods/goodsregister";
	}
	
	@RequestMapping(value="/hotelupdate", method=RequestMethod.POST)
	public String updateHotle(@RequestParam("location") String location,
			@RequestParam("grade") int grade, 
			Model model, HttpSession session) {
		String hid = "KOR0001";
		UpdateConditions update = new UpdateConditions(hid, location, grade);
		model.addAttribute(goodsSvc.updateHotel(update));
		
		return "goods/goodsregister";
	}
	
	@RequestMapping(value="/goodsregister", method=RequestMethod.POST)
	public String insertGoods(@RequestParam("tname") String tname,
			@RequestParam("max") int max,
			@RequestParam("tprice") int tprice,
			@RequestParam("amounts") int amounts,
			Model model, HttpSession session) {
		//String hid = (String) session.getAttribute("hid");
		String hid = "KOR0001";
		String tcode = goodsSvc.findMaxTcode(hid);
		Type type = new Type(tcode, tname, max, tprice, amounts, hid);
		model.addAttribute(goodsSvc.registerGoods(type));
		
		return "goods/goodsdetailregister";
	}
	
	// 객실 세부정보 등록
	@RequestMapping(value="/goodsdetailregisterPage")
	public String goodsDetailRegister() {
		return "goods/goodsdetailregister";
	}
	
	@RequestMapping(value="/goodsdetailregister", method=RequestMethod.POST)
	public String insertGoodsDetail(@RequestParam("exp") String exp,
			@RequestParam("bedtype") String bedtype,
			@RequestParam("bedno") int bedno,
			@RequestParam("tview") String tview,
			@RequestParam("smoke") String smoke,
			@RequestParam("tsize") int tszie,
			@RequestParam("bathtype") String bathtype,
			@RequestParam("breakfast") String breakfast,
			Model model) {
		//String hid = (String) session.getAttribute("hid");
		String hid = "KOR0001";
		String tcode = goodsSvc.findTcode(hid);
		exp = exp.replace("\r\n","<br>");
		Tdetails tdetails = new Tdetails(tcode, exp, bedtype, bedno, tview, smoke, tszie, bathtype, breakfast);
		model.addAttribute(goodsSvc.registerGoodsDetail(tdetails));
		
		return "goods/alert";
	}
	
	// 호텔리스트 출력
	@RequestMapping(value="/findhotelPage")
	public String findHotel(Model model) {
		model.addAttribute("searchResult", goodsSvc.hotelList());
		
		return "goods/findhotel";
	}
	// 검색 결과 출력
	@RequestMapping(value="/findhotel", method=RequestMethod.POST)
	public String searchList(@RequestParam("checkIn") String checkIn,
			@RequestParam("checkOut") String checkOut,
			@RequestParam("location") String location,
			@RequestParam("max") int max,
			Model model) {
		Search search = new Search(checkIn, checkOut, max, location);
		model.addAttribute("searchResult", goodsSvc.searchList(search));
		
		return "goods/findhotel";
	}
	
	// 호텔 객실 정보 출력
	@RequestMapping(value="/hoteldetailPage")
	public String hotelDetail(Model model) {
		return "goods/hoteldetail";
	}
	
	@RequestMapping(value="/hoteldetail", method=RequestMethod.POST)
	public String hotelDetailList(@RequestParam(value="hid") String hid, Model model) {
		model.addAttribute(goodsSvc.hotelDetail(hid));
		return "goods/goodsdetail";
	}
	
	// 객실 세부정보 출력
	@RequestMapping(value="/goodsdetailPage")
	public String goodsDetail(Model model) {
		return "goods/goodsdetail";
	}
}
