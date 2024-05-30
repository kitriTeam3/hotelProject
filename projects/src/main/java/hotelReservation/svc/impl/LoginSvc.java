package hotelReservation.svc.impl;

import java.util.Map;

import org.springframework.validation.Errors;

import hotelReservation.dto.CustomerLogin;
import hotelReservation.dto.CustomerMyinfo;
import hotelReservation.dto.CustomerSignUp;
import hotelReservation.dto.EmpLogin;
import hotelReservation.dto.EmployeeMyinfo;
import hotelReservation.dto.EmployeeSignUp;
import hotelReservation.dto.HotelLogin;
import hotelReservation.dto.HotelMyinfo;
import hotelReservation.dto.HotelSignUp;
import hotelReservation.dto.UpdateCus;
import hotelReservation.dto.UpdateEmp;
import hotelReservation.dto.UpdateHotel;

public interface LoginSvc {

	String cLogin(CustomerLogin cl);
	CustomerMyinfo cMyinfo(String cid);
	int cSignUp(CustomerSignUp csu);
	int cidCheck(String cid);
	int eidCheck(String eid);
	int hidCheck(String hid);
	String hLogin(HotelLogin hl);
	HotelMyinfo hMyinfo(String hid);
	int hSignUp(HotelSignUp hsu);
	String eLogin(EmpLogin el);
	EmployeeMyinfo eMyinfo(String eid);
	int eSignUp(EmployeeSignUp esu);
	Map<String, String> validateHandling(Errors errors);
	int updateCustomer(UpdateCus uc);
	int updateEmployee(UpdateEmp ue);
	int updateHotel(UpdateHotel uh);
}
