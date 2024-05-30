package hotelReservation.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import hotelReservation.dto.CustomerLogin;
import hotelReservation.dto.CustomerSignUp;
import hotelReservation.dto.EmpLogin;
import hotelReservation.dto.EmployeeSignUp;
import hotelReservation.dto.HotelLogin;
import hotelReservation.dto.HotelSignUp;
import hotelReservation.dto.UpdateCus;
import hotelReservation.svc.impl.LoginSvc;

@Controller
public class LoginController {

	@Autowired
	LoginSvc loginSvc;
	
	// 로그인 페이지 이동
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String requestLoginPage() {
		return "login/loginform";
	}
	
	// 고객 로그인 컨트롤
	@RequestMapping(value = "/cloginctrl", method = RequestMethod.POST)
	public ModelAndView cLoginCtrl(@RequestParam("cid") String cid,
			@RequestParam("cpw") String cpw, HttpSession session) {
		System.out.println(cid + ":" + cpw);
		CustomerLogin cl = new CustomerLogin(cid, cpw);
		String cname = loginSvc.cLogin(cl);
		System.out.println(cname);
		ModelAndView mv = new ModelAndView();
		if(cname != null) {
			session.setAttribute("cid", cid);
			session.setAttribute("cpw", cpw);
			mv.addObject("msg", cname);
			mv.setViewName("login/csuccess");
			
		}
		else {
			mv.setViewName("login/loginform");
		}
		return mv;
	}
	
	// 사원 로그인 컨트롤
	@RequestMapping(value = "/eloginctrl", method = RequestMethod.POST)
	public ModelAndView eLoginCtrl(@RequestParam("eid") String eid,
			@RequestParam("epw") String epw, HttpSession session) {
		System.out.println(eid + ":" + epw);
		EmpLogin el = new EmpLogin(eid, epw);
		String ename = loginSvc.eLogin(el);
		System.out.println(ename);
		ModelAndView mv = new ModelAndView();
		if(ename != null) {
			session.setAttribute("eid", eid);
			session.setAttribute("epw", epw);
			mv.addObject("msg", ename);
			mv.setViewName("login/esuccess");
			
		}
		else {
			mv.setViewName("login/loginform");
		}
		return mv;
	}
	
	// 호텔 로그인 컨트롤
	@RequestMapping(value = "/hloginctrl", method = RequestMethod.POST)
	public ModelAndView hLoginCtrl(@RequestParam("hid") String hid,
			@RequestParam("hpw") String hpw, HttpSession session) {
		System.out.println(hid + ":" + hpw);
		HotelLogin hl = new HotelLogin(hid, hpw);
		String hname = loginSvc.hLogin(hl);
		System.out.println(hname);
		ModelAndView mv = new ModelAndView();
		if(hname != null) {
			session.setAttribute("hid", hid);
			session.setAttribute("hpw", hpw);
			mv.addObject("msg", hname);
			mv.setViewName("login/hsuccess");
			
		}
		else {
			mv.setViewName("login/loginform");
		}
		return mv;
	}
	
	// 고객 회원가입 페이지 이동
	@RequestMapping(value = "/csignup", method = RequestMethod.GET)
	public String requestcsignup() {
		return "login/csignupform";
	}
	
	
	// 고객 회원가입 중복체크
	@RequestMapping(value = "/cidCheck", method = RequestMethod.POST)
	@ResponseBody
	public String cidCheck(@RequestParam("cid") String cid) {
		int result = loginSvc.cidCheck(cid);
		System.out.println(cid +"\n" + result);
		if(result == 1) {
			return "duplicate";
		}
		else {
			return "not_duplicate";
		}
	}
	
	// 사원 회원가입 페이지 이동
	@RequestMapping(value = "/esignup", method = RequestMethod.GET)
	public String requestesignup() {
		return "login/esignupform";
	}
	
	// 사원 회원가입 중복 체크
	@RequestMapping(value = "/eidCheck", method = RequestMethod.POST)
	@ResponseBody
	public String eidCheck(@RequestParam("eid") String eid) {
		int result = loginSvc.eidCheck(eid);
		System.out.println(eid +"\n" + result);
		if(result == 1) {
			return "duplicate";
		}
		else {
			return "not_duplicate";
		}
	}
	
	// 호텔 회원가입 페이지 이동
	@RequestMapping(value = "/hsignup", method = RequestMethod.GET)
	public String requesthsignup() {
		return "login/hsignupform";
	}
	
	// 호텔 회원가입 중복체크
	@RequestMapping(value = "/hidCheck", method = RequestMethod.POST)
	@ResponseBody
	public String hidCheck(@RequestParam("hid") String hid) {
		int result = loginSvc.hidCheck(hid);
		System.out.println(hid +"\n" + result);
		if(result == 1) {
			return "duplicate";
		}
		else {
			return "not_duplicate";
		}
	}
	
