/**
 * 
 */
package com.neolynx.domain;

import java.io.Serializable;

/**
 * @author nitesh.garg
 *
 */
public interface Cachable extends Serializable {

	public String getKey();

	public String getObjectKey();

}
