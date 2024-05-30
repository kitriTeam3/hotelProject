package hotelReservation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Getter;
import lombok.Setter;

@Controller
@Getter
@Setter
public class HomeCtrl {
	
	@RequestMapping(value="/homePage")
	public String home(Model model, HttpServletRequest request) {	
		HttpSession session = request.getSession(false);
		System.out.println(session);
		model.addAttribute("sessionScope", session);
		
		return "main/main";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request) {	
	    HttpSession session = request.getSession();
	    session.invalidate(); 
		
	    return "main/main";
	}
}
