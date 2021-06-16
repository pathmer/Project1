package dev.athmer.project1.beans;

public class User {
	private Integer id;
	private String utype;
	private String usernames;
	private String passwords;
	private Integer ssn;
	private String firstname;
	private String lastname;
	private String ustatus;
	private Integer supervisor;
	private String department;
	private Integer depthead;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(Integer id, String utype, String usernames, String passwords, Integer ssn, String firstname,
			String lastname, String ustatus, Integer supervisor, String department, Integer depthead) {
		super();
		this.id = id;
		this.utype = utype;
		this.usernames = usernames;
		this.passwords = passwords;
		this.ssn = ssn;
		this.firstname = firstname;
		this.lastname = lastname;
		this.ustatus = ustatus;
		this.supervisor = supervisor;
		this.department = department;
		this.depthead = depthead;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUtype() {
		return utype;
	}
	public void setUtype(String utype) {
		this.utype = utype;
	}
	public String getUsernames() {
		return usernames;
	}
	public void setUsernames(String usernames) {
		this.usernames = usernames;
	}
	public String getPasswords() {
		return passwords;
	}
	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}
	public Integer getSsn() {
		return ssn;
	}
	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUstatus() {
		return ustatus;
	}
	public void setUstatus(String ustatus) {
		this.ustatus = ustatus;
	}
	public Integer getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(Integer supervisor) {
		this.supervisor = supervisor;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Integer getDepthead() {
		return depthead;
	}
	public void setDepthead(Integer depthead) {
		this.depthead = depthead;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((depthead == null) ? 0 : depthead.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((passwords == null) ? 0 : passwords.hashCode());
		result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
		result = prime * result + ((supervisor == null) ? 0 : supervisor.hashCode());
		result = prime * result + ((usernames == null) ? 0 : usernames.hashCode());
		result = prime * result + ((ustatus == null) ? 0 : ustatus.hashCode());
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
		User other = (User) obj;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (depthead == null) {
			if (other.depthead != null)
				return false;
		} else if (!depthead.equals(other.depthead))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (passwords == null) {
			if (other.passwords != null)
				return false;
		} else if (!passwords.equals(other.passwords))
			return false;
		if (ssn == null) {
			if (other.ssn != null)
				return false;
		} else if (!ssn.equals(other.ssn))
			return false;
		if (supervisor == null) {
			if (other.supervisor != null)
				return false;
		} else if (!supervisor.equals(other.supervisor))
			return false;
		if (usernames == null) {
			if (other.usernames != null)
				return false;
		} else if (!usernames.equals(other.usernames))
			return false;
		if (ustatus == null) {
			if (other.ustatus != null)
				return false;
		} else if (!ustatus.equals(other.ustatus))
			return false;
		if (utype == null) {
			if (other.utype != null)
				return false;
		} else if (!utype.equals(other.utype))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", utype=" + utype + ", usernames=" + usernames + ", passwords=" + passwords
				+ ", ssn=" + ssn + ", firstname=" + firstname + ", lastname=" + lastname + ", ustatus=" + ustatus
				+ ", supervisor=" + supervisor + ", department=" + department + ", depthead=" + depthead + "]";
	}

}