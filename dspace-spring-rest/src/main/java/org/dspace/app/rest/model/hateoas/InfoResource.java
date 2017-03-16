package org.dspace.app.rest.model.hateoas;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.dspace.app.rest.model.SiteRest;

@RelNameDSpaceResource("info")
public class InfoResource extends ResourceSupport {
	private String data = "info";
	private SiteRest site;
	
	public InfoResource(SiteRest site) {
		this.site = site;
	}
	
	public String getData() {
		return data;
	}

	public Link getItems() {
		return linkTo(site.getController()).withSelfRel();
	}
}
