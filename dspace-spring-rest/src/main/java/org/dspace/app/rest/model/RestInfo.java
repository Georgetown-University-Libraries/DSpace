/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.rest.model;

import java.util.List;

import org.dspace.app.rest.RestResourceController;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Base REST representation for all the DSpaceObjects
 * 
 * @author Andrea Bollini (andrea.bollini at 4science.it)
 *
 */
public class RestInfo extends BaseObjectRest<String> {
	public static final String NAME = "info";

	@Override
	public String getType() {
		return NAME;
	}

	@Override
	@JsonIgnore
	public String getId() {
		return "";
	}

	public String getUuid() {
		return "";
	}

	public void setUuid(String uuid) {
	}

	public String getName() {
		return "DSpace Rest Info";
	}

	public void setName(String name) {
	}

	public String getHandle() {
		return "";
	}

	public void setHandle(String handle) {
	}

	@Override
	@JsonIgnore
	public Class getController() {
		return RestResourceController.class;
	}
}
