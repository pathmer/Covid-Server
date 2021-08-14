package dev.athmer.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="us_counties")
@Table(name="us_counties")
public class US_County {
	
	@Id
	@Column(name="id", insertable=false, updatable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int fips;
	private String state;
	private String county;
	private int population;
	
	
	public US_County() {
		super();
		// TODO Auto-generated constructor stub
	}

	public US_County(int id, int fips, String state, String county, int population) {
		super();
		this.id = id;
		this.fips = fips;
		this.county = county;
		this.state = state;
		this.population = population;
	}

	
	public US_County(int fips, String state, String county, int population) {
		super();
		this.fips = fips;
		this.county = county;
		this.state = state;
		this.population = population;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((county == null) ? 0 : county.hashCode());
		result = prime * result + fips;
		result = prime * result + id;
		result = prime * result + population;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		US_County other = (US_County) obj;
		if (county == null) {
			if (other.county != null)
				return false;
		} else if (!county.equals(other.county))
			return false;
		if (fips != other.fips)
			return false;
		if (id != other.id)
			return false;
		if (population != other.population)
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFips() {
		return fips;
	}

	public void setFips(int fips) {
		this.fips = fips;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	
	@Override
	public String toString() {
		return "US_County [id=" + id + ", fips=" + fips + ", state=" + state + ", county=" + county + ", population="
				+ population + "]";
	}
}
