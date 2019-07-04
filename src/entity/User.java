package entiry;

import java.io.Serializable;

public class User implements Serializable {
	private String name;
	private String text;
	private String pass;
	private String mail;
	private String address;
	private boolean isbool;
	private boolean selectbool = true;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean getIsbool() {
		return isbool;
	}

	public void setIsbool(boolean isbool) {
		this.isbool = isbool;
	}

	public boolean getSelectbool() {
		return selectbool;
	}

	public void setSelectbool(boolean selectbool) {
		this.selectbool = selectbool;
	}
}
