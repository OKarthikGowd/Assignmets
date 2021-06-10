package com.capggemini.hibernate1.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.capgemini.dto.Captain;
import com.capgemini.dto.Team;



public class AssosiationDao {

	public void saveTeamDetails(Team team)
	{
	  Configuration	cfg=new Configuration();
	   cfg.configure();
	   SessionFactory sessionFactory=cfg.buildSessionFactory();
	   Session session=sessionFactory.openSession();
	   Transaction transaction = session.beginTransaction();
	   session.save(team);
	   
	   transaction.commit();
	}
	public Captain getCaptianid(Long id)
	{
		Configuration	cfg=new Configuration();
		   cfg.configure();
		   SessionFactory sessionFactory=cfg.buildSessionFactory();
		   Session session=sessionFactory.openSession();
		   return session.get(Captain.class, id);
	}
	public void deleteTeamDetails(Team team)
	{
		Configuration	cfg=new Configuration();
		   cfg.configure();
		   SessionFactory sessionFactory=cfg.buildSessionFactory();
		   Session session=sessionFactory.openSession();
		   Transaction transaction = session.beginTransaction();
		   session.delete(team.getName());
		   transaction.commit();
	}
}
