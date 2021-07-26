This Project was completed to fulfill the requirements of Project 1 furing Training at Revature LLC.

The client was looking for a Web Application with which to track reimbursements for their employees, who are each given a $1,000 stipend to use for Professional Development. The resulting application allows employees to login, submit requests for reimbursements, and check the status of their requests. It also allows management to approve or deny requests, change the reimbursement ammount, as well as track the reimbursement payments.

Package Structure
Beans: Java Beans that represent tables in the Oracle SQL Database
Driver: Application logic for running independent backend logic
Logging: Log4J monitors events throughout the software
Repositories: Data Access Objects used to query the Database
Services: Any necessary business logic - in this application, the Service Layer simply calls the Repository Layer
Servlets: HttpServlet to listen for incoming requests and send corresponding responses
Utilities: JDBC Connection Class to configure credentials and make connections to the AWS RDS instance

Features
Session Tracking
HttpSession objects used to store and access session information (such as current logged in user and the professional development resource in question)
AJAX Calls
JavaScript is implemented for frent end design in order to send and receive asynchronous HTTP Requests and Responses
HTML Design
CSS design
JavaScript used for DOM Manipulation
Feature file, step implementation, and runner class located in src/test folders in order to test user interaction on the login page (using Selenium WebDriver to automate user input and navigation)

Further Development
Some appropriate imrpovements would be to implement a messaging service tied to employees, supervisors, and their development resources.
Implementation of file uploading is not functional yet.
