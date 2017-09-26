package org.dspace.app.rest.converter;

import org.dspace.app.rest.model.RootRest;
import org.dspace.app.rest.utils.ApplicationConfig;
import org.dspace.servicemanager.config.DSpaceConfigurationService;
import org.dspace.services.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by raf on 26/09/2017.
 */
@Component
public class RootConverter {

    @Autowired
    private ConfigurationService configurationService;

    public RootRest convert(){
        RootRest rootRest = new RootRest();
        rootRest.setDspaceName(configurationService.getProperty("dspace.name"));
        rootRest.setDspaceURL(configurationService.getProperty("dspace.url"));
        return rootRest;
    }
}