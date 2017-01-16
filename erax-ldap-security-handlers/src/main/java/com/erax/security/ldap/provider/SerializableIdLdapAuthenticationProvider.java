/**
 * 
 */
package com.erax.security.ldap.provider;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;
import org.springframework.security.ldap.authentication.LdapAuthenticator;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;

/**
 * @author jlumietu
 *
 */
@Deprecated
public class SerializableIdLdapAuthenticationProvider extends LdapAuthenticationProvider {

	public SerializableIdLdapAuthenticationProvider(LdapAuthenticator authenticator,
			LdapAuthoritiesPopulator authoritiesPopulator) {
		super(authenticator, authoritiesPopulator);
	}

	public SerializableIdLdapAuthenticationProvider(LdapAuthenticator authenticator) {
		super(authenticator);		
	}

	@Override
	protected Authentication createSuccessfulAuthentication(UsernamePasswordAuthenticationToken authentication,
			UserDetails user) {
		// TODO Auto-generated method stub
		return super.createSuccessfulAuthentication(authentication, user);
	}
	
	

	

}
