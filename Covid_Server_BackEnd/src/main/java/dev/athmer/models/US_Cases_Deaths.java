package dev.athmer.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="us_cases_deaths")
@Table(name="us_cases_deaths")
public class US_Cases_Deaths {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="us_cases_deaths_id_seq")
	@Column(name="id", insertable=false, updatable=false)
	private int id;
	private Date thedate;
	private String county;
	private String state;
	private int fips;
	private int cases;
	private int deaths;
	
	@ManyToOne(targetEntity = US_County.class)
	@JoinColumn(name="us_counties")
	private US_County us_counties;

	public US_Cases_Deaths() {
		super();
	}

	public US_Cases_Deaths(int id, Date thedate, String county, String state, int fips, int cases, int deaths,
			US_County us_counties) {
		super();
		this.id = id;
		this.thedate = thedate;
		this.county = county;
		this.state = state;
		this.fips = fips;
		this.cases = cases;
		this.deaths = deaths;
		this.us_counties = us_counties;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cases;
		result = prime * result + ((county == null) ? 0 : county.hashCode());
		result = prime * result + deaths;
		result = prime * result + fips;
		result = prime * result + id;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((thedate == null) ? 0 : thedate.hashCode());
		result = prime * result + ((us_counties == null) ? 0 : us_counties.hashCode());
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
		US_Cases_Deaths other = (US_Cases_Deaths) obj;
		if (cases != other.cases)
			return false;
		if (county == null) {
			if (other.county != null)
				return false;
		} else if (!county.equals(other.county))
			return false;
		if (deaths != other.deaths)
			return false;
		if (fips != other.fips)
			return false;
		if (id != other.id)
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (thedate == null) {
			if (other.thedate != null)
				return false;
		} else if (!thedate.equals(other.thedate))
			return false;
		if (us_counties == null) {
			if (other.us_counties != null)
				return false;
		} else if (!us_counties.equals(other.us_counties))
			return false;
		return true;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getThedate() {
		return thedate;
	}

	public void setThedate(Date thedate) {
		this.thedate = thedate;
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

	public int getFips() {
		return fips;
	}

	public void setFips(int fips) {
		this.fips = fips;
	}

	public int getCases() {
		return cases;
	}

	public void setCases(int cases) {
		this.cases = cases;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public US_County getUs_counties() {
		return us_counties;
	}

	public void setUs_counties(US_County us_counties) {
		this.us_counties = us_counties;
	}

	
	@Override
	public String toString() {
		return "US_Cases_Deaths [id=" + id + ", thedate=" + thedate + ", county=" + county + ", state=" + state
				+ ", fips=" + fips + ", cases=" + cases + ", deaths=" + deaths + ", us_counties=" + us_counties + "]";
	}

}
