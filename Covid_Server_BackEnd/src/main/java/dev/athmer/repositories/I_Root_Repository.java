package dev.athmer.repositories;

import java.util.List;

public interface I_Root_Repository <T> {
	
	// CREATE
	public T add (T t);
	
	// READ
	public T getById(int id);
	
	public T getByName(String name);
	
	public List<T> getAll();
	
	// UPDATE
	public void update(T t);
	
	// DELETE
	public void delete(T t);
	

}
