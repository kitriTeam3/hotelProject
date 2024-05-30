package hotelReservation.controller.reservation;

import java.time.LocalDate;
import java.util.List;

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
import hotelReservation.dto.MyReserve;
import hotelReservation.dto.Reserve;
import hotelReservation.svc.reservation.PaySvc;
import hotelReservation.svc.reservation.ReserveSvc;


@Controller
public class ReserveCtrl {
 
	@Autowired
	private ReserveSvc reserveSvc; 
	@Autowired
	private PaySvc paySvc;
	
	@Autowired
	private HttpSession session;
	
	// 로그인 예약자 정보 가져오기(ctrl->view)
	@RequestMapping(value="/getMemberInfo")
	public String customerInfo(HttpServletRequest req, ModelMap model) {
		

		// 세션에 저장된 고객아이디 가져오기
		session = req.getSession();
		String cid = (String) session.getAttribute("cid");
		System.out.println("고객 아이디 확인");
		System.out.println(cid);
		
		// 세션 예약 객체 정보에 고객 아이디 값 넣기 
		Reserve reserve = (Reserve) session.getAttribute("reserve");
		reserve.setCid(cid);
		
		// 세션 객체 값 다시 전달
		session.setAttribute("reserve", reserve);
		
		// 고객아이디를 통해 고객 정보 가져오기
		CustomerInfo cInfo = reserveSvc.customerInfo(cid);
		System.out.println("고객 정보 확인");
		model.addAttribute("cInfo", cInfo);
		
		return "reservation/mReserveInfo";
	}
	
	

	// 로그인 예약자 정보 작성값 가져오기(view->ctrl)
	@RequestMapping(value="/mReserveInfo", method= RequestMethod.POST)
	public String mReserveInfo(HttpServletRequest req, @RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname,
			@RequestParam("email") String email,
			@RequestParam("confirm") String confirm,
			@RequestParam("country") String country,
			@RequestParam("request") String request, ModelMap model) {
		
		// 이메일 재확인 일치
		if(confirm.equals(email)) {
			
			// 예약 날짜 
			LocalDate now = LocalDate.now();
			String rdate = String.valueOf(now);
			
			// 예약번호 생성
			// 중대 오류 발생 - 누군가 예약하는데 예약이 안끝났는데 
			//                  다른 사람이 예약하려고 시도하면
			//                  같은 번호로로 예약번호가 생성됨.
			CreateRid cr = new CreateRid(country, rdate);
			String rid = reserveSvc.createRid(cr);

			//세션으로 예약정보 값 저장
			session = req.getSession();
			session.setAttribute("rid", rid);
			System.out.println("rid 생성완료");
			// 세션정보값 가져오기	
			Reserve reserve = (Reserve)session.getAttribute("reserve");
			// 예약 객체 정보 채워넣기
			reserve.setRid(rid);
			reserve.setRdate(rdate);
			reserve.setFirstname(firstname);
			reserve.setLastname(lastname);
			reserve.setEmail(email);
			reserve.setCountry(country);
			reserve.setRequest(request);					
					
			// SERVER - 예약 정보 값 확인
			System.out.println(reserve.toString());
			
			// 예약 정보 객체 세션에 다시 주기 
			session.setAttribute("reserve", reserve);
			
			// 객체에 저장된 상품코드 값 가져오기
			String tcode = reserve.getTcode();
			int tprice = paySvc.priceInfo(tcode);
			// 가격정보 뷰로 보내기
			model.addAttribute("tprice", tprice);
			
			// 결제 페이지로 바로 넘어감
			return "reservation/payInfo";
		} 
		// 이메일 재확인 불일치
		else {
			session = req.getSession();
			String cid = (String) session.getAttribute("cid");
			CustomerInfo cInfo = reserveSvc.customerInfo(cid);
			System.out.println("고객 정보 확인");
			model.addAttribute("cInfo", cInfo);
			model.addAttribute("check", "N");
			return "reservation/mReserveInfo";
		}
	}
	
	
	// 로그인 안한 예약자 정보 작성값 가져오기(view->ctrl)
	@RequestMapping(value="/nReserveInfo", method= RequestMethod.POST)
	public String nReserveInfo(HttpServletRequest req, @RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname,
			@RequestParam("email") String email,
			@RequestParam("confirm") String confirm,
			@RequestParam("country") String country,
			@RequestParam("request") String request, ModelMap model) {
		
		if(confirm.equals(email)) {
			// 예약 날짜 
			LocalDate now = LocalDate.now();
			String rdate = String.valueOf(now);

			// 예약번호 생성
			// 중대 오류 발생 - 누군가 예약하는데 예약이 안끝났는데 
			//                  다른 사람이 예약하려고 시도하면
			//                  같은 번호로로 예약번호가 생성됨.
			CreateRid cr = new CreateRid(country, rdate);
			String rid = reserveSvc.createRid(cr);

			//세션으로 예약정보 값 저장
			session = req.getSession();
			session.setAttribute("rid", rid);
			System.out.println("rid 생성완료");
			// 세션정보값 가져오기	
			Reserve reserve = (Reserve)session.getAttribute("reserve");
			// 예약 객체 정보 채워넣기
			reserve.setRid(rid);
			reserve.setRdate(rdate);
			reserve.setFirstname(firstname);
			reserve.setLastname(lastname);
			reserve.setEmail(email);
			reserve.setCountry(country);
			reserve.setRequest(request);					
					
			// SERVER - 예약 정보 값 확인
			System.out.println(reserve.toString());
			
			// 예약 정보 객체 세션에 다시 주기 
			session.setAttribute("reserve", reserve);
			
			// 결제 전 로그인 페이지로 가기
			return "reservation/payLogin";	
		}
		// 이메일이 일치하지 않을 경우 안넘어감.
		else {
			model.addAttribute("fstname", firstname);
			model.addAttribute("lstname", lastname);
			model.addAttribute("cmail", email);
			model.addAttribute("check", "N");
			return "reservation/nReserveInfo";
		}
	}


