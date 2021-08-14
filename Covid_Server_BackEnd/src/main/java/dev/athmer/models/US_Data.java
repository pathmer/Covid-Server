package dev.athmer.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="us_data")
@Table(name="us_data")
public class US_Data {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Date the_date;
	private int cases;
	private int deaths;
	private int fully_vaccinated;
	private int hospitalizations;
	
	@ManyToOne(targetEntity = US_County.class)
	@JoinColumn(name="us_counties")
	private US_County us_counties;

	
	public US_Data() {
		super();
		// TODO Auto-generated constructor stub
	}

	public US_Data(int id, Date the_date, int cases, int deaths, int fully_vaccinated, int hospitalizations,
			US_County us_counties) {
		super();
		this.id = id;
		this.the_date = the_date;
		this.cases = cases;
		this.deaths = deaths;
		this.fully_vaccinated = fully_vaccinated;
		this.hospitalizations = hospitalizations;
		this.us_counties = us_counties;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cases;
		result = prime * result + deaths;
		result = prime * result + fully_vaccinated;
		result = prime * result + hospitalizations;
		result = prime * result + id;
		result = prime * result + ((the_date == null) ? 0 : the_date.hashCode());
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
		US_Data other = (US_Data) obj;
		if (cases != other.cases)
			return false;
		if (deaths != other.deaths)
			return false;
		if (fully_vaccinated != other.fully_vaccinated)
			return false;
		if (hospitalizations != other.hospitalizations)
			return false;
		if (id != other.id)
			return false;
		if (the_date == null) {
			if (other.the_date != null)
				return false;
		} else if (!the_date.equals(other.the_date))
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

	public Date getThe_date() {
		return the_date;
	}

	public void setThe_date(Date the_date) {
		this.the_date = the_date;
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

	public int getFully_vaccinated() {
		return fully_vaccinated;
	}

	public void setFully_vaccinated(int fully_vaccinated) {
		this.fully_vaccinated = fully_vaccinated;
	}

	public int getHospitalizations() {
		return hospitalizations;
	}

	public void setHospitalizations(int hospitalizations) {
		this.hospitalizations = hospitalizations;
	}

	public US_County getUs_counties() {
		return us_counties;
	}

	public void setUs_counties(US_County us_counties) {
		this.us_counties = us_counties;
	}

	
	@Override
	public String toString() {
		return "US_Data [id=" + id + ", the_date=" + the_date + ", cases=" + cases + ", deaths=" + deaths
				+ ", fully_vaccinated=" + fully_vaccinated + ", hospitalizations=" + hospitalizations + ", us_counties="
				+ us_counties + "]";
	}
}
