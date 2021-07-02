package dev.athmer.project1.servlets;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dev.athmer.project1.beans.Account;
import dev.athmer.project1.beans.Attachments;
import dev.athmer.project1.beans.FormData;
import dev.athmer.project1.beans.Request;
import dev.athmer.project1.beans.User;
import dev.athmer.project1.services.EmployeeServices;
import dev.athmer.project1.services.LoginServices;

@SuppressWarnings("serial")
public class FrontControllerServlet extends HttpServlet {
	
	private LoginServices ls;
	private EmployeeServices es;
	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
	private HttpSession session;
	private Boolean loginsuccess = false;
	private User activeuser;
	private User checkuser;
	private Account account;
	private Account annualaccount;
	private Integer year;
	private List<Request> usershortrequests;
	private List<Request> othershortrequests;
	private Request selectedrequest;
	private FormData selectedformdata;
	private Attachments selectedattachments;
	private Account selectedaccount;
	private User selecteduser;
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uri = request.getRequestURI();

		switch (uri) {
		
		case "/Project1/site/logout": {
			if ("GET".equals(request.getMethod())) {
				session.invalidate();
				response.setHeader("Content-Type", "application/json");
				response.getWriter().append(gson.toJson("loggedout"));
				break;
			}
			else {
				System.out.println("Hitting the servlet else statement...");
				response.setHeader("Access-Control-Allow-Origin","*");
				response.getWriter().append("Hitting the servlet else statement...");
				break;
			}
		}
		
		case "/Project1/site/getusershortrequests": {
			if ("GET".equals(request.getMethod())) {
				if (account != null) {
					usershortrequests = es.getUserRequestShortListByAccount(account);
				}
				else {
					usershortrequests = null;
				}
				response.setHeader("Content-Type", "application/json");
				response.getWriter().append(gson.toJson(usershortrequests));
				break;
			}
			else {
				System.out.println("Hitting the servlet else statement...");
				response.setHeader("Access-Control-Allow-Origin","*");
				response.getWriter().append("Hitting the servlet else statement...");
				break;
			}
		}
		case "/Project1/site/getothershortrequests": {
			if ("GET".equals(request.getMethod())) {
				if ("employee".equals(activeuser.getUtype())) {
					othershortrequests = null;
				}
				else {
					othershortrequests = es.getOtherRequestShortListByYear(activeuser, year);
				}
				response.setHeader("Content-Type", "application/json");
				response.getWriter().append(gson.toJson(othershortrequests));
				break;
			}
			else {
				System.out.println("Hitting the servlet else statement...");
				response.setHeader("Access-Control-Allow-Origin","*");
				response.getWriter().append("Hitting the servlet else statement...");
				break;
			}
		}
		
		case "/Project1/site/getuserformdata": {
			if ("GET".equals(request.getMethod())) {
				List<FormData> formdata = es.getUserFormData(account);
				response.setHeader("Content-Type", "application/json");
				response.getWriter().append(gson.toJson(formdata));
				break;
			}
			else {
				System.out.println("Hitting the servlet else statement...");
				response.setHeader("Access-Control-Allow-Origin","*");
				response.getWriter().append("Hitting the servlet else statement...");
				break;
			}
		}
		
		case "/Project1/site/getselectedrequest": {
			if ("GET".equals(request.getMethod())) {
				response.setHeader("Content-Type", "application/json");
				response.getWriter().append(gson.toJson(selectedrequest));
				break;
			}
			else {
				System.out.println("Hitting the servlet else statement...");
				response.setHeader("Access-Control-Allow-Origin","*");
				response.getWriter().append("Hitting the servlet else statement...");
				break;
			}
		}
		
		case "/Project1/site/getselectedformdata": {
			if ("GET".equals(request.getMethod())) {
				response.setHeader("Content-Type", "application/json");
				response.getWriter().append(gson.toJson(selectedformdata));
				break;
			}
			else {
				System.out.println("Hitting the servlet else statement...");
				response.setHeader("Access-Control-Allow-Origin","*");
				response.getWriter().append("Hitting the servlet else statement...");
				break;
			}
		}
		
		case "/Project1/site/getselectedattachments": {
			if ("GET".equals(request.getMethod())) {
				response.setHeader("Content-Type", "application/json");
				response.getWriter().append(gson.toJson(selectedattachments));
				break;
			}
			else {
				System.out.println("Hitting the servlet else statement...");
				response.setHeader("Access-Control-Allow-Origin","*");
				response.getWriter().append("Hitting the servlet else statement...");
				break;
			}
		}
		
		case "/Project1/site/getselectedaccount": {
			if ("GET".equals(request.getMethod())) {
				response.setHeader("Content-Type", "application/json");
				response.getWriter().append(gson.toJson(selectedaccount));
				break;
			}
			else {
				System.out.println("Hitting the servlet else statement...");
				response.setHeader("Access-Control-Allow-Origin","*");
				response.getWriter().append("Hitting the servlet else statement...");
				break;
			}
		}
		
		case "/Project1/site/getselecteduser": {
			if ("GET".equals(request.getMethod())) {
				response.setHeader("Content-Type", "application/json");
				response.getWriter().append(gson.toJson(selecteduser));
				break;
			}
			else {
				System.out.println("Hitting the servlet else statement...");
				response.setHeader("Access-Control-Allow-Origin","*");
				response.getWriter().append("Hitting the servlet else statement...");
				break;
			}
		}
		
		case "/Project1/site/getactiveuser": {
			if ("GET".equals(request.getMethod())) {
				response.setHeader("Content-Type", "application/json");
				response.getWriter().append(gson.toJson(activeuser));
				break;
			}
			else {
				System.out.println("Hitting the servlet else statement...");
				response.setHeader("Access-Control-Allow-Origin","*");
				response.getWriter().append("Hitting the servlet else statement...");
				break;
			}
		}
		
		default: {
			System.out.println("Reached the default case...");
			response.setHeader("Access-Control-Allow-Origin","*");
			response.getWriter().append("Reached the default case...");
		}
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uri = request.getRequestURI();

		switch (uri) {

		case "/Project1/site/login": {
			
			if ("POST".equals(request.getMethod())) {
				session = request.getSession();
				//System.out.println(session);
				ls = new LoginServices();
				checkuser = gson.fromJson(request.getReader(), User.class);
				activeuser = ls.login(checkuser);
				if (activeuser  == null) {
					session.invalidate();
				}
				else {
					es = new EmployeeServices();
					year = Calendar.getInstance().get(Calendar.YEAR);
					account = es.getAccount(activeuser, year);
					loginsuccess = true;
				}
//				session.setMaxInactiveInterval(0);

				response.setHeader("Content-Type", "application/json");
				response.getWriter().append(gson.toJson(loginsuccess));
				break;
			}
			else {
				System.out.println("Hitting the servlet else statement...");
				response.setHeader("Access-Control-Allow-Origin","*");
				response.getWriter().append("Hitting the servlet else statement...");
				break;
			}
		}
		
		case "/Project1/site/getaccount": {
			if ("POST".equals(request.getMethod())) {
				year = gson.fromJson(request.getReader(), Integer.class);
				account = es.getAccount(activeuser, year);
				response.setHeader("Content-Type", "application/json");
				response.getWriter().append(gson.toJson(account));
				break;
			}
			else {
				System.out.println("Hitting the servlet else statement...");
				response.setHeader("Access-Control-Allow-Origin","*");
				response.getWriter().append("Hitting the servlet else statement...");
				break;
			}
		}
		
		case "/Project1/site/addRequest": {
			if ("POST".equals(request.getMethod())) {
				System.out.println("Adding new request ....");
				Request newrequest = gson.fromJson(request.getReader(), Request.class);
				annualaccount = es.getAccount(activeuser, Calendar.getInstance().get(Calendar.YEAR));
				Request newrequest2 = es.addRequest(newrequest, activeuser, annualaccount);
				response.setHeader("Content-Type", "application/json");
				response.getWriter().append(gson.toJson(newrequest2));
				break;
			}
			else {
				System.out.println("Hitting the servlet else statement...");
				response.setHeader("Access-Control-Allow-Origin","*");
				response.getWriter().append("Hitting the servlet else statement...");
				break;
			}
		}
		
		case "/Project1/site/addFormdata": {
			if ("POST".equals(request.getMethod())) {
				System.out.println("Adding new formdata ....");
				FormData newformdata = gson.fromJson(request.getReader(), FormData.class);
				es.addFormData(newformdata);
				response.setHeader("Content-Type", "application/json");
				response.getWriter().append(gson.toJson("Success formdata"));
				break;
			}
			else {
				System.out.println("Hitting the servlet else statement...");
				response.setHeader("Access-Control-Allow-Origin","*");
				response.getWriter().append("Hitting the servlet else statement...");
				break;
			}
		}
		
		case "/Project1/site/addattachments": {
			if ("POST".equals(request.getMethod())) {
				System.out.println("Adding new attachments ....");
				Attachments newattachments = gson.fromJson(request.getReader(), Attachments.class);
				es.addAttachments(newattachments);
				response.setHeader("Content-Type", "application/json");
				response.getWriter().append(gson.toJson("Success attachments"));
				break;
			}
			else {
				System.out.println("Hitting the servlet else statement...");
				response.setHeader("Access-Control-Allow-Origin","*");
				response.getWriter().append("Hitting the servlet else statement...");
				break;
			}
		}
		
		case "/Project1/site/setselectedrequest": {
			if ("POST".equals(request.getMethod())) {
				Request newselectedrequest = gson.fromJson(request.getReader(), Request.class);
				selectedrequest = es.getRequest(newselectedrequest.getId());
				selectedformdata = es.getFormData(newselectedrequest.getId());
				selectedattachments = es.getAttachments(newselectedrequest.getId());
				selectedaccount = es.getSelectedAccount(selectedrequest.getAccounts());	
				selecteduser = es.getSelectedUSer(selectedaccount.getUsers());
				response.setHeader("Content-Type", "application/json");
				response.getWriter().append(gson.toJson("Success activerequest"));
				break;
			}
			else {
				System.out.println("Hitting the servlet else statement...");
				response.setHeader("Access-Control-Allow-Origin","*");
				response.getWriter().append("Hitting the servlet else statement...");
				break;
			}
		}
		
		case "/Project1/site/updaterequest": {
			if ("POST".equals(request.getMethod())) {
				System.out.println("Updating request ....");
				Request newselectedrequest = gson.fromJson(request.getReader(), Request.class);
				selectedrequest = es.updateRequest(newselectedrequest);
				response.setHeader("Content-Type", "application/json");
				response.getWriter().append(gson.toJson("Success activerequest"));
				break;
			}
			else {
				System.out.println("Hitting the servlet else statement...");
				response.setHeader("Access-Control-Allow-Origin","*");
				response.getWriter().append("Hitting the servlet else statement...");
				break;
			}
		}
		
		case "/Project1/site/updateaccount": {
			if ("POST".equals(request.getMethod())) {
				System.out.println("Updating account ....");
				Account newselectedaccount = gson.fromJson(request.getReader(), Account.class);
				selectedaccount = es.updateAccount(newselectedaccount);
				response.setHeader("Content-Type", "application/json");
				response.getWriter().append(gson.toJson(selectedaccount));
				break;
			}
			else {
				System.out.println("Hitting the servlet else statement...");
				response.setHeader("Access-Control-Allow-Origin","*");
				response.getWriter().append("Hitting the servlet else statement...");
				break;
			}
		}
		
		default: {
			System.out.println("Reached the default case...");
			response.setHeader("Access-Control-Allow-Origin","*");
			response.getWriter().append("Reached the default case...");
		}
		}
	}
}

