package dev.athmer.repositories;

import java.sql.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.athmer.models.US_Cases_Deaths;

@Repository
public interface I_US_Cases_Deaths_Repository extends CrudRepository<US_Cases_Deaths, Integer> {
	US_Cases_Deaths findByFipsAndThedate(int fips, Date thedate);

}
