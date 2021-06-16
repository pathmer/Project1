package dev.athmer.project1.beans;

public class Account {
	private Integer id;
	private Integer ayear;
	private Double balance;
	private Double pending;
	private Double reimbursed;
	private Integer users;
	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Account(Integer id, Integer ayear, Double balance, Double pending, Double reimbursed, Integer users) {
		super();
		this.id = id;
		this.ayear = ayear;
		this.balance = balance;
		this.pending = pending;
		this.reimbursed = reimbursed;
		this.users = users;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAyear() {
		return ayear;
	}
	public void setAyear(Integer ayear) {
		this.ayear = ayear;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Double getPending() {
		return pending;
	}
	public void setPending(Double pending) {
		this.pending = pending;
	}
	public Double getReimbursed() {
		return reimbursed;
	}
	public void setReimbursed(Double reimbursed) {
		this.reimbursed = reimbursed;
	}
	public Integer getUsers() {
		return users;
	}
	public void setUsers(Integer users) {
		this.users = users;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ayear == null) ? 0 : ayear.hashCode());
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pending == null) ? 0 : pending.hashCode());
		result = prime * result + ((reimbursed == null) ? 0 : reimbursed.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		Account other = (Account) obj;
		if (ayear == null) {
			if (other.ayear != null)
				return false;
		} else if (!ayear.equals(other.ayear))
			return false;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pending == null) {
			if (other.pending != null)
				return false;
		} else if (!pending.equals(other.pending))
			return false;
		if (reimbursed == null) {
			if (other.reimbursed != null)
				return false;
		} else if (!reimbursed.equals(other.reimbursed))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Account [id=" + id + ", ayear=" + ayear + ", balance=" + balance + ", pending=" + pending
				+ ", reimbursed=" + reimbursed + ", users=" + users + "]";
	}
	
}
