package mcgill.ca.ecse321.group6backend.model;

public class Trip {
	
	private Long id;
	private Long driverId;
	private boolean ended;
	private int numOfStops;
	private int currentStop = 0;
	private List<Stop> stops;
	private int seats;
	private double score;
	
	public Trip(Long driverId,int numOfStops,int seats,double score) {
		this.driverId = driverId;
		this.numOfStops = numOfStops;
		this.seats = seats;
		this.score = score;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", updatable = false, nullable = false)
	public Long getId() {
		return id;
	}
	public Long getDriverId() {
		return driverId;
	}
	
	public boolean isEnded() {
		return ended;
	}
	public void setEnded(boolean ended) {
		this.ended = ended;
	}
	
	public int getNumOfStops() {
		return numOfStops;
	}
	
	public int getCurrentStop() {
		return currentStop;
	}
	public void setCurrentStop(int currentStop) {
		this.currentStop = currentStop;
	}
	public List<Stop> getStops() {
		return stops;
	}
	public Stop getStop(int seq_no) {
		return this.stops.get(seq_no);
	}
	public void setStops(List<Stop> stops) {
		this.stops = stops;
	}
	public void changeStop(Stop stop,int seq_no) {
		this.stops.remove(seq_no);
		this.stops.add(seq_no, stop);
	}
	public void removeStop(int seq_no) {
		this.stops.remove(seq_no);
	}
}
