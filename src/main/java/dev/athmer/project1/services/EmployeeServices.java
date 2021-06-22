package dev.athmer.project1.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dev.athmer.project1.beans.Account;
import dev.athmer.project1.beans.FormData;
import dev.athmer.project1.beans.Request;
import dev.athmer.project1.beans.User;
import dev.athmer.project1.repositories.AccountRepository;
import dev.athmer.project1.repositories.FormDataRepository;
import dev.athmer.project1.repositories.RequestRepository;
import dev.athmer.project1.repositories.UserRepository;

public class EmployeeServices {
	public static UserRepository ur = new UserRepository();
	public static AccountRepository ar = new AccountRepository();
	public static RequestRepository rr = new RequestRepository();
	public static FormDataRepository fr = new FormDataRepository();

	public Account getAccount(User u, Integer year) {
		Account account = null;
		List<Account> accounts= ar.getByUser(u.getId());
		for (int i = 0; i < accounts.size(); i++) {
			Account a = accounts.get(i);
			if ((int) year == (int) a.getAyear()) {
				account = a;
			}
		}
		return account;
	}
	public List<Request> getUserRequestShortListByAccount(Account a) {
		List<Request> resquests = rr.getUserRequestShortListByAccount(a.getId());
		return resquests;
	}
	
	public List<Request> getOtherRequestShortListByYear(User u, int y) {
		List<Request> requests = new ArrayList<Request>();
		if (("benco".equals(u.getUtype())) || ("bencosupervisor".equals(u.getUtype()))) {
			requests = rr.getBencoRequestShortListByYear(y);
		}
		else {
			requests = rr.getOtherRequestShortListByYear(u, y);
		}
		return requests;
	}
	
	public List<FormData> getUserFormData(Account a) {
		List<FormData> formdata = fr.getByAccount(a.getId());
		return formdata;
	}
	
	public void addRequest(Request r, User u, Account a) {
		r.setAccounts(a.getId());
		r.setStatus("pending");
		r.setPriority("normal");
		Date date = new Date(System.currentTimeMillis());
		r.setDatetimestamp(date);
		int inbox = 0;
		if ("employee".equals(u.getUtype())) {
			inbox = u.getSupervisor();
		}
		else if (("supervisor".equals(u.getUtype())) || ("manager".equals(u.getUtype()))) {
			inbox = u.getDepthead();
		}
		else if ("depthead".equals(u.getUtype())) {
			inbox = 5;
		}
		else if ("benco".equals(u.getUtype())) {
			inbox = 6;
		}
		
		r.setReimbursement(0.0);
		r.setInbox(inbox);
		
		rr.add(r);
		
		// need to update account
		// need to update priority elsewhere
	}
}
