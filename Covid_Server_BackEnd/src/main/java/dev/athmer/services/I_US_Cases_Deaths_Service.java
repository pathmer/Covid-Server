package dev.athmer.services;

import java.util.List;

import dev.athmer.models.US_Cases_Deaths;

public interface I_US_Cases_Deaths_Service {
	
	public US_Cases_Deaths getUS_Cases_DeathsById(int id);
	public List<US_Cases_Deaths> getAllUS_Cases_Deaths();
	public US_Cases_Deaths addUS_Cases_Deaths(US_Cases_Deaths uscd);
	public boolean updateUS_Cases_Deaths(US_Cases_Deaths uscd);
	public boolean deleteUS_Cases_Deaths(US_Cases_Deaths uscd);

}
