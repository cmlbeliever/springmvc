package com.cml.mvc.framework.security.realm;

public interface AuthenticationService {
	/**
	 * 用户登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public AuthenticationUser doLogin(String username, String password);
}
