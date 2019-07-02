package logic;

import java.util.regex.Pattern;

import dao.RegisterSelect;

public class UserLogic {
	public void execute(User u) {
		String pass = u.getPass();
		if(Pattern.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]{8,}",pass)) {
			RegisterSelect rs = new RegisterSelect();
			try {
				rs.select(u);
			} catch (Exception e) {
				e.printStackTrace();
			}

			u.setIsbool(true);

	}else {
		u.setIsbool(false);

	}
}
}
