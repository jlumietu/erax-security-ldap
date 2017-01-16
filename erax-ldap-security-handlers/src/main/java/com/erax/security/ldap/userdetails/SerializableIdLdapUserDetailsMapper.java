/**
 * 
 */
package com.erax.security.ldap.userdetails;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.LdapUserDetails;
import org.springframework.security.ldap.userdetails.LdapUserDetailsMapper;
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;

/**
 * @author jlumietu
 *
 */
public class SerializableIdLdapUserDetailsMapper extends LdapUserDetailsMapper implements UserDetailsContextMapper {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	public SerializableIdLdapUserDetailsMapper() {
		super();
		logger.debug("Instance constructor called");
	}



	@Override
	public UserDetails mapUserFromContext(DirContextOperations ctx, String username,
			Collection<? extends GrantedAuthority> authorities) {
		UserDetails userDetails = super.mapUserFromContext(ctx, username, authorities);
		logger.debug("userDetails of class " + userDetails.getClass().getName() + " recovered from superclass");
		if(userDetails instanceof LdapUserDetails){
			logger.debug("userDetails is instance of class " + LdapUserDetails.class.getName());
			SerializableIdLdapUserDetailsWrapperImpl returnableUserDetails = 
				new SerializableIdLdapUserDetailsWrapperImpl((LdapUserDetails)userDetails);
			logger.debug("Returning LdapUserDetails wrapper of class " + returnableUserDetails.getClass().getName());
			return returnableUserDetails;
		}
		logger.debug("Returning default super generated " + userDetails.getClass().getName());
		return userDetails;
	}

	
	
}
