package com.neolynx.domain.validator;

import com.google.common.base.Strings;
import com.neolynx.domain.impl.User;

public class UserValidator {

	public boolean isValidProfileForSignUp(User profile) {

		boolean returnValue = false;

		if (profile != null && profile.getUser_id() != null
				&& isValidPassword(profile.getPassword()))
			returnValue = true;

		return returnValue;
	}

	protected boolean isValidPassword(String password) {

		boolean returnValue = false;

		if (Strings.isNullOrEmpty(password) && password.length() < 8)
			;
		else
			returnValue = true;

		return returnValue;
	}

}
