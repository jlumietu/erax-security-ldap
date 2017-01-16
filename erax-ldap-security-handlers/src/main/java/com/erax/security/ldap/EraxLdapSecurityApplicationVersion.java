/**
 * 
 */
package com.erax.security.ldap;

import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

import com.erax.version.VersionInfo;
import com.erax.version.VersionInfoBase;

/**
 * @author jlumietu
 *
 */
public class EraxLdapSecurityApplicationVersion implements Serializable {

	public static final long APP_VERSION = 1L;
	
	private static final String LIBRARY_PROPERTIES_FILE = "properties/net.iberdok.iberdok-io.properties";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = APP_VERSION;
	
	private Properties libraryVersionProperties;
	
	private VersionInfo versionInfo;

	/**
	 * 
	 */
	public EraxLdapSecurityApplicationVersion() {
		super();
		this.loadDefaultProperties();
	}
	
	/**
	 * 
	 * @param properties
	 */
	public EraxLdapSecurityApplicationVersion(Properties properties) {
		super();
		this.loadProperties();
	}
	
	/**
	 * 
	 * @param libraryName
	 * @param libraryVersion
	 */
	public EraxLdapSecurityApplicationVersion(String libraryName, String libraryVersion) {
		super();
		this.versionInfo = new VersionInfoBase(libraryName, libraryVersion);
	}

	/**
	 * 
	 */
	protected void loadDefaultProperties() {
		this.libraryVersionProperties = new Properties();
		try {
			this.libraryVersionProperties.load(
					this.getClass().getClassLoader().getResourceAsStream(LIBRARY_PROPERTIES_FILE)
				);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.loadProperties();
		
	}

	/**
	 * 
	 */
	protected void loadProperties() {
		this.versionInfo = new VersionInfoBase(this.libraryVersionProperties); 		
	}

	/**
	 * 
	 * @return
	 */
	public VersionInfo getVersionInfo() {
		return versionInfo;
	}


}
