/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.rest.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Community REST Resource
 *
 * @author Andrea Bollini (andrea.bollini at 4science.it)
 */
@LinksRest(links = {
    @LinkRest(name = CommunityRest.PARENT_COMMUNITY,
        linkClass = CommunityRest.class, method = "getSingleParentCommunity",
        optional = true),
    @LinkRest(name = CommunityRest.SUBCOMMUNITIES,
            linkClass = CommunityRest.class, method = "getSubCommunities",
            optional = true)
})
public class CommunityRest extends DSpaceObjectRest {
    public static final String NAME = "community";
    public static final String CATEGORY = RestAddressableModel.CORE;
    public static final String PARENT_COMMUNITY = "parentCommunity";
    public static final String SUBCOMMUNITIES = "subCommunities";

    @JsonIgnore
    private BitstreamRest logo;

    private List<CollectionRest> collections;

    @LinkRest(linkClass = CollectionRest.class)
    @JsonIgnore
    public List<CollectionRest> getCollections() {
        return collections;
    }

    public void setCollections(List<CollectionRest> collections) {
        this.collections = collections;
    }

    private List<CommunityRest> subcommunities;

    @LinkRest(linkClass = CommunityRest.class)
    @JsonIgnore
    public List<CommunityRest> getSubcommunities() {
        return subcommunities;
    }

    public void setSubCommunities(List<CommunityRest> subcommunities) {
        this.subcommunities = subcommunities;
    }

    public BitstreamRest getLogo() {
        return logo;
    }

    public void setLogo(BitstreamRest logo) {
        this.logo = logo;
    }

    @Override
    public String getCategory() {
        return CATEGORY;
    }

    @Override
    public String getType() {
        return NAME;
    }

}
