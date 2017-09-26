package org.dspace.app.rest.repository;

import org.dspace.app.rest.converter.RootConverter;
import org.dspace.app.rest.model.RootRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by raf on 26/09/2017.
 */
@Component
public class RootRestRepository {

    @Autowired
    RootConverter rootConverter;

    public RootRest getRoot(){
        return rootConverter.convert();
    }
}