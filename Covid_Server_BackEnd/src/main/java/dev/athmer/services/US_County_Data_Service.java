package dev.athmer.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.athmer.models.US_Cases_Deaths;
import dev.athmer.models.US_County_Data;
import dev.athmer.repositories.I_US_Cases_Deaths_Repository;
import dev.athmer.repositories.I_US_Counties_Repository;
import dev.athmer.repositories.I_US_County_Data_Repository;

@Service
public class US_County_Data_Service implements I_US_County_Data_Service {

	private I_US_Cases_Deaths_Repository uscdthr;
	private I_US_Counties_Repository uscr;
	private I_US_County_Data_Repository uscdatar;
	private I_US_Cases_Deaths_Service uscdths;
	
	@Autowired
	public US_County_Data_Service(
			I_US_Cases_Deaths_Repository uscdthr,
			I_US_Counties_Repository uscr,
			I_US_County_Data_Repository uscdatar,
			I_US_Cases_Deaths_Service uscdths) {
		this.uscdthr = uscdthr;
		this.uscr = uscr;
		this.uscdatar = uscdatar;
		this.uscdths = uscdths;
	}


	@Override
	public US_County_Data getUS_County_DataById(int id) {
		return null;
	}

	@Override
	public List<US_County_Data> getAllUS_County_Data() {
		return null;
	}

	@Override
	public US_County_Data addUS_County_Data(US_County_Data uscd) {
		return null;
	}

	@Override
	public boolean updateUS_County_Data(US_County_Data uscd) {
		return false;
	}

	@Override
	public boolean deleteUS_County_Data(US_County_Data uscd) {
		return false;
	}
	
	public Boolean createCounty_Data_Table() {
		
		List<US_Cases_Deaths> allUS_Cases_Deaths = uscdths.getAllUS_Cases_Deaths();
		for (int i = 0; i < allUS_Cases_Deaths.size(); i++) {
			int pop = allUS_Cases_Deaths.get(i).getUs_counties().getPopulation();		
			Date minus18days = Date.valueOf(allUS_Cases_Deaths.get(i).getThedate().toLocalDate().minusDays(18));
			Date minus7daysCDth = Date.valueOf(allUS_Cases_Deaths.get(i).getThedate().toLocalDate().minusDays(7));
			Date minus7daysCData = Date.valueOf(allUS_Cases_Deaths.get(i).getThedate().toLocalDate().minusDays(7));
			
			US_Cases_Deaths oldUS_CDth18 = uscdthr.findByFipsAndThedate(allUS_Cases_Deaths.get(i).getFips(), minus18days);
	        if (oldUS_CDth18 == null) {
	        	oldUS_CDth18 = new US_Cases_Deaths();
	        	oldUS_CDth18.setCases(0);
	        }
	        US_Cases_Deaths oldUS_CDth7 = uscdthr.findByFipsAndThedate(allUS_Cases_Deaths.get(i).getFips(), minus7daysCDth);
	        if (oldUS_CDth7 == null) {
	        	oldUS_CDth7 = new US_Cases_Deaths();
	        	oldUS_CDth7.setDeaths(0);
	        }
	        US_County_Data oldUS_CData7 = uscdatar.findByFipsAndThedate(allUS_Cases_Deaths.get(i).getFips(), minus7daysCData);
	        if (oldUS_CData7 == null) {
	        	oldUS_CData7 = new US_County_Data();
	        	oldUS_CData7.setActive_cases(0);
			}
			
			US_County_Data uscdataNew = new US_County_Data();
			uscdataNew.setThedate(allUS_Cases_Deaths.get(i).getThedate());
			uscdataNew.setFips(allUS_Cases_Deaths.get(i).getFips());
			uscdataNew.setActive_cases(allUS_Cases_Deaths.get(i).getCases() - oldUS_CDth18.getCases());
			uscdataNew.setActive_cases_week(uscdataNew.getActive_cases() - oldUS_CData7.getActive_cases());
			uscdataNew.setDeaths_week(allUS_Cases_Deaths.get(i).getDeaths() - oldUS_CDth7.getDeaths());
			uscdataNew.setActive_cases_permil(1000000 * uscdataNew.getActive_cases() / pop);
			uscdataNew.setActive_cases_week_permil(1000000 * uscdataNew.getActive_cases_week() / pop);
			uscdataNew.setDeaths_permil(1000000 * allUS_Cases_Deaths.get(i).getDeaths() / pop);
			uscdataNew.setDeaths_week_permil(1000000 * uscdataNew.getDeaths_week() / pop);
			uscdataNew.setUs_counties(allUS_Cases_Deaths.get(i).getUs_counties());
			
			uscdatar.save(uscdataNew);
		}
		return true;
	}
}
