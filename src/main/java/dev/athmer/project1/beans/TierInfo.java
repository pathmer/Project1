package dev.athmer.project1.beans;

public class TierInfo {
	private Integer id;
	private String levels;
	private String approval;
	private String denialreason;
	private String toemp;
	private String fromemp;
	private String tosup;
	private String fromsup;
	private String todh;
	private String fromdh;
	private Integer userid;
	private Integer requests;
	
	
	public TierInfo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TierInfo(Integer id, String levels, String approval, String denialreason, String toemp, String fromemp,
			String tosup, String fromsup, String todh, String fromdh, Integer userid, Integer requests) {
		super();
		this.id = id;
		this.levels = levels;
		this.approval = approval;
		this.denialreason = denialreason;
		this.toemp = toemp;
		this.fromemp = fromemp;
		this.tosup = tosup;
		this.fromsup = fromsup;
		this.todh = todh;
		this.fromdh = fromdh;
		this.userid = userid;
		this.requests = requests;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLevels() {
		return levels;
	}
	public void setLevels(String levels) {
		this.levels = levels;
	}
	public String getApproval() {
		return approval;
	}
	public void setApproval(String approval) {
		this.approval = approval;
	}
	public String getDenialreason() {
		return denialreason;
	}
	public void setDenialreason(String denialreason) {
		this.denialreason = denialreason;
	}
	public String getToemp() {
		return toemp;
	}
	public void setToemp(String toemp) {
		this.toemp = toemp;
	}
	public String getFromemp() {
		return fromemp;
	}
	public void setFromemp(String fromemp) {
		this.fromemp = fromemp;
	}
	public String getTosup() {
		return tosup;
	}
	public void setTosup(String tosup) {
		this.tosup = tosup;
	}
	public String getFromsup() {
		return fromsup;
	}
	public void setFromsup(String fromsup) {
		this.fromsup = fromsup;
	}
	public String getTodh() {
		return todh;
	}
	public void setTodh(String todh) {
		this.todh = todh;
	}
	public String getFromdh() {
		return fromdh;
	}
	public void setFromdh(String fromdh) {
		this.fromdh = fromdh;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
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
		result = prime * result + ((approval == null) ? 0 : approval.hashCode());
		result = prime * result + ((denialreason == null) ? 0 : denialreason.hashCode());
		result = prime * result + ((fromdh == null) ? 0 : fromdh.hashCode());
		result = prime * result + ((fromemp == null) ? 0 : fromemp.hashCode());
		result = prime * result + ((fromsup == null) ? 0 : fromsup.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((levels == null) ? 0 : levels.hashCode());
		result = prime * result + ((requests == null) ? 0 : requests.hashCode());
		result = prime * result + ((todh == null) ? 0 : todh.hashCode());
		result = prime * result + ((toemp == null) ? 0 : toemp.hashCode());
		result = prime * result + ((tosup == null) ? 0 : tosup.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
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
		TierInfo other = (TierInfo) obj;
		if (approval == null) {
			if (other.approval != null)
				return false;
		} else if (!approval.equals(other.approval))
			return false;
		if (denialreason == null) {
			if (other.denialreason != null)
				return false;
		} else if (!denialreason.equals(other.denialreason))
			return false;
		if (fromdh == null) {
			if (other.fromdh != null)
				return false;
		} else if (!fromdh.equals(other.fromdh))
			return false;
		if (fromemp == null) {
			if (other.fromemp != null)
				return false;
		} else if (!fromemp.equals(other.fromemp))
			return false;
		if (fromsup == null) {
			if (other.fromsup != null)
				return false;
		} else if (!fromsup.equals(other.fromsup))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (levels == null) {
			if (other.levels != null)
				return false;
		} else if (!levels.equals(other.levels))
			return false;
		if (requests == null) {
			if (other.requests != null)
				return false;
		} else if (!requests.equals(other.requests))
			return false;
		if (todh == null) {
			if (other.todh != null)
				return false;
		} else if (!todh.equals(other.todh))
			return false;
		if (toemp == null) {
			if (other.toemp != null)
				return false;
		} else if (!toemp.equals(other.toemp))
			return false;
		if (tosup == null) {
			if (other.tosup != null)
				return false;
		} else if (!tosup.equals(other.tosup))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "TierInfo [id=" + id + ", levels=" + levels + ", approval=" + approval + ", denialreason=" + denialreason
				+ ", toemp=" + toemp + ", fromemp=" + fromemp + ", tosup=" + tosup + ", fromsup=" + fromsup + ", todh="
				+ todh + ", fromdh=" + fromdh + ", userid=" + userid + ", requests=" + requests + "]";
	}

}