	// 고객 회원가입 컨트롤
	@RequestMapping(value = "/csignupctrl")
	public String cSignUpCtrl(
							@RequestParam("cid") String cid,
							@RequestParam("cpw") String cpw,
							@RequestParam("cname") String cname,
							@RequestParam("firstname") String firstname,
							@RequestParam("lastname") String lastname,
							@RequestParam("cmail") String cmail,
							@RequestParam("cphone") String cphone) {
		
		int check = loginSvc.cidCheck(cid);
		if(check == 1) {
			return "login/csignupform";
		}
		else if(check == 0) {
			CustomerSignUp csu = new CustomerSignUp(cid, cpw, cname, firstname, lastname, cmail, cphone);
			int result = loginSvc.cSignUp(csu);
			System.out.println(result);
		}
		
		return "login/loginform";
	}
	
	// 사원 회원가입 컨트롤
	@RequestMapping(value = "/esignupctrl")
	public String eSignUpCtrl(
							@RequestParam("eid") String eid,
							@RequestParam("epw") String epw,
							@RequestParam("ename") String ename,
							@RequestParam("email") String email,
							@RequestParam("ephone") String ephone) {
		
		int check = loginSvc.eidCheck(eid);
		if(check == 1) {
			return "login/esignupform";
		}
		else if(check == 0) {
			EmployeeSignUp esu = new EmployeeSignUp(eid, epw, ename, email, ephone);
			int result = loginSvc.eSignUp(esu);
			System.out.println(result);
		}
		
		return "login/loginform";
	}
	
	// 호텔 회원가입 컨트롤
	@RequestMapping(value = "/hsignupctrl")
	public String hSignUpCtrl(
							@RequestParam("hid") String hid,
							@RequestParam("hpw") String hpw,
							@RequestParam("hname") String hname,
							@RequestParam("grade") String grade,
							@RequestParam("location") String location,
							@RequestParam("hmail") String hmail,
							@RequestParam("hphone") String hphone) {
		
		int check = loginSvc.hidCheck(hid);
		if(check == 1) {
			return "login/hsignupform";
		}
		else if(check == 0) {
			HotelSignUp hsu = new HotelSignUp(hid, hpw, hname, grade, location, hmail, hphone);
			int result = loginSvc.hSignUp(hsu);
			System.out.println(result);
		}
		
		return "login/loginform";
	}
	
	// 고객 정보 조회 후 확인 버튼 누르면 나오는 페이지
	@RequestMapping(value = "/csuccess")
	public String requestCsuccessPage(HttpSession session, Model model) {
		String cid = (String)session.getAttribute("cid");
		String cpw = (String)session.getAttribute("cpw");
		CustomerLogin cl = new CustomerLogin(cid, cpw);
		String cname = loginSvc.cLogin(cl);
		model.addAttribute("msg", cname);
		return "login/csuccess";
	}
		
	// 고객 정보 조회 후 확인 버튼 누르면 나오는 페이지
	@RequestMapping(value = "/esuccess")
	public String requestEsuccessPage(HttpSession session, Model model) {
		String eid = (String)session.getAttribute("eid");
		String epw = (String)session.getAttribute("epw");
		EmpLogin el = new EmpLogin(eid, epw);
		String ename = loginSvc.eLogin(el);
		model.addAttribute("msg", ename);
		return "login/esuccess";
	}
		
	// 호텔 로그인 성공 했을 때 페이지
	@RequestMapping(value = "/hsuccess")
	public String requestHsuccessPage(HttpSession session, Model model) {
		String hid = (String)session.getAttribute("hid");
		String hpw = (String)session.getAttribute("hpw");
		HotelLogin hl = new HotelLogin(hid, hpw);
		String hname = loginSvc.hLogin(hl);
		model.addAttribute("msg", hname);
		return "login/hsuccess";
	}
	
	// 고객 정보 조회
	@RequestMapping(value="/cmyinfoctrl")
	public String cmyinfoctrl(Model model, HttpSession session) {
		
		String cid = (String)session.getAttribute("cid");
		model.addAttribute("cmyinfo", loginSvc.cMyinfo(cid));
		return "login/cmyinfoform";
	}
	
	// 사원 정보 조회 
	@RequestMapping(value="/emyinfoctrl")
	public String emyinfoctrl(Model model, HttpSession session) {
		
		String eid = (String)session.getAttribute("eid");
		model.addAttribute("emyinfo", loginSvc.eMyinfo(eid));
		return "login/emyinfoform";
	}
	
	// 호텔 정보 조회 
	@RequestMapping(value="/hmyinfoctrl")
	public String hmyinfoctrl(Model model, HttpSession session) {
		
		String hid = (String)session.getAttribute("hid");
		model.addAttribute("hmyinfo", loginSvc.hMyinfo(hid));
		return "login/hmyinfoform";
	}
	
	// 로그아웃
	@RequestMapping(value="/logout")
	public String logoutctrl(Model model, HttpSession session) {
		session.invalidate();
		return "login/loginform";
	}
	
	@RequestMapping(value="/updatecustomer")
	public String updateCmyinfo(@RequestParam("cmail") String cmail,
								@RequestParam("cphone") String cphone,
								Model model, HttpSession session) {
		String cid = (String)session.getAttribute("cid");
		UpdateCus uc = new UpdateCus(cid, cmail, cphone);
		int result = loginSvc.updateCustomer(uc);
		System.out.println(result);
		model.addAttribute("uc", uc);
		return "login/cmyinfoform";
		
	}
	
	
}
