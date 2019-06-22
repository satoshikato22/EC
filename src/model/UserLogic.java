package model;

public class UserLogic {
	public void execute(User u) {
		boolean isbool;
		String pass = u.getPass();

		if(isbool = pass.matches("[a-zA-Z0-9]{8,}")) {
			u.setIsbool(isbool);
		}else {
			u.setIsbool(isbool);
		}
	}
}
