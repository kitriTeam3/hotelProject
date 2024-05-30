package hotelReservation.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import hotelReservation.dto.CustomerLogin;
import hotelReservation.dto.CustomerSignUp;
import hotelReservation.dto.EmpLogin;
import hotelReservation.dto.HotelLogin;
import hotelReservation.svc.impl.LoginSvc;

@Controller
public class LoginController {

	@Autowired
	LoginSvc loginSvc;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String requestLoginPage() {
		return "login/loginform";
	}
	
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
			mv.setViewName("login/success");
			
		}
		else {
			mv.setViewName("login/loginform");
		}
		return mv;
	}
	
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
	
	@RequestMapping(value = "/csignup", method = RequestMethod.GET)
	public String requestcsignup() {
		return "login/csignupform";
	}
	
	@RequestMapping(value = "/cidCheck", method = RequestMethod.POST)
	public int cidCheck(@RequestParam("cid") String cid) {
		int result = loginSvc.cidCheck(cid);
		return result;
	}
	@RequestMapping(value = "/esignup", method = RequestMethod.GET)
	public String requestesignup() {
		return "login/esignupform";
	}
	@RequestMapping(value = "/hsignup", method = RequestMethod.GET)
	public String requesthsignup() {
		return "login/hsignupform";
	}
	@RequestMapping(value = "/csignupctrl")
	public String cSignUpCtrl(@RequestParam("cid") String cid,
							@RequestParam("cpw") String cpw,
							@RequestParam("cname") String cname,
							@RequestParam("firstname") String firstname,
							@RequestParam("lastname") String lastname,
							@RequestParam("cmail") String cmail,
							@RequestParam("cphone") String cphone) {
		
		CustomerSignUp csu = new CustomerSignUp(cid, cpw, cname, firstname, lastname, cmail, cphone);
		int result = loginSvc.cSignUp(csu);
		System.out.println(result);
		return "login/loginform";
	}
}
