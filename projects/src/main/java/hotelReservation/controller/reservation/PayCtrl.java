package hotelReservation.controller.reservation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hotelReservation.svc.reservation.PaySvc;

@Controller
public class PayCtrl {
	
	@Autowired
	private PaySvc paySvc;
	private HttpSession session;
	
	//가격 정보 View에 넘기기
	@RequestMapping(value="/payInfo")
	public ModelMap priceInfo(HttpServletRequest req) {
		
		ModelMap model = new ModelMap();
		session = req.getSession();
		
		// 세션에 저장된 상품코드 값 가져오기
		String tcode = (String) session.getAttribute("tcode"); 
		
		// 상품코드를 통해 가격 정보 가져오기
		model.addAttribute("price", paySvc.priceInfo(tcode));
		
		return model;
	}
	
	
	@RequestMapping(value="/payInfo", method=RequestMethod.POST)
	public String payInfo(@RequestParam("cardco") String cardco,
			@RequestParam("cardno") String cardno,
			@RequestParam("expiredate") String expiredate, 
			ModelMap model) {
		
		
		return "reservation/PayInfo";
	}
	
}
