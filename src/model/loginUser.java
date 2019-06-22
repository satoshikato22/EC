package model;

import java.io.Serializable;

public class loginUser implements Serializable{
	private String name;
	private String pass;
	private String mail;
	boolean isbool;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public boolean getIsbool() {
		return isbool;
	}
	public void setIsbool(boolean isbool) {
		this.isbool = isbool;
	}

	public loginUser() {}
}
