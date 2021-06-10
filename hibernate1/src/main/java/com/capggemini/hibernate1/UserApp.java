package com.capggemini.hibernate1;

import com.capggemini.hibernate1.dao.RegisterDao;
import com.capggemini.hibernate1.entity.UserRegistration;

public class UserApp {

	public static void main(String[] args) {
		UserRegistration registration = new UserRegistration();
		registration.setId(120L);
		registration.setUserName("Karthik Gowd");
		registration.setEmail("karthik@gmail.com");
		registration.setMobileNumber("1234567890");
		registration.setPassword("Keepitup");
		RegisterDao registerDao = new RegisterDao();
		registerDao.saveUser(registration);

	}

}
