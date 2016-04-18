package data;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class FloreoFileDAO implements FloreoDAO {

	private static final String FILE_NAME = "/WEB-INF/floreo.csv";
	//private List<Floreo> floreos = new ArrayList<>();
	
	private HashMap<Integer, Floreo> floreosMap = new HashMap<Integer, Floreo>();
	/*
	 * Use Autowired to have Spring inject an instance of an ApplicationContext
	 * into this object after creation. We will use the ApplicationContext to
	 * retrieve an InputStream so we can read from a file.
	 */
	@Autowired
	private ApplicationContext ac;

	/*
	 * The @PostConstruct method is called by Spring after object creation and
	 * dependency injection
	 */
		
	@PostConstruct
	public void init() {
		// Retrieve an input stream from the application context
		// rather than directly from the file system
		try (InputStream is = ac.getResource(FILE_NAME).getInputStream();
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));) {
			String line = buf.readLine();
			while ((line = buf.readLine()) != null) {
				String[] tokens = line.split(",");
				String identifier = tokens[0];
				int id = Integer.parseInt(identifier);
				String fname = tokens[1];
				String lname = tokens[2];
				String city = tokens[3];
				String neighborhood = tokens[4];
				String latitude = tokens[5];
				String longitude = tokens[6];
				String jobsNumber = tokens[7];
				int jobsNum = Integer.parseInt(jobsNumber);
				String motto = tokens[8];
				
				Floreo f = new Floreo(id, fname, lname, city, neighborhood, latitude, longitude, jobsNum, motto);
				
				floreosMap.put(id, f);
				
				//floreos.add(new Floreo(id, fname, lname, city, neighborhood, latitude, longitude, jobsNum, motto));
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public ArrayList<Floreo> getAllFloreos(){
		ArrayList<Floreo> floreosList = new ArrayList<Floreo>();
		for (Map.Entry entry : floreosMap.entrySet()){
			floreosList.add((Floreo) entry.getValue());
		}
		return floreosList;
	}
	
	@Override
	public Floreo getFloreoById(int id) {
//		Floreo fl = null;
//		
//		for (Map.Entry entry : floreos.entrySet()){
//		
//			if (entry.getKey().equals(id)) {
//				System.out.println("Something is happening with hashmaps (ref id)");
//				//fl = floreos;
//				break;
//			}
		return floreosMap.get(id);
		}
		
//		for (Floreo floreo : floreos) {
//			// System.out.println(state.getId());
//			if (floreo.getId() == id) {
//				fl = floreo;
//				break;
//			}
//		}

	
	
	@Override
	public Floreo getFloreoByFname(String fname) {
		Floreo fl = null;
		for (Map.Entry entry : floreosMap.entrySet()){
			if(floreosMap.get(entry.getKey()).getFname().equals(fname)){
				System.out.println("Something is happening with hashmaps (ref fname)");	
				fl = floreosMap.get(entry.getKey());
				break;
			}
		}	
//		for (Floreo floreo : floreos) {	
//			if(floreo.getFname().equalsIgnoreCase(fname)){
//				fl = floreo;
//				break;
//			}
//		}
		return fl;
	}
	@Override
	public Floreo getFloreoByLname(String lname) {
		Floreo fl = null;
		for (Map.Entry entry : floreosMap.entrySet()){
			if(floreosMap.get(entry.getKey()).getLname().equals(lname)){
				fl = floreosMap.get(entry.getKey());
				break;
				//System.out.println("Something is happening with hashmaps (ref lname)");	
			}
		}
//		for (Floreo floreo : floreos) {
//			if (floreo.getLname().equalsIgnoreCase(lname)) {
//				fl = floreo;
//				break;
//			}
//		}
		return fl;
	}

	@Override
	public void addFloreo(Floreo floreo) {
		floreosMap.put(floreo.getId(), floreo);      
	}
	
	public void deleteFloreo(Floreo floreo){
		System.out.println("Delete Trial" + floreo);
//		floreosMap.remove(floreo.getId(), floreo);
		floreosMap.remove(floreo.getId());
		
	}
	
}
