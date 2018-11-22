package mcgill.ca.ecse321.group6backend.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mcgill.ca.ecse321.group6backend.model.Users;

@Repository
public class UsersRepository {
	
	@Autowired
	EntityManager eManager;
	
	@Transactional
	public Users createUser(String name, String phone, int role, String pwd, String repwd) {
		Users users = new Users(name,phone,role,pwd);
		eManager.persist(users);
		return users;
	}
	
	@Transactional
	public Users getUser(String phone, int role, String pwd) {
		Users users = new Users();
		users = eManager.find(Users.class, phone);
		if (pwd.equals(users.getPwd())&&role==users.getRole()) {
			return users;
		} else {
			return null;
		}
	}
}
