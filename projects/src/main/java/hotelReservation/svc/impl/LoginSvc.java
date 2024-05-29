package hotelReservation.svc.impl;

import java.util.Map;

import org.springframework.validation.Errors;

import hotelReservation.dto.CustomerLogin;
import hotelReservation.dto.CustomerSignUp;
import hotelReservation.dto.EmpLogin;
import hotelReservation.dto.EmployeeSignUp;
import hotelReservation.dto.HotelLogin;
import hotelReservation.dto.HotelSignUp;

public interface LoginSvc {

	String cLogin(CustomerLogin cl);
	CustomerSignUp cMyinfo(String cid);
	int cSignUp(CustomerSignUp csu);
	int cidCheck(String cid);
	int eidCheck(String eid);
	int hidCheck(String hid);
	String hLogin(HotelLogin hl);
	HotelSignUp hMyinfo(String hid);
	int hSignUp(HotelSignUp hsu);
	String eLogin(EmpLogin el);
	EmployeeSignUp eMyinfo(String eid);
	int eSignUp(EmployeeSignUp esu);
	Map<String, String> validateHandling(Errors errors);
}
