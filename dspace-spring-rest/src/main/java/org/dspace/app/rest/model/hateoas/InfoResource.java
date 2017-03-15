package org.dspace.app.rest.model.hateoas;

import org.springframework.hateoas.ResourceSupport;

@RelNameDSpaceResource("info")
public class InfoResource extends ResourceSupport {
	private String data = "info";
	public String getData() {
		return data;
	}
}
