package hotelReservation.svc.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;


import hotelReservation.dao.impl.LoginDao;
import hotelReservation.dto.CustomerLogin;
import hotelReservation.dto.CustomerSignUp;
import hotelReservation.dto.EmpLogin;
import hotelReservation.dto.EmployeeSignUp;
import hotelReservation.dto.HotelLogin;
import hotelReservation.dto.HotelSignUp;
import hotelReservation.svc.impl.LoginSvc;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class LoginSvcImpl implements LoginSvc {

	@Autowired
	LoginDao loginDao;
	
	@Override
	public String cLogin(CustomerLogin cl) {
		String cname = loginDao.cLogin(cl);
		return cname;
	}

	@Override
	public CustomerSignUp cMyinfo(String cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public int cSignUp(CustomerSignUp csu) {
		int count = loginDao.cSignUp(csu);
		return count;
	}
	
	@Override
	public int cidCheck(String cid) {
		int result = loginDao.cidCheck(cid);
		return result;
	}
	
	@Override
	public int eidCheck(String eid) {
		int result = loginDao.eidCheck(eid);
		return result;
	}
	
	@Override
	public int hidCheck(String hid) {
		int result = loginDao.hidCheck(hid);
		return result;
	}

	@Override
	public String hLogin(HotelLogin hl) {
		String hname = loginDao.hLogin(hl);
		return hname;
	}

	@Override
	public HotelSignUp hMyinfo(String hid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public int hSignUp(HotelSignUp hsu) {
		int count = loginDao.hSignUp(hsu);
		return count;
	}

	@Override
	public String eLogin(EmpLogin el) {
		String ename = loginDao.eLogin(el);
		return ename;
	}

	@Override
	public EmployeeSignUp eMyinfo(String eid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public int eSignUp(EmployeeSignUp esu) {
		int count = loginDao.eSignUp(esu);
		return count;
	}
	
	public Map<String, String> validateHandling(Errors errors){
		Map<String, String> validatorResult = new HashMap<>();
		
		for(FieldError error : errors.getFieldErrors()) {
			String validKeyName = String.format("valid_%s", error.getField());
			validatorResult.put(validKeyName, error.getDefaultMessage());
		}
		return validatorResult;
	}

}
