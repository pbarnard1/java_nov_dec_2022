package com.adrianbarnard.loginregdemo.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

// Do NOT need the @Entity or @Table annotations - we don't need to save any new info when we're logging in!
public class LoginUser {
	@NotEmpty(message="Email is required!")
	@Email(message="Please enter a valid email!")
	private String loginEmail;
	
	@NotEmpty(message="Password is required!")
	@Size(min=8, max=128, message="Password must be 8 to 128 characters!")
	private String loginPassword;
	
	public LoginUser() {
	}

	public String getLoginEmail() {
		return loginEmail;
	}

	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}


	
	
}
