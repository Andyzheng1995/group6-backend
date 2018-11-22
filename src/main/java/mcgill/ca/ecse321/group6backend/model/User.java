package mcgill.ca.ecse321.group6backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	private int id;
	private String name;
	private String phone;
	private String pwd;
	// 0 for admin, 1 for driver, 2 for passenger
	private int role;
	private boolean currentTrip = false;
	private int currentTripId;
	private double score = 4;
	private int totalNo = 0;
	
	public User() {}
	
	public User(String name, String phone, int role, String pwd) {
		this.name = name;
		this.phone = phone;
		this.pwd = pwd;
		this.role = role;
	}
	
	@Id
	@Column(name="id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="phone")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name="pwd")
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Column(name="role")
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	@Column(name="current_at_trip")
	public boolean getCurrentAtTrip() {
		return currentTrip;
	}
	public void setCurrentAtTrip(boolean currentTrip) {
		this.currentTrip = currentTrip;
	}
	@Column(name="current_trip_id")
	public int getCurrentTripId() {
		return currentTripId;
	}
	public void setCurrentTripId(int currentTripId) {
		this.currentTripId = currentTripId;
	}
	@Column(name="score")
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Column(name="total_no")
	public int getTotalNo() {
		return totalNo;
	}
	public void setTotalNo(int totalNo) {
		this.totalNo = totalNo;
	}
	
	
}
