package com.jzsk.filecode;

import com.jzsk.filecode.utility.PasswordUtility;
import com.jzsk.filecode.utility.UserIdUtility;

public class UtilityTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UserIdUtility utility = new UserIdUtility();
		String userID = utility.generateUserId();
		System.out.println(userID);
		
		PasswordUtility pUtility = new PasswordUtility();
		String password = pUtility.encrypt("123456");
		System.out.println(password);
		
		boolean cheak = pUtility.checkPassword("123456", password);
		System.err.println(cheak);
	}

}
