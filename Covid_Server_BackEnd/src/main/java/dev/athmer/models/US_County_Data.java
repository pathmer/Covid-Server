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

@Entity(name="us_county_data")
@Table(name="us_county_data")
public class US_County_Data {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="us_county_data_id_seq")
	@Column(name="id", insertable=false, updatable=false)
	private int id;
	private Date thedate;
	private int fips;
	private int active_cases;
	private int active_cases_week;
	private int deaths_week;
	private int active_cases_permil;
	private int active_cases_week_permil;
	private int deaths_permil;
	private int deaths_week_permil;
	
	@ManyToOne(targetEntity = US_County.class)
	@JoinColumn(name="us_counties")
	private US_County us_counties;

	
	public US_County_Data() {
		super();
	}

	public US_County_Data(int id, Date thedate, int fips, int active_cases, int active_cases_week, int deaths_week,
			int active_cases_permil, int active_cases_week_permil, int deaths_permil, int deaths_week_permil,
			US_County us_counties) {
		super();
		this.id = id;
		this.thedate = thedate;
		this.fips = fips;
		this.active_cases = active_cases;
		this.active_cases_week = active_cases_week;
		this.deaths_week = deaths_week;
		this.active_cases_permil = active_cases_permil;
		this.active_cases_week_permil = active_cases_week_permil;
		this.deaths_permil = deaths_permil;
		this.deaths_week_permil = deaths_week_permil;
		this.us_counties = us_counties;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + active_cases;
		result = prime * result + active_cases_permil;
		result = prime * result + active_cases_week;
		result = prime * result + active_cases_week_permil;
		result = prime * result + deaths_permil;
		result = prime * result + deaths_week;
		result = prime * result + deaths_week_permil;
		result = prime * result + fips;
		result = prime * result + id;
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
		US_County_Data other = (US_County_Data) obj;
		if (active_cases != other.active_cases)
			return false;
		if (active_cases_permil != other.active_cases_permil)
			return false;
		if (active_cases_week != other.active_cases_week)
			return false;
		if (active_cases_week_permil != other.active_cases_week_permil)
			return false;
		if (deaths_permil != other.deaths_permil)
			return false;
		if (deaths_week != other.deaths_week)
			return false;
		if (deaths_week_permil != other.deaths_week_permil)
			return false;
		if (fips != other.fips)
			return false;
		if (id != other.id)
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

	public int getFips() {
		return fips;
	}

	public void setFips(int fips) {
		this.fips = fips;
	}

	public int getActive_cases() {
		return active_cases;
	}

	public void setActive_cases(int active_cases) {
		this.active_cases = active_cases;
	}

	public int getActive_cases_week() {
		return active_cases_week;
	}

	public void setActive_cases_week(int active_cases_week) {
		this.active_cases_week = active_cases_week;
	}

	public int getDeaths_week() {
		return deaths_week;
	}

	public void setDeaths_week(int deaths_week) {
		this.deaths_week = deaths_week;
	}

	public int getActive_cases_permil() {
		return active_cases_permil;
	}

	public void setActive_cases_permil(int active_cases_permil) {
		this.active_cases_permil = active_cases_permil;
	}

	public int getActive_cases_week_permil() {
		return active_cases_week_permil;
	}

	public void setActive_cases_week_permil(int active_cases_week_permil) {
		this.active_cases_week_permil = active_cases_week_permil;
	}

	public int getDeaths_permil() {
		return deaths_permil;
	}

	public void setDeaths_permil(int deaths_permil) {
		this.deaths_permil = deaths_permil;
	}

	public int getDeaths_week_permil() {
		return deaths_week_permil;
	}

	public void setDeaths_week_permil(int deaths_week_permil) {
		this.deaths_week_permil = deaths_week_permil;
	}

	public US_County getUs_counties() {
		return us_counties;
	}

	public void setUs_counties(US_County us_counties) {
		this.us_counties = us_counties;
	}

	
	@Override
	public String toString() {
		return "US_County_Data [id=" + id + ", thedate=" + thedate + ", fips=" + fips + ", active_cases=" + active_cases
				+ ", active_cases_week=" + active_cases_week + ", deaths_week=" + deaths_week + ", active_cases_permil="
				+ active_cases_permil + ", active_cases_week_permil=" + active_cases_week_permil + ", deaths_permil="
				+ deaths_permil + ", deaths_week_permil=" + deaths_week_permil + ", us_counties=" + us_counties + "]";
	}
}