	// 고객 내 예약 조회(ctrl->view)
	@RequestMapping(value="/myBook")
	public String myReservationPage(HttpServletRequest req, ModelMap model) {
	
		// 세션에 저장된 고객아이디 가져오기
		String cid = (String) session.getAttribute("cid");
		// 로그인 안해서 조회불가능
		if(cid==null) {
			return "reservation/myReservation";
		}
		//로그인 예약조회 가능
		else {
			List<MyReserve> myReservation = reserveSvc.myReservation(cid);
			model.addAttribute("List", myReservation);
		
			return "reservation/myReservation";
		}

	}
	
	// 고객 예약 취소 (view->ctrl)
	@RequestMapping(value="/myReservation", method= RequestMethod.POST)
	public String nReserveInfo(HttpServletRequest req, 
			@RequestParam("cancel") String rid,  ModelMap model) {
		if(rid!=null) {
			//예약취소여부 확인
			model.addAttribute("check", "check");
			
			System.out.println("예약취소번호:"+rid);
			//결제 번호 가져오기
			String pid = paySvc.cancelPid(rid);
			System.out.println("결제취소번호:"+pid);
			// 예약내역, 결제내역 동시 취소
			int bookCancel = reserveSvc.cancel(rid);
			if(bookCancel==1) {
				System.out.println("예약취소 완료");
				//결제 취소
				int payCancel = paySvc.cancel(pid);
				if(payCancel==1) {
					
					System.out.println("결제취소 완료");
					// 취소완료된 예약내역 재전송
					String cid = (String) session.getAttribute("cid");
					List<MyReserve> myReservation = reserveSvc.myReservation(cid);
					model.addAttribute("List", myReservation);
					
				} else {
					System.out.println("결제취소 오류");
				}
				
			} else {
				System.out.println("예약취소 오류");
			}
		}
		

		return "reservation/myReservation";
	}
	
	
	// 호텔 고객 예약 페이지
	@RequestMapping(value="/hotelBook")
	public String hotelBook() {
		return "reservation/cReservation";
	}
	
	
	// 호텔 고객 예약 조회 (view->ctrl)
	@RequestMapping(value="/cReservation", method= RequestMethod.POST)
	public String nReserveInfo(
			@RequestParam("search") String search, @RequestParam("cid") String cid,
			@RequestParam("rid") String rid, @RequestParam("month") String mdate,
			@RequestParam("date") String rdate, ModelMap model) {
		
		List<Reserve> bookList;
		//라디오 값 체크
		System.out.println("검색방법"+search);
		// 고객아이디 검색
		if(search.equals("1")) {
			System.out.println("고객아이디:"+cid);
			bookList = reserveSvc.bookByCustomer(cid);
			model.addAttribute("bookList", bookList);
		}  
		// 예약아이디 검색
		else if (search.equals("2")) {
			System.out.println("예약아이디:"+rid);
			bookList = reserveSvc.bookById(rid);
			model.addAttribute("bookList", bookList);
		} 
		// 년월 검색
		else if (search.equals("3")) {
			System.out.println("날짜:"+mdate);
			mdate= mdate+"-01";
			bookList = reserveSvc.bookByMonth(mdate);
			model.addAttribute("bookList", bookList);
		} 
		//년월일 검색
		else if (search.equals("4")) {
			System.out.println("날짜:"+rdate);
			bookList = reserveSvc.bookByDate(rdate);
			model.addAttribute("bookList", bookList);
		}

		return "reservation/cReservation";
	}
	

	
}
