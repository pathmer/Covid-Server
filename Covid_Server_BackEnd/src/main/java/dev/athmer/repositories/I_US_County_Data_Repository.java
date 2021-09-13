package dev.athmer.repositories;

import java.sql.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.athmer.models.US_County_Data;

@Repository
public interface I_US_County_Data_Repository  extends CrudRepository<US_County_Data, Integer> {
	US_County_Data findByFipsAndThedate(int fips, Date thedate);
}
