package dev.athmer.project1.beans;

public class Attachments {
	private Integer id;
	private String optattachments;
	private String msgsupapproval;
	private String msgdephdapproval;
	private String gradepresentation;
	private Integer requests;
	
	
	public Attachments() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Attachments(Integer id, String optattachments, String msgsupapproval, String msgdephdapproval,
			String gradepresentation, Integer requests) {
		super();
		this.id = id;
		this.optattachments = optattachments;
		this.msgsupapproval = msgsupapproval;
		this.msgdephdapproval = msgdephdapproval;
		this.gradepresentation = gradepresentation;
		this.requests = requests;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOptattachments() {
		return optattachments;
	}
	public void setOptattachments(String optattachments) {
		this.optattachments = optattachments;
	}
	public String getMsgsupapproval() {
		return msgsupapproval;
	}
	public void setMsgsupapproval(String msgsupapproval) {
		this.msgsupapproval = msgsupapproval;
	}
	public String getMsgdephdapproval() {
		return msgdephdapproval;
	}
	public void setMsgdephdapproval(String msgdephdapproval) {
		this.msgdephdapproval = msgdephdapproval;
	}
	public String getGradepresentation() {
		return gradepresentation;
	}
	public void setGradepresentation(String gradepresentation) {
		this.gradepresentation = gradepresentation;
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
		result = prime * result + ((gradepresentation == null) ? 0 : gradepresentation.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((msgdephdapproval == null) ? 0 : msgdephdapproval.hashCode());
		result = prime * result + ((msgsupapproval == null) ? 0 : msgsupapproval.hashCode());
		result = prime * result + ((optattachments == null) ? 0 : optattachments.hashCode());
		result = prime * result + ((requests == null) ? 0 : requests.hashCode());
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
		Attachments other = (Attachments) obj;
		if (gradepresentation == null) {
			if (other.gradepresentation != null)
				return false;
		} else if (!gradepresentation.equals(other.gradepresentation))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (msgdephdapproval == null) {
			if (other.msgdephdapproval != null)
				return false;
		} else if (!msgdephdapproval.equals(other.msgdephdapproval))
			return false;
		if (msgsupapproval == null) {
			if (other.msgsupapproval != null)
				return false;
		} else if (!msgsupapproval.equals(other.msgsupapproval))
			return false;
		if (optattachments == null) {
			if (other.optattachments != null)
				return false;
		} else if (!optattachments.equals(other.optattachments))
			return false;
		if (requests == null) {
			if (other.requests != null)
				return false;
		} else if (!requests.equals(other.requests))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Attachments [id=" + id + ", optattachments=" + optattachments + ", msgsupapproval=" + msgsupapproval
				+ ", msgdephdapproval=" + msgdephdapproval + ", gradepresentation=" + gradepresentation + ", requests="
				+ requests + "]";
	}

}
