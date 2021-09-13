package dev.athmer.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLException;

import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.athmer.models.US_Cases_Deaths;
import dev.athmer.models.US_County;
import dev.athmer.repositories.I_US_Cases_Deaths_Repository;
import dev.athmer.repositories.I_US_Counties_Repository;

@Service
public class US_Cases_Deaths_Service implements I_US_Cases_Deaths_Service {
	
	private I_US_Cases_Deaths_Repository uscdthr;
	private I_US_Counties_Repository uscr;
	
	@Autowired
	public US_Cases_Deaths_Service(I_US_Cases_Deaths_Repository uscdthr, I_US_Counties_Repository uscr) {
		this.uscdthr = uscdthr;
		this.uscr = uscr;
	}

	@Override
	public US_Cases_Deaths getUS_Cases_DeathsById(int id) {
		return uscdthr.findById(id).get();
	}

	@Override
	public List<US_Cases_Deaths> getAllUS_Cases_Deaths() {
		return (List<US_Cases_Deaths>) uscdthr.findAll();
	}

	@Override
	public US_Cases_Deaths addUS_Cases_Deaths(US_Cases_Deaths uscdth) {
		return uscdthr.save(uscdth);
	}

	@Override
	public boolean updateUS_Cases_Deaths(US_Cases_Deaths uscdth) {
		try {
			uscdthr.save(uscdth);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteUS_Cases_Deaths(US_Cases_Deaths uscdth) {
		try {
			uscdthr.delete(uscdth);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addAllUS_Cases_Deaths() {
		int count = 0;
		int maxTries = 50;
		try {
			String url = "https://raw.githubusercontent.com/nytimes/covid-19-data/master/us-counties.csv";
			InputStream input = new URL(url).openStream();
            InputStreamReader isr = new InputStreamReader(input,
                    StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            String[] elements = new String[6];
            String line;
            Boolean header = true;
            Map<String, Integer> map = new HashMap<String, Integer>() {{put("Alabama", 1000); put("Alaska", 2000); put("Arizona", 4000);
            	put("Arkansas", 5000); put("California", 6000); put("Colorado", 8000); put("Connecticut", 9000); put("Delaware", 10000);
            	put("District of Columbia", 11000); put("Florida", 12000); put("Georgia", 13000); put("Hawaii", 15000); put("Idaho", 16000);
            	put("Illinois", 17000); put("Indiana", 18000); put("Iowa", 19000); put("Kansas", 20000); put("Kentucky", 21000); put("Louisiana", 22000);
            	put("Maine", 23000); put("Maryland", 24000); put("Massachusetts", 25000); put("Michigan", 26000); put("Minnesota", 27000);
            	put("Mississippi", 28000); put("Missouri", 29000); put("Montana", 30000); put("Nebraska", 31000); put("Nevada", 32000);
            	put("New Hampshire", 33000); put("New Jersey", 34000); put("New Mexico", 35000); put("New York", 36000); put("North Carolina", 37000);
            	put("North Dakota", 38000); put("Ohio", 39000); put("Oklahoma", 40000); put("Oregon", 41000); put("Pennsylvania", 42000);
            	put("Rhode Island", 44000); put("South Carolina", 45000); put("South Dakota", 46000); put("Tennessee", 47000); put("Texas", 48000);
            	put("Utah", 49000); put("Vermont", 50000); put("Virginia", 51000); put("Washington", 53000); put("West Virginia", 54000);
            	put("Wisconsin", 55000); put("Wyoming", 56000); put("American Samoa", 60000); put("Guam", 66000);
            	put("Northern Mariana Islands", 69000); put("Puerto Rico", 72000); put("Virgin Islands", 78000);
            }};
            
            while ((line = br.readLine()) != null) {
            	if (header == true) {
            		header = false;
            		continue;
            	}
            	elements = line.split(",");
            	Date date1 = Date.valueOf(elements[0]);
            	Date date2 = Date.valueOf("2021-09-10");
            	if (date1.compareTo(date2) == -1) {
            		continue;
            	}
            	US_Cases_Deaths uscdth = new US_Cases_Deaths();
	            if ("Unknown".equals(elements[1])) {
	            	uscdth.setFips(map.get(elements[2]));
	            }
	            else if ("Joplin".equals(elements[1])) {
	            	uscdth.setFips(99001);
	            }
	            else if ("Kansas City".equals(elements[1])) {
	            	uscdth.setFips(99003);
	            }
	            else if ("New York City".equals(elements[1])) {
	            	uscdth.setFips(99005);
	            }
	            
	            else {
		            if (elements[3] == "") {
		            	System.out.println(line);
		            	continue;
		            }
		            else {
		            	uscdth.setFips(Integer.parseInt(elements[3]));
		            }
	            }
	            
	            uscdth.setThedate(Date.valueOf(elements[0]));
	            uscdth.setCounty(elements[1]);
	            uscdth.setState(elements[2]);
	            
	            if (elements[4] == "") {
	            	uscdth.setCases(0);
	            }
	            else {
	            	uscdth.setCases(Integer.parseInt(elements[4]));
	            }
	            
	            if (elements.length == 5) {
	            	uscdth.setDeaths(0);
	            }
	            else {
	            	uscdth.setDeaths(Integer.parseInt(elements[5]));
	            }
	            
	            US_County usc = uscr.findByFips(uscdth.getFips());
	            uscdth.setUs_counties(usc);
	            
	            while (true) {
	            	US_Cases_Deaths uscdth2 = uscdthr.findByFipsAndThedate(uscdth.getFips(), uscdth.getThedate());
		            if (uscdth2 != null) {
//		            	break;
		            	uscdth2.setCases(uscdth.getCases());
		            	uscdth2.setDeaths(uscdth.getDeaths());
		            	uscdth2.setUs_counties(uscdth.getUs_counties());
		            	updateUS_Cases_Deaths(uscdth2);
		            }
		            else {
		            	uscdthr.save(uscdth);
		            }
	
	            	if (uscdth.getId() % 1000 == 1) {
	            		System.out.println(uscdth);
	            	}
	            	count = 0;
	            	break;
	            }
            }
            System.out.println("Done");
		}
		catch(SSLException  e) {
			e.printStackTrace();
			if (++count == maxTries) {
				return false;
			}
		}
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
