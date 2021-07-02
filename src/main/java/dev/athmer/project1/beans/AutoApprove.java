package dev.athmer.project1.beans;

import java.sql.Date;

public class AutoApprove {
	private Integer userid;
	private String utype;
	private Integer supervisor;
	private Integer manager;
	private Integer depthead;
	
	private Integer id;
	private String title;
	private Date startDate;
	private Double reimbursement;
	private String status;
	private Integer inbox;
	private Date datetimestamp;
	private String priority;
	private String amountexceeded;
	private String exceededreason;
	private String bencoescalated;
	private String empapp;
	private String supapp;
	private String manapp;
	private String dhdapp;
	private String benapp;
	private String denialreason;
	
	private Integer accounts;

	public AutoApprove() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AutoApprove(Integer userid, String utype, Integer supervisor, Integer manager, Integer depthead, Integer id,
			String title, Date startDate, Double reimbursement, String status, Integer inbox, Date datetimestamp,
			String priority, String amountexceeded, String exceededreason, String bencoescalated, String empapp,
			String supapp, String manapp, String dhdapp, String benapp, String denialreason, Integer accounts) {
		super();
		this.userid = userid;
		this.utype = utype;
		this.supervisor = supervisor;
		this.manager = manager;
		this.depthead = depthead;
		this.id = id;
		this.title = title;
		this.startDate = startDate;
		this.reimbursement = reimbursement;
		this.status = status;
		this.inbox = inbox;
		this.datetimestamp = datetimestamp;
		this.priority = priority;
		this.amountexceeded = amountexceeded;
		this.exceededreason = exceededreason;
		this.bencoescalated = bencoescalated;
		this.empapp = empapp;
		this.supapp = supapp;
		this.manapp = manapp;
		this.dhdapp = dhdapp;
		this.benapp = benapp;
		this.denialreason = denialreason;
		this.accounts = accounts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accounts == null) ? 0 : accounts.hashCode());
		result = prime * result + ((amountexceeded == null) ? 0 : amountexceeded.hashCode());
		result = prime * result + ((benapp == null) ? 0 : benapp.hashCode());
		result = prime * result + ((bencoescalated == null) ? 0 : bencoescalated.hashCode());
		result = prime * result + ((datetimestamp == null) ? 0 : datetimestamp.hashCode());
		result = prime * result + ((denialreason == null) ? 0 : denialreason.hashCode());
		result = prime * result + ((depthead == null) ? 0 : depthead.hashCode());
		result = prime * result + ((dhdapp == null) ? 0 : dhdapp.hashCode());
		result = prime * result + ((empapp == null) ? 0 : empapp.hashCode());
		result = prime * result + ((exceededreason == null) ? 0 : exceededreason.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((inbox == null) ? 0 : inbox.hashCode());
		result = prime * result + ((manager == null) ? 0 : manager.hashCode());
		result = prime * result + ((manapp == null) ? 0 : manapp.hashCode());
		result = prime * result + ((priority == null) ? 0 : priority.hashCode());
		result = prime * result + ((reimbursement == null) ? 0 : reimbursement.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((supapp == null) ? 0 : supapp.hashCode());
		result = prime * result + ((supervisor == null) ? 0 : supervisor.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		result = prime * result + ((utype == null) ? 0 : utype.hashCode());
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
		AutoApprove other = (AutoApprove) obj;
		if (accounts == null) {
			if (other.accounts != null)
				return false;
		} else if (!accounts.equals(other.accounts))
			return false;
		if (amountexceeded == null) {
			if (other.amountexceeded != null)
				return false;
		} else if (!amountexceeded.equals(other.amountexceeded))
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
		if (depthead == null) {
			if (other.depthead != null)
				return false;
		} else if (!depthead.equals(other.depthead))
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
		if (manager == null) {
			if (other.manager != null)
				return false;
		} else if (!manager.equals(other.manager))
			return false;
		if (manapp == null) {
			if (other.manapp != null)
				return false;
		} else if (!manapp.equals(other.manapp))
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
		if (supervisor == null) {
			if (other.supervisor != null)
				return false;
		} else if (!supervisor.equals(other.supervisor))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		if (utype == null) {
			if (other.utype != null)
				return false;
		} else if (!utype.equals(other.utype))
			return false;
		return true;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUtype() {
		return utype;
	}

	public void setUtype(String utype) {
		this.utype = utype;
	}

	public Integer getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Integer supervisor) {
		this.supervisor = supervisor;
	}

	public Integer getManager() {
		return manager;
	}

	public void setManager(Integer manager) {
		this.manager = manager;
	}

	public Integer getDepthead() {
		return depthead;
	}

	public void setDepthead(Integer depthead) {
		this.depthead = depthead;
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

	public String getAmountexceeded() {
		return amountexceeded;
	}

	public void setAmountexceeded(String amountexceeded) {
		this.amountexceeded = amountexceeded;
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

	public String getManapp() {
		return manapp;
	}

	public void setManapp(String manapp) {
		this.manapp = manapp;
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
	public String toString() {
		return "AutoApprove [userid=" + userid + ", utype=" + utype + ", supervisor=" + supervisor + ", manager="
				+ manager + ", depthead=" + depthead + ", id=" + id + ", title=" + title + ", startDate=" + startDate
				+ ", reimbursement=" + reimbursement + ", status=" + status + ", inbox=" + inbox + ", datetimestamp="
				+ datetimestamp + ", priority=" + priority + ", amountexceeded=" + amountexceeded + ", exceededreason="
				+ exceededreason + ", bencoescalated=" + bencoescalated + ", empapp=" + empapp + ", supapp=" + supapp
				+ ", manapp=" + manapp + ", dhdapp=" + dhdapp + ", benapp=" + benapp + ", denialreason=" + denialreason
				+ ", accounts=" + accounts + "]";
	}
}
