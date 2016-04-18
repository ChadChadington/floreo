package data;

import java.util.ArrayList;

public interface FloreoDAO {

	public Floreo getFloreoByFname(String fname);
	public Floreo getFloreoByLname(String lname);
	public void addFloreo(Floreo floreo);
	
	public ArrayList<Floreo> getAllFloreos();
	
	public Floreo getFloreoById(int id);
	public void deleteFloreo(Floreo floreo);
	//public void editFloreoById(Floreo floreo);

	
	
//	public List<Track> getAllTracks();
}
