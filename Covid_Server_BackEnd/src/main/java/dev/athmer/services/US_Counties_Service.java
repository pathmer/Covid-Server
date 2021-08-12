package dev.athmer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.athmer.models.US_County;
import dev.athmer.repositories.US_Counties_Hibernate;

@Service
public class US_Counties_Service implements I_US_Counties_Service {
	
//	@Autowired // Dependency Injection - Field Injection
//	private US_Counties_Hibernate usch;
	
	private US_Counties_Hibernate usch;
	
	// Constructor Injection
	@Autowired
	public US_Counties_Service(US_Counties_Hibernate usch) { // Like Dependency Injection in Angular
		this.usch = usch;
	}
	
//	// Setter Injection
//		@Autowired
//		public void setUS_Counties_Hibernate(US_Counties_Hibernate usch) {
//			this.usch = usch;
//		}

	@Override
	public US_County getUS_CountyById(int id) {
		return usch.getById(id);
	}

	@Override
	public List<US_County> getAllUS_County() {
		return usch.getAll();
	}

	@Override
	public US_County addUS_County(US_County usc) {
		return usch.add(usc);
	}

	@Override
	public void updateUS_County(US_County usc) {
		usch.update(usc);
		
	}

	@Override
	public void deleteUS_County(US_County usc) {
		usch.delete(usc);
		
	}

}
