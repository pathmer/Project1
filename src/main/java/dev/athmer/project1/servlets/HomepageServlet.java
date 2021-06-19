package dev.athmer.project1.servlets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.athmer.project1.beans.User;
import dev.athmer.project1.services.LoginServices;

public class HomepageServlet extends HttpServlet {
		
		private LoginServices ls = new LoginServices();
		private Gson gson = new Gson();
		
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
			
			
			String uri = request.getRequestURI();
			
			System.out.println(uri);

			switch (uri) {

			case "/Project1/login": {
				
				if ("GET".equals(request.getMethod())) {
					System.out.println("Checking login info....");
					User u = gson.fromJson(request.getReader(), User.class);

					BufferedReader reader = request.getReader();
					String line = reader.readLine();
					System.out.println("ServletUser recieved: " + line);
					System.out.println("ServletUser recieved: " + request.getReader());
					System.out.println("ServletUser recieved: " + u);


					//User activeuser = ls.login(u);
					//System.out.println(activeuser);


					//response.setHeader("Origin", "http://localhost:8080/Project1/login");
					response.setHeader("Access-Control-Allow-Origin","*");
					//response.getWriter().append(gson.toJson(activeuser));
					break;
				}
				else {
					System.out.println("Hitting the servlet else statement...");
					User u = gson.fromJson(request.getReader(), User.class);

					BufferedReader reader = request.getReader();
					String line = reader.readLine();
					System.out.println("ServletUser recieved: " + line);
					System.out.println("ServletUser recieved: " + request.getReader());
					System.out.println("ServletUser recieved: " + u);


					//User activeuser = ls.login(u);
					//System.out.println(activeuser);


					//response.setHeader("Origin", "http://localhost:8080/Project1/login");
					response.setHeader("Access-Control-Allow-Origin","*");
					//response.getWriter().append(gson.toJson(activeuser));
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
			response.getWriter().append("Post request");
			String uri = request.getRequestURI();
			
			System.out.println(uri);

			switch (uri) {

			case "/Project1/login": {
				
				if ("POST".equals(request.getMethod())) {
					System.out.println("zChecking login info....");
					User u = gson.fromJson(request.getReader(), User.class);

					//BufferedReader reader = request.getReader();
					//String line = reader.readLine();
					//System.out.println("ServletUser recieved: " + line);
					//System.out.println("ServletUser recieved: " + request.getReader());
					System.out.println("ServletUser recieved: " + u);


					User activeuser = ls.login(u);
					System.out.println(activeuser);


					//response.setHeader("Origin", "http://localhost:8080/Project1/login");
					response.setHeader("Access-Control-Allow-Origin","*");
					response.getWriter().append(gson.toJson(activeuser));
					break;
				} else {
					System.out.println("zHitting the servlet else statement...");
					User u = gson.fromJson(request.getReader(), User.class);
					System.out.println(u);
					User activeuser = ls.login(u);
					System.out.println(activeuser);
					response.setHeader("Access-Control-Allow-Origin","*");
					//response.setHeader("Origin", "http://localhost:8080/CatAppServlet/cats");
					response.getWriter().append("zHitting the servlet else statement...");
					break;
				}
				
			}
			
			default: {
				System.out.println("zReached the default case...");
				response.setHeader("Access-Control-Allow-Origin","*");
				response.getWriter().append("zReached the default case...");
			}
			
			
			}
			
			
			
		}
	}
