package dev.athmer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.athmer.models.US_County;
import dev.athmer.repositories.I_US_Counties_Repository;

@Service
public class US_Counties_Service implements I_US_Counties_Service {
	
	private I_US_Counties_Repository uscr;
	
	@Autowired
	public US_Counties_Service(I_US_Counties_Repository uscr) { // Like Dependency Injection in Angular
		this.uscr = uscr;
	}
	

	@Override
	public US_County getUS_CountyById(int id) {
		return uscr.findById(id).get();
	}

	@Override
	public List<US_County> getAllUS_County() {
		return (List<US_County>) uscr.findAll();
	}

	@Override
	public US_County addUS_County(US_County usc) {
		return uscr.save(usc);
	}

	@Override
	public boolean updateUS_County(US_County usc) {
		try {
			uscr.save(usc);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteUS_County(US_County usc) {
		try {
			uscr.delete(usc);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
