package dev.athmer.services;

import java.util.List;

import dev.athmer.models.US_County_Data;

public interface I_US_County_Data_Service {
	
	public US_County_Data getUS_County_DataById(int id);
	public List<US_County_Data> getAllUS_County_Data();
	public US_County_Data addUS_County_Data(US_County_Data uscd);
	public boolean updateUS_County_Data(US_County_Data uscd);
	public boolean deleteUS_County_Data(US_County_Data uscd);

}
