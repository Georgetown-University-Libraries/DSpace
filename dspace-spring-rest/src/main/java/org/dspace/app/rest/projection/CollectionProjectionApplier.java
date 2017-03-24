package org.dspace.app.rest.projection;

import org.apache.log4j.Logger;
//import org.dspace.app.rest.converter.CollectionConverter;
//import org.dspace.app.rest.converter.CommunityConverter;
import org.dspace.app.rest.model.CollectionRest;
import org.dspace.content.Collection;
//import org.springframework.beans.factory.annotation.Autowired;

public class CollectionProjectionApplier 
		extends DSpaceObjectProjectionApplier<org.dspace.content.Collection, org.dspace.app.rest.model.CollectionRest> {
	//private static final Logger log = Logger.getLogger(CollectionProjectionApplier.class);

	//@Autowired(required = true)
	//private CollectionConverter collectionConverter;

	//@Autowired(required = true)
	//private CommunityConverter communityConverter;

	@Override
	public CollectionRest applyProjection(String projection, Collection obj, CollectionRest restobj) {
		return restobj;
	}

}
