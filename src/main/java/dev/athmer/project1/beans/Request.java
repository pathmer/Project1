package dev.athmer.project1.beans;

import java.sql.Date;



public class Request {
	private Integer id;
	private String title;
	private Date startDate;
	private Double reimbursement;
	private String status;
	private Integer inbox;
	private Date datetimestamp;
	private String priority;
	private String ammountexceeded;
	private String exceededreason;
	private String bencoescalated;
	private String empapp;
	private String supapp;
	private String msnapp;
	private String dhdapp;
	private String benapp;
	private String denialreason;
	
	private Integer accounts;

	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Request(Integer id, String title, Date startDate, Double reimbursement, String status, Integer inbox,
			Date datetimestamp, String priority, String ammountexceeded, String exceededreason, String bencoescalated,
			String empapp, String supapp, String msnapp, String dhdapp, String benapp, String denialreason,
			Integer accounts) {
		super();
		this.id = id;
		this.title = title;
		this.startDate = startDate;
		this.reimbursement = reimbursement;
		this.status = status;
		this.inbox = inbox;
		this.datetimestamp = datetimestamp;
		this.priority = priority;
		this.ammountexceeded = ammountexceeded;
		this.exceededreason = exceededreason;
		this.bencoescalated = bencoescalated;
		this.empapp = empapp;
		this.supapp = supapp;
		this.msnapp = msnapp;
		this.dhdapp = dhdapp;
		this.benapp = benapp;
		this.denialreason = denialreason;
		this.accounts = accounts;
	}

	public Request(String title, Date startDate, Double reimbursement) {
		super();
		this.title = title;
		this.startDate = startDate;
		this.reimbursement = reimbursement;
	}

	public Request(Integer id) {
		super();
		this.id = id;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
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

	public Integer getInbox() {
		return inbox;
	}

	public void setInbox(Integer inbox) {
		this.inbox = inbox;
	}

	public Date getDatetimestamp() {
		return datetimestamp;
	}

	public void setDatetimestamp(Date datetimestamp) {
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

	public String getEmpapp() {
		return empapp;
	}

	public void setEmpapp(String empapp) {
		this.empapp = empapp;
	}

	public String getSupapp() {
		return supapp;
	}

	public void setSupapp(String supapp) {
		this.supapp = supapp;
	}

	public String getMsnapp() {
		return msnapp;
	}

	public void setMsnapp(String msnapp) {
		this.msnapp = msnapp;
	}

	public String getDhdapp() {
		return dhdapp;
	}

	public void setDhdapp(String dhdapp) {
		this.dhdapp = dhdapp;
	}

	public String getBenapp() {
		return benapp;
	}

	public void setBenapp(String benapp) {
		this.benapp = benapp;
	}

	public String getDenialreason() {
		return denialreason;
	}

	public void setDenialreason(String denialreason) {
		this.denialreason = denialreason;
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
		result = prime * result + ((benapp == null) ? 0 : benapp.hashCode());
		result = prime * result + ((bencoescalated == null) ? 0 : bencoescalated.hashCode());
		result = prime * result + ((datetimestamp == null) ? 0 : datetimestamp.hashCode());
		result = prime * result + ((denialreason == null) ? 0 : denialreason.hashCode());
		result = prime * result + ((dhdapp == null) ? 0 : dhdapp.hashCode());
		result = prime * result + ((empapp == null) ? 0 : empapp.hashCode());
		result = prime * result + ((exceededreason == null) ? 0 : exceededreason.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((inbox == null) ? 0 : inbox.hashCode());
		result = prime * result + ((msnapp == null) ? 0 : msnapp.hashCode());
		result = prime * result + ((priority == null) ? 0 : priority.hashCode());
		result = prime * result + ((reimbursement == null) ? 0 : reimbursement.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((supapp == null) ? 0 : supapp.hashCode());
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
		if (benapp == null) {
			if (other.benapp != null)
				return false;
		} else if (!benapp.equals(other.benapp))
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
		if (denialreason == null) {
			if (other.denialreason != null)
				return false;
		} else if (!denialreason.equals(other.denialreason))
			return false;
		if (dhdapp == null) {
			if (other.dhdapp != null)
				return false;
		} else if (!dhdapp.equals(other.dhdapp))
			return false;
		if (empapp == null) {
			if (other.empapp != null)
				return false;
		} else if (!empapp.equals(other.empapp))
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
		if (msnapp == null) {
			if (other.msnapp != null)
				return false;
		} else if (!msnapp.equals(other.msnapp))
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
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (supapp == null) {
			if (other.supapp != null)
				return false;
		} else if (!supapp.equals(other.supapp))
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
		return "Request [id=" + id + ", title=" + title + ", startDate=" + startDate + ", reimbursement="
				+ reimbursement + ", status=" + status + ", inbox=" + inbox + ", datetimestamp=" + datetimestamp
				+ ", priority=" + priority + ", ammountexceeded=" + ammountexceeded + ", exceededreason="
				+ exceededreason + ", bencoescalated=" + bencoescalated + ", empapp=" + empapp + ", supapp=" + supapp
				+ ", msnapp=" + msnapp + ", dhdapp=" + dhdapp + ", benapp=" + benapp + ", denialreason=" + denialreason
				+ ", accounts=" + accounts + "]";
	}

}