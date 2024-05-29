package hotelReservation.controller.reservation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hotelReservation.dto.CustomerLogin;
import hotelReservation.svc.reservation.PaySvc;

@Controller
public class PayCtrl {
	
	@Autowired
	private PaySvc paySvc;
	private HttpSession session;
	
	
	//로그인 안한 회원 로그인 확인
	@RequestMapping(value="/payLogin", method=RequestMethod.POST)
	public String payLogin(HttpServletRequest req, @RequestParam("cid") String cid, 
			@RequestParam("cpw") String cpw, ModelMap model) {
		
		CustomerLogin cl = new CustomerLogin(cid, cpw);
		
		// 아이디 없음
		if(paySvc.payCid(cid)==null) {
			System.out.println("ID체크");
			model.addAttribute("result", "no_id");
			return "reservation/payLogin";
		} 
		// 아이디 있음
		else {
			// 비밀번호 불일치
			System.out.println("PW체크");
			if(paySvc.payLogin(cl)==null) {
				
				model.addAttribute("result", "wrong_pw");
				return "reservation/payLogin";
			} //비밀번호 
			// 가격 정보 넘기기
			else {
				session = req.getSession();
				
				//세션으로 로그인 아이디 저장
				session.setAttribute("cid", cid);

				// 세션에 저장된 상품코드 값 가져오기
				String tcode = (String) session.getAttribute("tcode"); 
				System.out.println(tcode);
				System.out.println(paySvc.priceInfo(tcode));
				// 상품코드를 통해 가격 정보 가져오기
				model.addAttribute("price", paySvc.priceInfo(tcode));
				
				return "reservation/payInfo";
			}
		}

	}
	
	/*
	 * 
	 */
	//테스트용
	@RequestMapping(value="/pay")
	public String payPage() {

		return "reservation/payInfo";
	}
	/*
	 * 
	 */
	

	@RequestMapping(value="/payInfo", method=RequestMethod.POST)
	public String payInfo(@RequestParam("cardco") String cardco,
			@RequestParam("cardno") String cardno,
			@RequestParam("expiredate") String expiredate, 
			ModelMap model) {
		
		
		return "reservation/payInfo";
	}
	
}
