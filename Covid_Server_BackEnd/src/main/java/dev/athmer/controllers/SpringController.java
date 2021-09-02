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
import dev.athmer.services.US_Counties_Service;

@RestController
@RequestMapping(path="/US_Counties")
@CrossOrigin(origins = {"http://localhost:4200/"})

public class SpringController {
	
	private US_Counties_Service uscserv;
	
	@Autowired
	public SpringController(US_Counties_Service uscserv) {
		this.uscserv = uscserv;
	}
	

	// GET -> http://localhost:8080/Covid_Server_BackEnd/US_Counties/
	@GetMapping(produces="application/json")
	public List<US_County> getAllUS_County() {
		return uscserv.getAllUS_County();
	}
	
	// GET -> http://localhost:8080/Covid_Server_BackEnd/US_Counties/9
	@GetMapping(path="/{id}", produces="application/json")
	public US_County getUS_CountyById(@PathVariable("id") int id) {
		return uscserv.getUS_CountyById(id);
	}
	
	// POST -> http://localhost:8080/Covid_Server_BackEnd/add
	@PostMapping(path="/add", consumes="application/json", produces="application/json")
	public US_County addUS_County(@RequestBody US_County usc) {
		return uscserv.addUS_County(usc);
	}
	
	// UPDATE -> http://localhost:8080/Covid_Server_BackEnd/US_Counties/7
	@PutMapping(path="/{id}", consumes="application/json", produces="application/json")
	public Boolean updateUS_County(@PathVariable("id") int id, @RequestBody US_County usc) {
		return uscserv.updateUS_County(usc);
	}
	
	// DELETE -> http://localhost:8080/Covid_Server_BackEnd/US_Counties/4
	@DeleteMapping(path="/{id}", consumes="application/json", produces="application/json")
	public Boolean deleteUS_County(@PathVariable("id") int id, @RequestBody US_County usc) {
		return uscserv.deleteUS_County(usc);
	}
}
