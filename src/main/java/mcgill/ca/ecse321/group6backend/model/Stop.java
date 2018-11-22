package mcgill.ca.ecse321.group6backend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Stop {
	
	private int id;
	private String city;
	private int trip_id;
	private int seq_no;
	private double cost;
	private int seats;
	private Date time;
	
	public Stop(String city,int trip_id,int seq_no,double cost,int seats,Date time) {
		this.city = city;
		this.trip_id = trip_id;
		this.seq_no = seq_no;
		this.cost = cost;
		this.seats = seats;
		this.time = time;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", updatable = false, nullable = false)
	public int getId() {
		return id;
	}
	public String getCity() {
		return city;
	}
	public int getTrip_id() {
		return trip_id;
	}
	public int getSeq_no() {
		return seq_no;
	}
	public double getCost() {
		return cost;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public Date getTime() {
		return time;
	}

}
