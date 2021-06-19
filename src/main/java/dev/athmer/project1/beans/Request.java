package dev.athmer.project1.beans;

public class Request {
	private Integer id;
	private String title;
	private Double reimbursement;
	private String status;
	private String inbox;
	private String destination;
	private Integer datetimestamp;
	private String priority;
	private String ammountexceeded;
	private String exceededreason;
	private String bencoescalated;
	private Integer accounts;
	
	
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Request(Integer id, String title, Double reimbursement, String status, String inbox, String destination,
			Integer datetimestamp, String priority, String ammountexceeded, String exceededreason,
			String bencoescalated, Integer accounts) {
		super();
		this.id = id;
		this.title = title;
		this.reimbursement = reimbursement;
		this.status = status;
		this.inbox = inbox;
		this.destination = destination;
		this.datetimestamp = datetimestamp;
		this.priority = priority;
		this.ammountexceeded = ammountexceeded;
		this.exceededreason = exceededreason;
		this.bencoescalated = bencoescalated;
		this.accounts = accounts;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getReimbursement() {
		return reimbursement;
	}
	public void setReimbursement(Double reimbursement) {
		this.reimbursement = reimbursement;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getInbox() {
		return inbox;
	}
	public void setInbox(String inbox) {
		this.inbox = inbox;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Integer getDatetimestamp() {
		return datetimestamp;
	}
	public void setDatetimestamp(Integer datetimestamp) {
		this.datetimestamp = datetimestamp;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getAmmountexceeded() {
		return ammountexceeded;
	}
	public void setAmmountexceeded(String ammountexceeded) {
		this.ammountexceeded = ammountexceeded;
	}
	public String getExceededreason() {
		return exceededreason;
	}
	public void setExceededreason(String exceededreason) {
		this.exceededreason = exceededreason;
	}
	public String getBencoescalated() {
		return bencoescalated;
	}
	public void setBencoescalated(String bencoescalated) {
		this.bencoescalated = bencoescalated;
	}
	public Integer getAccounts() {
		return accounts;
	}
	public void setAccounts(Integer accounts) {
		this.accounts = accounts;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accounts == null) ? 0 : accounts.hashCode());
		result = prime * result + ((ammountexceeded == null) ? 0 : ammountexceeded.hashCode());
		result = prime * result + ((bencoescalated == null) ? 0 : bencoescalated.hashCode());
		result = prime * result + ((datetimestamp == null) ? 0 : datetimestamp.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((exceededreason == null) ? 0 : exceededreason.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((inbox == null) ? 0 : inbox.hashCode());
		result = prime * result + ((priority == null) ? 0 : priority.hashCode());
		result = prime * result + ((reimbursement == null) ? 0 : reimbursement.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Request other = (Request) obj;
		if (accounts == null) {
			if (other.accounts != null)
				return false;
		} else if (!accounts.equals(other.accounts))
			return false;
		if (ammountexceeded == null) {
			if (other.ammountexceeded != null)
				return false;
		} else if (!ammountexceeded.equals(other.ammountexceeded))
			return false;
		if (bencoescalated == null) {
			if (other.bencoescalated != null)
				return false;
		} else if (!bencoescalated.equals(other.bencoescalated))
			return false;
		if (datetimestamp == null) {
			if (other.datetimestamp != null)
				return false;
		} else if (!datetimestamp.equals(other.datetimestamp))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (exceededreason == null) {
			if (other.exceededreason != null)
				return false;
		} else if (!exceededreason.equals(other.exceededreason))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inbox == null) {
			if (other.inbox != null)
				return false;
		} else if (!inbox.equals(other.inbox))
			return false;
		if (priority == null) {
			if (other.priority != null)
				return false;
		} else if (!priority.equals(other.priority))
			return false;
		if (reimbursement == null) {
			if (other.reimbursement != null)
				return false;
		} else if (!reimbursement.equals(other.reimbursement))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Request [id=" + id + ", title=" + title + ", reimbursement=" + reimbursement + ", status=" + status
				+ ", inbox=" + inbox + ", destination=" + destination + ", datetimestamp=" + datetimestamp
				+ ", priority=" + priority + ", ammountexceeded=" + ammountexceeded + ", exceededreason="
				+ exceededreason + ", bencoescalated=" + bencoescalated + ", accounts=" + accounts + "]";
	}

}



