package org.dspace.app.rest.projection;

import org.dspace.app.rest.model.DSpaceObjectRest;
import org.dspace.content.DSpaceObject;

public class DSpaceObjectProjectionApplier<M extends DSpaceObject,R extends DSpaceObjectRest> {
	public void applyProjection(String projection, M obj, R restobj) {
	}
	public boolean checkProjection(String projection, String value) {
		if (projection == null) {
			return false;
		}
		for (String s: projection.split(",")) {
			if (s.equals(value)) {
				return true;
			}
		}
		return false;
	}
}
