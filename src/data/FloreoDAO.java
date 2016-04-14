package data;

public class FloreoDAO {

	public Floreo getFloreoById(int id);
	public Floreo getFloreoByFname(String fname);
	public Floreo getFloreoByLname(String lname);
	public void addFloreo(Floreo floreo);
}
