package hotelReservation.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public String cLogin(CustomerLogin cl) {
		
		return sqlSessionTemplate.selectOne("login.cLogin", cl);
	}

	@Override
	public CustomerMyinfo cMyinfo(String cid) {
		
		return sqlSessionTemplate.selectOne("login.cMyinfo", cid);
	}

	@Override
	public int cSignUp(CustomerSignUp csu) {
		int count = sqlSessionTemplate.insert("login.cSignUp", csu);
		return count;
	}
	
	@Override
	public int cidCheck(String cid) {
		return sqlSessionTemplate.selectOne("login.cidCheck", cid);
	}
	
	@Override
	public int eidCheck(String eid) {
		return sqlSessionTemplate.selectOne("login.eidCheck", eid);
	}
	
	@Override
	public int hidCheck(String hid) {
		return sqlSessionTemplate.selectOne("login.cidCheck", hid);
	}

	@Override
	public String hLogin(HotelLogin hl) {
		
		return sqlSessionTemplate.selectOne("login.hLogin", hl);
	}

	@Override
	public HotelMyinfo hMyinfo(String hid) {
		
		return sqlSessionTemplate.selectOne("login.hMyinfo", hid);
	}

	@Override
	public int hSignUp(HotelSignUp hsu) {
		int count = sqlSessionTemplate.insert("login.hSignUp", hsu);
		return count;
	}

	@Override
	public String eLogin(EmpLogin el) {
		
		return sqlSessionTemplate.selectOne("login.eLogin", el);
	}

	@Override
	public EmployeeMyinfo eMyinfo(String eid) {
		
		return sqlSessionTemplate.selectOne("login.eMyinfo", eid);
	}

	@Override
	public int eSignUp(EmployeeSignUp esu) {
		int count = sqlSessionTemplate.insert("login.eSignUp", esu);
		return count;
	}
	
	@Override
	public int updateCustomer(UpdateCus uc) {
		
		return sqlSessionTemplate.update("login.updateCustomer", uc);
	}
	
	@Override
	public int updateEmployee(UpdateEmp ue) {
		
		return sqlSessionTemplate.update("login.updateEmployee", ue);
	}
	
	@Override
	public int updateHotel(UpdateHotel uh) {
		
		return sqlSessionTemplate.update("login.updateHotel", uh);
	}

}
