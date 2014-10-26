/**
 * 
 */
package com.neolynx.domain.impl;

import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

import com.neolynx.domain.Cachable;

/**
 * @author nitesh.garg
 *
 */

@AllArgsConstructor(access = AccessLevel.PUBLIC)
public @Data class User implements Cachable {

	private static final long serialVersionUID = -3540087792095045630L;

	public static final String OBJECT_KEY = "USER";

	private Long id;
	private String user_id;
	private String password;
	private Date lastUpdateOn;
	private Date createdOn;
	private String lastUpdateBy;

	public String getKey() {
		return getId().toString();
	}

	public String getObjectKey() {
		return OBJECT_KEY;
	}

}
