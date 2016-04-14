package data;

public class Floreo {
	/*
	 * Define fields
	 */
	private int id;
	private String fname;
	private String lname;
	private String city;
	private String neighborhood;
	private String latitude;
	private String longitude;
	private int jobsNum;
	private String motto;
	
	/*
	 * No args constructor
	 */
	public Floreo(){}
	
	/*
	 * Main constructor
	 */
	public Floreo(int id, String fname, String lname, String city, String neighborhood, String latitude, String longitude, int jobsNum, String motto) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.city= city;
		this.neighborhood = neighborhood;
		this.latitude = latitude;
		this.longitude = longitude;
		this.jobsNum = jobsNum;
		this.motto = motto;
	}
	
	/*
	 * Getters and Setters
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public int getJobsNum() {
		return jobsNum;
	}

	public void setJobsNum(int jobsNum) {
		this.jobsNum = jobsNum;
	}

	public String getMotto() {
		return motto;
	}

	public void setMotto(String motto) {
		this.motto = motto;
	}

	@Override
	public String toString() {
		return "Floreo [id=" + id + ", fname=" + fname + ", lname=" + lname + ", city=" + city + ", neighborhood="
				+ neighborhood + ", latitude=" + latitude + ", longitude=" + longitude + ", jobsNum=" + jobsNum
				+ ", motto=" + motto + "]";
	}

	
	
	
}
