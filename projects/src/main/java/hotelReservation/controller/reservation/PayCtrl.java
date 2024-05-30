package hotelReservation.controller.reservation;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hotelReservation.dto.CreatePid;
import hotelReservation.dto.CustomerLogin;
import hotelReservation.dto.HotelInfo;
import hotelReservation.dto.Pay;
import hotelReservation.dto.Reserve;
import hotelReservation.svc.reservation.PaySvc;
import hotelReservation.svc.reservation.ReserveSvc;

@Controller
public class PayCtrl {
	
	@Autowired
	private PaySvc paySvc;
	
	@Autowired
	private ReserveSvc reserveSvc;
	private HttpSession session;
	

	//로그인 안한 회원 로그인(payLogin view-> ctrl)
	@RequestMapping(value="/payLogin", method=RequestMethod.POST)
	public String payLogin(HttpServletRequest req, @RequestParam("cid") String cid, 
			@RequestParam("cpw") String cpw, ModelMap model) {
		
		CustomerLogin cl = new CustomerLogin(cid, cpw);
		
		// 아이디 없음
		if(paySvc.payCid(cid)==null) {
			System.out.println("ID 없음");
			model.addAttribute("result", "no_id");
			return "reservation/payLogin";
		} 
		// 아이디 있음
		else {
			// 비밀번호 불일치
			System.out.println("ID확인 완료");
		
			if(paySvc.payLogin(cl)==null) {
				System.out.println("PW 불일치");
				model.addAttribute("result", "wrong_pw");
				return "reservation/payLogin";
			} //비밀번호 
			// 가격 정보 넘기기
			else {
				System.out.println("PW 확인 완료");
				session = req.getSession();
	
				//세션으로 예약정보 객체가져오기
				Reserve reserve = (Reserve)session.getAttribute("reserve");
				// 객체에 cid값 넣기
				reserve.setCid(cid);
				
				// 객체에 저장된 상품코드 값 가져오기
				String tcode = reserve.getTcode();
				int tprice = paySvc.priceInfo(tcode);

				// 가격정보 뷰로 보내기
				model.addAttribute("tprice", tprice);
				return "reservation/payInfo";
			}
		}

	}


	@RequestMapping(value="/payInfo", method=RequestMethod.POST)
	public String payInfo(HttpServletRequest req, @RequestParam("cardco") String cardco, 
			@RequestParam("cardno") String pcardno,
			@RequestParam("expiredate") String expiredate, 
			@RequestParam("cvcno") String pcvcno, 
			@RequestParam("price") String tprice, ModelMap model) {
		
		// 타입변환
		long cardno = Long.parseLong(pcardno);
		int cvcno = Integer.parseInt(pcvcno);
		int price = Integer.parseInt(tprice);
		// 예약 날짜 
		LocalDate now = LocalDate.now();
		String chargedate = String.valueOf(now);
		System.out.println("chargedate:"+chargedate);
		expiredate = expiredate+"-01";
		System.out.println("expiredate:"+expiredate);
		
		// 결제번호 생성
		// 중대 오류 발생 - 누군가 결제하는데 결제가 안끝났는데 
		//                  다른 사람이 결제하려고 시도하면
		//                  같은 번호로로 결제번호가 생성됨.
		CreatePid cp = new CreatePid(cardco, chargedate);
		String pid = paySvc.createPid(cp);
		System.out.println("pid:" +pid);
		System.out.println("결제번호 생성 완료");
		
		
		// 결제 정보 채워넣기
		Pay pay = new Pay(pid, cardco, chargedate, expiredate, cardno, cvcno, price, 'N');
		// 결제 정보 DB에 넣기
		int payInfo = paySvc.payInfo(pay);
		System.out.println("결제정보 입력 완료");

		//세션으로 예약정보 객체가져오기
		session = req.getSession();
		Reserve reserve = (Reserve)session.getAttribute("reserve");
		reserve.setPid(pid);
		
		if(payInfo==1) {
			//ctrl->view
			System.out.println("결제 완료");
			// 완료 예약정보 DB에 집어넣기
			int rcnt = reserveSvc.reserveInfo(reserve);
			System.out.println(rcnt);
			if(rcnt==1) {
				System.out.println("예약정보 입력완료");
				//예약완료 정보 가져오기
				String tcode = reserve.getTcode();
				
				System.out.println(tcode+":tcode가져오기 성공");
				HotelInfo hInfo = paySvc.completeInfo(tcode);
				model.addAttribute("hname", hInfo.getHname());
				model.addAttribute("location", hInfo.getLocation());
				model.addAttribute("rid", reserve.getRid());
				model.addAttribute("rdate", reserve.getRdate());
				model.addAttribute("tprice", price);
			//세션 예약 정보 객체 소멸
			session.removeAttribute("reserve");
			return "reservation/reserveConfirm";
			} else {
				System.out.println("예약정보 입력실패");
				return "reservation/payInfo";
			}
			
		
			
		} else {
			System.out.println("결제 처리 중 오류 발생");
			model.addAttribute("result", "Fail");
			return "reservation/payInfo";
		}
		
	}
	
}
