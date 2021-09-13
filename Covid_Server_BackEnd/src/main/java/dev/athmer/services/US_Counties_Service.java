package dev.athmer.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.athmer.models.US_County;
import dev.athmer.repositories.I_US_Counties_Repository;

@Service
public class US_Counties_Service implements I_US_Counties_Service {
	
	private I_US_Counties_Repository uscr;
	
	@Autowired
	public US_Counties_Service(I_US_Counties_Repository uscr) {
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
	
	public boolean add_special_cases() {
		
		List<String[]> l = new ArrayList<String[]>();
		l.add(new String[] {"99001", "MO", "Joplin", "51762"});
		l.add(new String[] {"99002", "MO1", "Jasper County and Joplin", "121328"});
		l.add(new String[] {"99003", "MO", "Kansas City", "508090"});
		l.add(new String[] {"99004", "MO1", "Jackson County and Kansas City", "703011"});		
		l.add(new String[] {"99005", "NY", "New York City", "8336817"});
		l.add(new String[] {"2997", "AK", "Bristol Bay plus Lake and Peninsula", "2428"});
		l.add(new String[] {"2998", "AK", "Yakutat plus Hoonah-Angoon", "2727"});
		l.add(new String[] {"69000", "MP", "Northern Mariana Islands", "53883"});
		l.add(new String[] {"69110", "MP", "Saipan", "48220"});
		l.add(new String[] {"69120", "MP", "Tinian", "3136"});
		l.add(new String[] {"69100", "MP", "Rota", "2527"});
		l.add(new String[] {"78000", "VI", "Virgin Islands", "105870"});
		l.add(new String[] {"78010", "VI", "St. Croix", "50601"});
		l.add(new String[] {"78020", "VI", "St. John", "4170"});
		l.add(new String[] {"78030", "VI", "St. Thomas", "51634"});
		l.add(new String[] {"66000", "GU", "Guam", "167294"});
		l.add(new String[] {"66010", "GU", "Guam", "167294"});
		l.add(new String[] {"60000", "AS", "American Samoa", "68200"});
		l.add(new String[] {"60050", "AS", "Tutuila", "55876"});
		l.add(new String[] {"60020", "AS", "Manuʻa District", "1143"});
		
		for (int i = 0; i < l.size(); i++) {
			US_County usc = uscr.findByFips(Integer.valueOf(l.get(i)[0]));
	        if (usc == null) {
	        	US_County uscNew = new US_County();
	        	uscNew.setFips(Integer.valueOf(l.get(i)[0]));
	        	uscNew.setState(l.get(i)[1]);
	        	uscNew.setCounty(l.get(i)[2]);
	        	uscNew.setPopulation(Integer.valueOf(l.get(i)[3]));
	        	uscr.save(uscNew);
	        }
		}
		
		return true;
	}

}
