package mcgill.ca.ecse321.group6backend.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mcgill.ca.ecse321.group6backend.model.User;

@Repository
public class UserRepository {
	
	@Autowired
	EntityManager eManager;
	
	@Transactional
	public User createUser(String name, String phone, int role, String pwd, String repwd) {
		User user = new User(name,phone,role,pwd);
		eManager.persist(user);
		return user;
	}
	
	@Transactional
	public User getUser(String phone, int role, String pwd) {	
		Query query = eManager.createQuery("from User where phone = "+phone);
		User user = (User) query.getResultList().get(0);
		if (pwd.equals(user.getPwd())&&role==user.getRole()) {
			return user;
		} else {
			return null;
		}
	}
}
