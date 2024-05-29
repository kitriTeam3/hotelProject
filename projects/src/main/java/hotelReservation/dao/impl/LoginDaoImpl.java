package hotelReservation.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hotelReservation.dto.CustomerLogin;
import hotelReservation.dto.CustomerSignUp;
import hotelReservation.dto.EmpLogin;
import hotelReservation.dto.EmployeeSignUp;
import hotelReservation.dto.HotelLogin;
import hotelReservation.dto.HotelSignUp;
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
	public CustomerSignUp cMyinfo(String cid) {
		// TODO Auto-generated method stub
		return null;
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
	public HotelSignUp hMyinfo(String hid) {
		// TODO Auto-generated method stub
		return null;
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
	public EmployeeSignUp eMyinfo(String eid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int eSignUp(EmployeeSignUp esu) {
		int count = sqlSessionTemplate.insert("login.eSignUp", esu);
		return count;
	}

}
