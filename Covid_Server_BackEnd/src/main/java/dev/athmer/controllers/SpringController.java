package dev.athmer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.athmer.models.US_County;
import dev.athmer.services.US_Cases_Deaths_Service;
import dev.athmer.services.US_Counties_Service;
import dev.athmer.services.US_County_Data_Service;

@RestController
@RequestMapping("/Covid_Server")
@CrossOrigin(origins = {"http://localhost:4200/"})

public class SpringController {
	
	private US_Counties_Service uscserv;
	private US_Cases_Deaths_Service uscdserv;
	private US_County_Data_Service uscdataserv;
	
	@Autowired
	public SpringController(
			US_Counties_Service uscserv,
			US_Cases_Deaths_Service uscdserv,
			US_County_Data_Service uscdataserv) {
		this.uscserv = uscserv;
		this.uscdserv = uscdserv;
		this.uscdataserv = uscdataserv;
	}
	

	// GET -> http://localhost:8080/Covid_Server_BackEnd/US_Counties/
	@GetMapping(path="/US_Counties", produces="application/json")
	public List<US_County> getAllUS_County() {
		return uscserv.getAllUS_County();
	}
	
	// GET -> http://localhost:8080/Covid_Server_BackEnd/US_Counties/9
	@GetMapping(path="/US_Counties/{id}", produces="application/json")
	public US_County getUS_CountyById(@PathVariable("id") int id) {
		return uscserv.getUS_CountyById(id);
	}
	
	// POST -> http://localhost:8080/Covid_Server_BackEnd/add
	@PostMapping(path="/US_Counties/add", consumes="application/json", produces="application/json")
	public US_County addUS_County(@RequestBody US_County usc) {
		return uscserv.addUS_County(usc);
	}
	
	// UPDATE -> http://localhost:8080/Covid_Server_BackEnd/US_Counties/7
	@PutMapping(path="/US_Counties/{id}", consumes="application/json", produces="application/json")
	public Boolean updateUS_County(@PathVariable("id") int id, @RequestBody US_County usc) {
		return uscserv.updateUS_County(usc);
	}
	
	// DELETE -> http://localhost:8080/Covid_Server_BackEnd/US_Counties/4
	@DeleteMapping(path="/US_Counties/{id}", consumes="application/json", produces="application/json")
	public Boolean deleteUS_County(@PathVariable("id") int id, @RequestBody US_County usc) {
		return uscserv.deleteUS_County(usc);
	}
	
	// GET -> http://localhost:8080/Covid_Server_BackEnd/add_special
	@GetMapping(path="/US_Counties/add_special", produces="application/json")
	public Boolean addSpecial_US_County() {
		return uscserv.add_special_cases();
	}
	
	// GET -> http://localhost:8080/Covid_Server_BackEnd/US_Counties/addAll
	@GetMapping(path="/US_Cases_Deaths/addAll", produces="application/json")
	public Boolean addAllUS_Cases_Deaths() {
		return uscdserv.addAllUS_Cases_Deaths();
	}
	
	// GET -> http://localhost:8080/Covid_Server_BackEnd/US_County_Data/addAll
	@GetMapping(path="/US_County_Data/addAll", produces="application/json")
	public Boolean addAllUS_County_Data() {
		return uscdataserv.createCounty_Data_Table();
	}
}
