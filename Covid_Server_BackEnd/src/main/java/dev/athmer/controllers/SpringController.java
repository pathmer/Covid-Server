package dev.athmer.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.athmer.models.US_County;
import dev.athmer.services.US_Counties_Service;

@RestController
@RequestMapping("/US_Counties")
// @CrossOrigin()

public class SpringController {
	
	private US_Counties_Service uscServ;
	
	@Autowired
	public SpringController(US_Counties_Service uscServ) {
		this.uscServ = uscServ;
	}
	
//	@RequestMapping(method=RequestMethod.GET, path="/US_Counties")
//	public ResponseEntity<List<US_County>> getAllUS_County() {
//		
//	}
	
	// http://localhost:8080/Covid_Server_BackEnd/US_Counties
	
	@GetMapping()
	public ResponseEntity<List<US_County>> getAllUS_County() {
		List<US_County> uscounties = uscServ.getAllUS_County();
		return ResponseEntity.ok(uscounties);
	}
	
	// http://localhost:8080/Covid_Server_BackEnd/US_Counties/10
	
	@GetMapping(path="/{id}") // because of our @RequestMapping annotation at the top... this is equal to => @GetMapping("/US_Counties/{id}")
	public ResponseEntity<US_County> getUS_CountyById(@PathVariable("id") int id) {
		US_County usc = uscServ.getUS_CountyById(id);
		return ResponseEntity.ok(usc);
		
	}
	
	@PostMapping
	public ResponseEntity<US_County> addUS_County(@RequestBody US_County usc) { // I want to acknowledge that a new Cat and endpoint have been created. 
		US_County uscounty = uscServ.addUS_County(usc);
		return ResponseEntity.created(URI.create("http://localhost:8080/CatAppSpringWeb/cats/" + uscounty.getId())).build();
		// TODO add comment re what we're doing here
	}
	

}