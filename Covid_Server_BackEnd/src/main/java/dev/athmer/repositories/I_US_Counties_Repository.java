package dev.athmer.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.athmer.models.US_County;

@Repository
public interface I_US_Counties_Repository extends CrudRepository<US_County, Integer> {
	US_County findByFips(int fips);

}
