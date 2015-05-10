package com.cml.mvc.framework.security.realm;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class UserRealm extends AuthorizingRealm {

	private static final Log log = LogFactory.getLog(UserRealm.class);

	private AuthenticationService authcService;

	/**
	 * 认证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection collection) {
		log.debug("UserRealm==>doGetAuthorizationInfo:" + collection);
		return null;
	}

	/**
	 * 授权
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		log.debug("UserRealm==>doGetAuthenticationInfo:" + token.getPrincipal()
				+ "," + token.getCredentials());

		UsernamePasswordToken userToken = (UsernamePasswordToken) token;

		String username = userToken.getUsername();
		String password = new String(userToken.getPassword());

		AuthenticationUser user = authcService.doLogin(userToken.getUsername(),
				password);

		if (null == user) {
			throw new AuthenticationException("user login fail!");
		}

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username,
				password, getName());

		return info;
	}

	public AuthenticationService getAuthcService() {
		return authcService;
	}

	public void setAuthcService(AuthenticationService authcService) {
		this.authcService = authcService;
	}

}
