package org.dspace.app.rest.projection;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.dspace.app.rest.converter.CollectionConverter;
import org.dspace.app.rest.converter.CommunityConverter;
import org.dspace.app.rest.model.CollectionRest;
import org.dspace.app.rest.model.CommunityRest;
import org.dspace.app.rest.model.DSpaceObjectRest;
import org.dspace.content.Collection;
import org.dspace.content.Community;
import org.springframework.beans.factory.annotation.Autowired;

public class CommunityProjectionApplier 
		extends DSpaceObjectProjectionApplier<org.dspace.content.Community, org.dspace.app.rest.model.CommunityRest> {
	private static final Logger log = Logger.getLogger(CommunityProjectionApplier.class);

	@Autowired(required = true)
	private CollectionConverter collectionConverter;

	@Autowired(required = true)
	private CommunityConverter communityConverter;

	@Override
	public CommunityRest applyProjection(String projection, Community obj, CommunityRest restobj) {
		if (checkProjection(projection, DSpaceObjectRest.PRJ_CONTEXT)) {
			try {
				List<CommunityRest> commrestlist = new ArrayList<>();
				for (Community c: obj.getSubcommunities()) {
					commrestlist.add(communityConverter.fromModel(c));
				}
				restobj.setSubcommunities(commrestlist);
			} catch (Exception e) {
				log.error("Error setting subcommunities for community "+restobj.getHandle(), e);
			}
			try {
				List<CollectionRest> collrestlist = new ArrayList<>();
				for (Collection c: obj.getCollections()) {
					collrestlist.add(collectionConverter.fromModel(c));
				}
				restobj.setCollections(collrestlist);
			} catch (Exception e) {
				log.error("Error setting collections for community "+restobj.getHandle(), e);
			}			
		}
		return restobj;
	}

}
