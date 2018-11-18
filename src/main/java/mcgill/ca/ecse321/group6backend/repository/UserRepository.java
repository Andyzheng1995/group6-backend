package mcgill.ca.ecse321.group6backend.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mcgill.ca.ecse321.group6backend.model.User;

@Repository
public class UserRepository {
	
	@PersistenceContext
	EntityManager eManager;
	
	@Transactional
	public User createUser(String name) {
		User user = new User();
		user.setName(name);
		eManager.persist(user);
		return user;
	}
	
	@Transactional
	public User getUser(String name) {
		User user = eManager.find(User.class, name);
		return user;
	}
}
