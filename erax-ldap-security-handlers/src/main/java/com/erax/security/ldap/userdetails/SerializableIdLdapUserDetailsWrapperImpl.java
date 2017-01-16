/**
 * 
 */
package com.erax.security.ldap.userdetails;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.ldap.userdetails.LdapUserDetails;

import com.eej.security.handler.model.UserRepositorySerializableId;
import com.erax.security.ldap.EraxLdapSecurityApplicationVersion;

/**
 * @author jlumietu
 *
 */
public class SerializableIdLdapUserDetailsWrapperImpl implements LdapUserDetails, UserRepositorySerializableId {

	private final LdapUserDetails innerLdapUserDetails;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = EraxLdapSecurityApplicationVersion.APP_VERSION;

	public SerializableIdLdapUserDetailsWrapperImpl(LdapUserDetails userDetails) {
		this.innerLdapUserDetails = userDetails;
	}

	/* (non-Javadoc)
	 * @see com.erax.principal.PrincipalSerializableId#getId()
	 */
	public Serializable getId() {
		return this.getUsername();
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.innerLdapUserDetails.getAuthorities();
	}

	public String getPassword() {
		return this.innerLdapUserDetails.getPassword();
	}

	public String getUsername() {
		return this.innerLdapUserDetails.getUsername();
	}

	public boolean isAccountNonExpired() {
		return this.innerLdapUserDetails.isAccountNonExpired();
	}

	public boolean isAccountNonLocked() {
		return this.innerLdapUserDetails.isAccountNonLocked();
	}

	public boolean isCredentialsNonExpired() {
		return this.innerLdapUserDetails.isCredentialsNonExpired();
	}

	public boolean isEnabled() {
		return this.isEnabled();
	}

	public void eraseCredentials() {
		this.innerLdapUserDetails.eraseCredentials();
	}

	public String getDn() {
		return this.innerLdapUserDetails.getDn();
	}

}
