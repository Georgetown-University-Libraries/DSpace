package org.dspace.app.rest.model.hateoas;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RelNameDSpaceResource("info")
public class InfoResource extends ResourceSupport {
	private String data = "info";
	
	public String getData() {
		return data;
	}

	public Link getItems() {
		return linkTo(String.class, "/api/core/items").withRel("");
	}
}
