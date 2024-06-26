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

import hotelReservation.dto.CreateRid;
import hotelReservation.dto.CustomerInfo;
import hotelReservation.dto.Reserve;
import hotelReservation.svc.reservation.ReserveSvc;



@Controller
public class ReserveCtrl {
 
	@Autowired
	private ReserveSvc reserveSvc; 
	private HttpSession session;
	
	// 로그인 예약자 정보 가져오기(ctrl->view)
	@RequestMapping(value="/mReserveInfo")
	public ModelMap customerInfo(HttpServletRequest req) {
		
		ModelMap model = new ModelMap();

		// 세션에 저장된 고객아이디 가져오기
		session = req.getSession();
		String cid = (String) session.getAttribute("cid");
	
		// 고객아이디를 통해 고객 정보 가져오기
		CustomerInfo cInfo = reserveSvc.customerInfo(cid);
		model.addAttribute("cInfo", cInfo);
		
		return model;
	}
	
	
	// 로그인 예약자 정보 작성값 가져오기(view->ctrl)
	@RequestMapping(value="/mReserveInfo", method=RequestMethod.POST)
	public String mReserveInfo(@RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname,
			@RequestParam("cmail") String cmail,
			@RequestParam("confirm") String confirm,
			@RequestParam("country") String country,
			@RequestParam("request") String request, ModelMap model) {
		
		if(confirm.equals(cmail)) {
			
			return "reservation/payInfo";
		} else {
			model.addAttribute("check", "N");
			return "reservation/mReserveInfo";
		}
	}
	
	
	// 로그인 안한 예약자 정보 작성값 가져오기(view->ctrl)
	@RequestMapping(value="/nReserveInfo", method=RequestMethod.POST)
	public String nReserveInfo(HttpServletRequest req, @RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname,
			@RequestParam("cmail") String email,
			@RequestParam("confirm") String confirm,
			@RequestParam("country") String country,
			@RequestParam("request") String request, ModelMap model) {
		
		if(confirm.equals(email)) {
			
			model = new ModelMap();
			LocalDate now = LocalDate.now();
			String rdate = String.valueOf(now);

			// 세션정보값 가져오기
			// 상품코드, 체크인, 체크아웃, 인원수
			session = req.getSession();
			String tcode = (String) session.getAttribute("tcode");
			String checkin = (String) session.getAttribute("checkin");
			String checkout = (String) session.getAttribute("checkout");
			int person = (Integer) session.getAttribute("person");
	
			// 예약번호 생성
			// 중대 오류 발생 - 누군가 예약하는데 예약이 안끝났는데 
			//                  다른 사람이 예약하려고 시도하면
			//                  같은 번호로로 예약번호가 생성됨.
			CreateRid cr = new CreateRid(country, rdate);
			String rid = reserveSvc.createRid(cr);
			
			Reserve reserve = new Reserve(rid, rdate, firstname, lastname, 
					email, country, request, 
					checkin, checkout, person, 'N', tcode);

			// 예약 작성 정보 DB에 입력
			reserveSvc.reserveInfo(reserve);
			return "reservation/payInfo";
			
		} else {
			
			model = new ModelMap();
			model.addAttribute("check", "N");
			return "로그인페이지";
		}
	}
	
	
	
}
