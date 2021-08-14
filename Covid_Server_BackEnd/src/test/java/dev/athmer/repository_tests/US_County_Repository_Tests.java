package dev.athmer.repository_tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dev.athmer.models.US_County;
import dev.athmer.repositories.US_Counties_Hibernate;

public class US_County_Repository_Tests {
	private US_Counties_Hibernate usch = new US_Counties_Hibernate();

@Test
public void getAll_US_County_Test() {
	
	List<US_County> us_counties = new ArrayList<US_County>();
	US_County a1 = new US_County(1,1001,"AL","Autauga County",55869);
	US_County a2 = new US_County(2,1003,"AL","Baldwin County",223234);
	US_County a3 = new US_County(3,1005,"AL","Barbour County",24686);
	US_County a4 = new US_County(4,1007,"AL","Bibb County",22394);
	US_County a5 = new US_County(5,1009,"AL","Blount County",57826);

	us_counties.add(a1);
	us_counties.add(a2);
	us_counties.add(a3);
	us_counties.add(a4);
	us_counties.add(a5);

	List<US_County> test = new ArrayList<US_County>();
	test = usch.getAll();
	Assert.assertEquals(us_counties, test);
	
	System.out.println(test);
	
}

@Test
public void get_US_County_ByIdTest() {
	
	US_County a2 = new US_County(2, 1003, "AL", "Baldwin County", 223234);
	
	System.out.println(a2);
	US_County test = usch.getById(2);
	System.out.println(test);
	
	Assert.assertEquals(a2, test);
}

@Test
public void add_US_County_Test() {
	
	US_County a6 = new US_County(1011,"AL","Bullock County",10101);
	
	System.out.println(a6);
	usch.add(a6);
	Assert.assertEquals(a6, usch.getById(6));
	
	System.out.println(usch.getById(6));
	
}

@Test
public void update_US_County_Test() {
	
	US_County a6 = new US_County(6, 1011,"AL","Bullock County",10102);
	
	System.out.println(a6);
	usch.update(a6);

	Assert.assertEquals(a6, usch.getById(6));
	System.out.println(usch.getById(6));
	
}

@Test
public void delete_US_County_Test() {
	
	US_County a6 = new US_County(6, 1011,"AL","Bullock County",10102);
	
	usch.delete(a6);

	System.out.println(usch.getById(6));
	Assert.assertEquals(null,  usch.getById(6));
}

//@Test
//public void getByStatusTest() {
//	
//	List<US_County> accounts = new ArrayList<US_County>();
//	US_County a3 = new US_County(3, 3, "savings", 0.0, "pending", 2);
//	US_County a5 = new US_County(5, 5, "savings", 0.0, "pending", 3);
//
//	accounts.add(a3);
//	accounts.add(a5);
//
//
//	Assert.assertEquals(accounts, usch.getByAstatus("pending"));
//	
//	System.out.println(usch.getByAstatus("pending"));
//	
//}
//
//@Test
//public void getUserAccountsTest() {
//	
//	List<US_County> accounts = new ArrayList<US_County>();
//	US_County a4 = new US_County(4, 4, "checking", 300.0, "active", 3);
//	US_County a5 = new US_County(5, 5, "savings", 0.0, "pending", 3);
//
//	accounts.add(a4);
//	accounts.add(a5);
//
//
//	Assert.assertEquals(accounts, usch.getByUser(3));
//	
//	System.out.println(usch.getByUser(3));
//	
//}
//
//@Test
//public void getAccountByAccNumberTest() {
//	
//	US_County a2 = new US_County(2, 2, "checking", 650.0, "active", 2);
//	
//	System.out.println(a2);
//	System.out.println(usch.getByAccNumber(2));
//	
//	Assert.assertEquals(a2, usch.getById(2));
//}
//
}
