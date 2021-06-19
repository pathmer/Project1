package dev.athmer.project1.beans;

public class FormData {
	private Integer id;
	private Integer startDate;
	private Integer times;
	private String locations;
	private String description;
	private Double costs;
	private String gradeFormat;
	private String eventType;
	private String justification;
	private Integer missedWorkhrsperwk;
	private Integer requests;
	
	
	public FormData() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FormData(Integer id, Integer startDate, Integer times, String locations, String description, Double costs,
			String gradeFormat, String eventType, String justification, Integer missedWorkhrsperwk, Integer requests) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.times = times;
		this.locations = locations;
		this.description = description;
		this.costs = costs;
		this.gradeFormat = gradeFormat;
		this.eventType = eventType;
		this.justification = justification;
		this.missedWorkhrsperwk = missedWorkhrsperwk;
		this.requests = requests;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStartDate() {
		return startDate;
	}
	public void setStartDate(Integer startDate) {
		this.startDate = startDate;
	}
	public Integer getTimes() {
		return times;
	}
	public void setTimes(Integer times) {
		this.times = times;
	}
	public String getLocations() {
		return locations;
	}
	public void setLocations(String locations) {
		this.locations = locations;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getCosts() {
		return costs;
	}
	public void setCosts(Double costs) {
		this.costs = costs;
	}
	public String getGradeFormat() {
		return gradeFormat;
	}
	public void setGradeFormat(String gradeFormat) {
		this.gradeFormat = gradeFormat;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	public Integer getMissedWorkhrsperwk() {
		return missedWorkhrsperwk;
	}
	public void setMissedWorkhrsperwk(Integer missedWorkhrsperwk) {
		this.missedWorkhrsperwk = missedWorkhrsperwk;
	}
	public Integer getRequests() {
		return requests;
	}
	public void setRequests(Integer requests) {
		this.requests = requests;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((costs == null) ? 0 : costs.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((eventType == null) ? 0 : eventType.hashCode());
		result = prime * result + ((gradeFormat == null) ? 0 : gradeFormat.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((justification == null) ? 0 : justification.hashCode());
		result = prime * result + ((locations == null) ? 0 : locations.hashCode());
		result = prime * result + ((missedWorkhrsperwk == null) ? 0 : missedWorkhrsperwk.hashCode());
		result = prime * result + ((requests == null) ? 0 : requests.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((times == null) ? 0 : times.hashCode());
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
		FormData other = (FormData) obj;
		if (costs == null) {
			if (other.costs != null)
				return false;
		} else if (!costs.equals(other.costs))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (eventType == null) {
			if (other.eventType != null)
				return false;
		} else if (!eventType.equals(other.eventType))
			return false;
		if (gradeFormat == null) {
			if (other.gradeFormat != null)
				return false;
		} else if (!gradeFormat.equals(other.gradeFormat))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (justification == null) {
			if (other.justification != null)
				return false;
		} else if (!justification.equals(other.justification))
			return false;
		if (locations == null) {
			if (other.locations != null)
				return false;
		} else if (!locations.equals(other.locations))
			return false;
		if (missedWorkhrsperwk == null) {
			if (other.missedWorkhrsperwk != null)
				return false;
		} else if (!missedWorkhrsperwk.equals(other.missedWorkhrsperwk))
			return false;
		if (requests == null) {
			if (other.requests != null)
				return false;
		} else if (!requests.equals(other.requests))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (times == null) {
			if (other.times != null)
				return false;
		} else if (!times.equals(other.times))
			return false;
		return true;
	}


	
	
	@Override
	public String toString() {
		return "FormData [id=" + id + ", startDate=" + startDate + ", times=" + times + ", locations=" + locations
				+ ", description=" + description + ", costs=" + costs + ", gradeFormat=" + gradeFormat + ", eventType="
				+ eventType + ", justification=" + justification + ", missedWorkhrsperwk=" + missedWorkhrsperwk
				+ ", requests=" + requests + "]";
	}
	
}
