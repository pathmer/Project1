package dev.athmer.project1.services;

import dev.athmer.project1.beans.User;
import dev.athmer.project1.repositories.UserRepository;

public class LoginServices {
	public static UserRepository ur = new UserRepository();
	public static User activeuser;
	public static User newuser;
	public static User checkuser;

	public User login(User u) {

		activeuser = ur.getByUsername(u.getUsernames());
		if (u.getPasswords().equals(activeuser.getPasswords())) {
			return activeuser;
		}
		else {
			return null;
		}
	}
}
