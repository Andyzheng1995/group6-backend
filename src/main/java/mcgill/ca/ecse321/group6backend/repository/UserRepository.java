package mcgill.ca.ecse321.group6backend.repository;

import java.util.List;

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
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Object> getUser(String phone, int role, String pwd) {	
		Query query = eManager.createNativeQuery("select * from users where phone = '5146666666'");
		return query.getResultList();
	}
}
