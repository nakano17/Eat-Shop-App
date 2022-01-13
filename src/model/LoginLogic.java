package model;

public class LoginLogic {
	public boolean execute(UserLogin userLogin) {
		if (userLogin.getPass().equals("1234")) {
			return true;
		}
		return false;
	}
}