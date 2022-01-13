package model;

import java.io.Serializable;

public class UserLogin implements Serializable {

	private String name;
	private String pass;

	public UserLogin() {
	}

	public UserLogin(String name, String pass) {

		this.name = name;
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public String getPass() {
		return pass;
	}

}
