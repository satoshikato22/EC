package model;

import java.util.regex.Pattern;

public class UserLogic {
	public void execute(User u) {
		String pass = u.getPass();
		String text = u.getText();
		if(text.equals(pass)) {
		if(Pattern.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]{8,}",pass)) {
			u.setIsbool(true);
	}
	}else {
		u.setIsbool(false);
	}
	}
}

