package com.Repository;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.dto.User;

@Repository
public class UserRepository {

	public void saveUser(User user) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
	}
	
	public List<User> getUsers() {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		String hql ="from User";
		Query query = session.createQuery(hql);
		return query.list();
	}
	
	public User getUsersById(int id) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
	 String hql="from User where id=:e";
	 Query query = session.createQuery(hql);
	 query.setParameter("e",id);
	
	return (User) query.uniqueResult();
	
}
}
