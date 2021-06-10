package com.capggemini.hibernate1.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.capgemini.dto.UserDto;
import com.capggemini.hibernate1.entity.UserRegistration;

public class RegisterDao {

	
	
	public void  saveUser(UserRegistration userRegistration)
	{
		Configuration	cfg=new Configuration();
		   cfg.configure();
		   SessionFactory sessionFactory=cfg.buildSessionFactory();
		   Session session=sessionFactory.openSession();
		   Transaction transaction = session.beginTransaction();
		   session.save(userRegistration);
		   
		   transaction.commit();
	}
	public   UserRegistration getUserbyId(Long id) {
		
		Configuration	cfg=new Configuration();
		   cfg.configure();
		   SessionFactory sessionFactory=cfg.buildSessionFactory();
		   Session session=sessionFactory.openSession();
		   return session.get(UserRegistration.class, id);
	}
	public void updateuserDetailsByid(Long id,UserDto userdto)
	{
		UserRegistration userRegistration=getUserbyId(id);
		if(userRegistration!=null)
		{
			userRegistration.setEmail(userdto.getEmail());
			userRegistration.setPassword(userdto.getPassword());
			userRegistration.setUserName(userdto.getUserName());
			userRegistration.setMobileNumber(userdto.getMobileNumber());
			
			Configuration	cfg=new Configuration();
			   cfg.configure();
			   SessionFactory sessionFactory=cfg.buildSessionFactory();
			   Session session=sessionFactory.openSession();
			   Transaction transaction = session.beginTransaction();
			   session.save(userRegistration);
			   session.update(userRegistration);
			   
			   transaction.commit();
		}
		else
		{
			System.out.println("No records present from this id"+id);
		}
	}
}
