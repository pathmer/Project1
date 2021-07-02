package dev.athmer.project1.services;


import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import dev.athmer.project1.beans.AutoApprove;
import dev.athmer.project1.beans.Request;
import dev.athmer.project1.repositories.AutoApproveRepository;
import dev.athmer.project1.repositories.RequestRepository;

public class AutoApproveServices {

	AutoApproveRepository aar = new AutoApproveRepository();
	RequestRepository rr = new RequestRepository();
	List<AutoApprove> aalist = new ArrayList<AutoApprove>();
	Timer timer = new Timer();
	LocalDate olddate = LocalDate.parse("2021-06-29"); //LocalDate.now();
	
	public void mainaas() {
		timer.scheduleAtFixedRate(new TimerTask() {
			  @Override
			  public void run() {
				  checkdate();
			  }
			}, 0, 1*60*60*1000);
	}
	private void checkdate() {
		if (olddate.toString().equals(LocalDate.now().toString()) == false) {
			olddate = LocalDate.now();
			String command = "c:\\program files\\apache-tomcat-9.0.46\\bin\\shutdown.bat";
			try {
				Runtime.getRuntime().exec(command);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			aalist = aar.getRequests();
			for (int i = 0; i < aalist.size(); i++) {
				AutoApprove aa = aalist.get(i);
				Date now = new Date(System.currentTimeMillis());
				Long days = ChronoUnit.DAYS.between(LocalDate.parse(aa.getDatetimestamp().toString()),LocalDate.parse(now.toString()));
				if (days > 2) {
					doanAutoApprove(aa, now);
				}
				
			}
			command = "c:\\program files\\apache-tomcat-9.0.46\\bin\\startup.bat";
			try {
				Runtime.getRuntime().exec(command);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void doanAutoApprove(AutoApprove aa, Date now) {
		Request request = new Request();
		
		request.setId(aa.getId());
		request.setTitle(aa.getTitle());
		request.setStartDate(aa.getStartDate());
		request.setReimbursement(aa.getReimbursement());
		request.setStatus(aa.getStatus());
		request.setInbox(aa.getInbox());
		request.setDatetimestamp(aa.getDatetimestamp());
		request.setPriority(aa.getPriority());
		request.setAmountexceeded(aa.getAmountexceeded());
		request.setExceededreason(aa.getExceededreason());
		request.setBencoescalated(aa.getBencoescalated());
		request.setEmpapp(aa.getEmpapp());
		request.setSupapp(aa.getSupapp());
		request.setManapp(aa.getManapp());
		request.setDhdapp(aa.getDhdapp());
		request.setBenapp(aa.getBenapp());
		request.setDenialreason(aa.getDenialreason());
		request.setAccounts(aa.getAccounts());
		
		if (request.getInbox() == aa.getSupervisor()) {
			request.setSupapp("Yes");
			request.setInbox(aa.getDepthead());
			request.setDatetimestamp(now);
		}
		else if (request.getInbox() == aa.getDepthead()) {
			request.setDhdapp("Yes");
			request.setInbox(5);
			request.setDatetimestamp(now);
		}
		else if (request.getInbox() == 5) {
			request.setInbox(6);
			request.setBencoescalated("Yes");
			request.setDatetimestamp(now);
		}

		rr.update(request);
	}
	
	
	
	
	
}
