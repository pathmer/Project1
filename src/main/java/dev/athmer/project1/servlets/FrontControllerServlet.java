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
import dev.athmer.project1.beans.FormData;
import dev.athmer.project1.beans.Request;
import dev.athmer.project1.beans.User;
import dev.athmer.project1.services.EmployeeServices;
import dev.athmer.project1.services.LoginServices;

public class FrontControllerServlet extends HttpServlet {
	
	private LoginServices ls;
	private EmployeeServices es;
	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
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
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uri = request.getRequestURI();
		System.out.println(uri);

		switch (uri) {
		
		case "/Project1/site/logout": {
			if ("GET".equals(request.getMethod())) {
				System.out.println("Logging out....");
				ls = null;
				es = null;
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
				System.out.println("Checking user requests info....");
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
				System.out.println("Checking other requests info....");
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
				System.out.println("Checking user formdata info....");
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
		
		default: {
			System.out.println("Reached the default case...");
			response.setHeader("Access-Control-Allow-Origin","*");
			response.getWriter().append("Reached the default case...");
		}
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//response.getWriter().append("Post request");
		String uri = request.getRequestURI();

		switch (uri) {

		case "/Project1/site/login": {
			
			if ("POST".equals(request.getMethod())) {
				System.out.println("Checking login info....");
				session = request.getSession();
				//System.out.println(session);
				ls = new LoginServices();
				checkuser = gson.fromJson(request.getReader(), User.class);
				activeuser = ls.login(checkuser);
				//System.out.println(activeuser);
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
//				session.invalidate();

				//response.setHeader("Origin", "http://localhost:8080/Project1/login");
				//response.setHeader("Access-Control-Allow-Origin","*");
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
				System.out.println("Checking account info....");
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
				es.addRequest(newrequest, activeuser, annualaccount);
				response.setHeader("Content-Type", "application/json");
				response.getWriter().append(gson.toJson("success"));
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

