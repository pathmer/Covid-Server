package dev.athmer.services;

import java.util.List;

import dev.athmer.models.US_County;


public interface I_US_Counties_Service {
	
	public US_County getUS_CountyById(int id);
	public List<US_County> getAllUS_County();
	public US_County addUS_County(US_County usc);
	public void updateUS_County(US_County usc);
	public void deleteUS_County(US_County usc);

}
