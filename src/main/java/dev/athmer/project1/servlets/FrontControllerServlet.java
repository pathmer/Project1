package dev.athmer.project1.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dev.athmer.project1.beans.User;
import dev.athmer.project1.services.LoginServices;

public class FrontControllerServlet extends HttpServlet {
	
	private LoginServices ls = new LoginServices();
	private Gson gson = new Gson();
	public HttpSession session;
	public User activeuser;
	public User checkuser;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		String uri = request.getRequestURI();
		
		System.out.println(uri);

		switch (uri) {

//		case "/Project1/login": {
//			
//			if ("GET".equals(request.getMethod())) {
//				System.out.println("Checking login info....");
//	
//				//response.setHeader("Origin", "http://localhost:8080/Project1/login");
//				response.setHeader("Access-Control-Allow-Origin","*");
//				//response.getWriter().append(gson.toJson(activeuser));
//				break;
//			}
//			else {
//				System.out.println("Hitting the servlet else statement...");
//
//				//response.setHeader("Origin", "http://localhost:8080/Project1/login");
//				response.setHeader("Access-Control-Allow-Origin","*");
//				//response.getWriter().append(gson.toJson(activeuser));
//				break;
//			}
//		}
		default: {
			System.out.println("Reached the default case...");
			response.setHeader("Access-Control-Allow-Origin","*");
			response.getWriter().append("Reached the default case...");
		}
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().append("Post request");
		String uri = request.getRequestURI();
		
		System.out.println(uri);

		switch (uri) {

		case "/Project1/login": {
			
			if ("POST".equals(request.getMethod())) {
				System.out.println("Checking login info....");
				checkuser = gson.fromJson(request.getReader(), User.class);

				//System.out.println("ServletUser recieved: " + u);

				activeuser = ls.login(checkuser);
				System.out.println(activeuser);
				if (activeuser.getId() != null) {
					session = request.getSession();
					System.out.println(session.getId());
					session.setAttribute("activeuser", "{'id': " + activeuser.getId() + "}");
					System.out.println(session.getAttribute("activeuser"));
				}
//				session.setMaxInactiveInterval(0);
//				session.invalidate();

				//response.setHeader("Origin", "http://localhost:8080/Project1/login");
				response.setHeader("Access-Control-Allow-Origin","*");
				response.getWriter().append(gson.toJson(activeuser));
				break;
			}
			else {
				System.out.println("Hitting the servlet else statement...");
				checkuser = gson.fromJson(request.getReader(), User.class);
				System.out.println(checkuser);
				activeuser = ls.login(checkuser);
				System.out.println(activeuser);
				response.setHeader("Access-Control-Allow-Origin","*");
				//response.setHeader("Origin", "http://localhost:8080/CatAppServlet/cats");
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

