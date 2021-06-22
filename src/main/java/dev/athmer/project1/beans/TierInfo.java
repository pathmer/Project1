package dev.athmer.project1.beans;

public class TierInfo {
	private Integer id;

	private String toid;
	private String tomsg;
	private String fromid;
	private String fromsup;
	private String todh;
	private String frommsg;

	private Integer requests;

	public TierInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TierInfo(Integer id, String toid, String tomsg, String fromid, String fromsup, String todh, String frommsg,
			Integer requests) {
		super();
		this.id = id;
		this.toid = toid;
		this.tomsg = tomsg;
		this.fromid = fromid;
		this.fromsup = fromsup;
		this.todh = todh;
		this.frommsg = frommsg;
		this.requests = requests;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getToid() {
		return toid;
	}

	public void setToid(String toid) {
		this.toid = toid;
	}

	public String getTomsg() {
		return tomsg;
	}

	public void setTomsg(String tomsg) {
		this.tomsg = tomsg;
	}

	public String getFromid() {
		return fromid;
	}

	public void setFromid(String fromid) {
		this.fromid = fromid;
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

	public String getFrommsg() {
		return frommsg;
	}

	public void setFrommsg(String frommsg) {
		this.frommsg = frommsg;
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
		result = prime * result + ((fromid == null) ? 0 : fromid.hashCode());
		result = prime * result + ((frommsg == null) ? 0 : frommsg.hashCode());
		result = prime * result + ((fromsup == null) ? 0 : fromsup.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((requests == null) ? 0 : requests.hashCode());
		result = prime * result + ((todh == null) ? 0 : todh.hashCode());
		result = prime * result + ((toid == null) ? 0 : toid.hashCode());
		result = prime * result + ((tomsg == null) ? 0 : tomsg.hashCode());
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
		if (fromid == null) {
			if (other.fromid != null)
				return false;
		} else if (!fromid.equals(other.fromid))
			return false;
		if (frommsg == null) {
			if (other.frommsg != null)
				return false;
		} else if (!frommsg.equals(other.frommsg))
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
		if (toid == null) {
			if (other.toid != null)
				return false;
		} else if (!toid.equals(other.toid))
			return false;
		if (tomsg == null) {
			if (other.tomsg != null)
				return false;
		} else if (!tomsg.equals(other.tomsg))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TierInfo [id=" + id + ", toid=" + toid + ", tomsg=" + tomsg + ", fromid=" + fromid + ", fromsup="
				+ fromsup + ", todh=" + todh + ", frommsg=" + frommsg + ", requests=" + requests + "]";
	}

}