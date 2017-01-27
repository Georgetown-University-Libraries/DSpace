/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.dspace.services.factory.DSpaceServicesFactory;
import org.dspace.statistics.service.SolrLoggerService;

/**
 * Class that registers the web application upon startup of the application.
 *
 * @author kevinvandevelde at atmire.com
 */
public class DSpaceWebappListener2 implements ServletContextListener {

    private AbstractDSpaceWebapp webApp;
    private static final Logger log = Logger.getLogger(DSpaceWebappListener2.class);

    @Override
    public void contextInitialized(ServletContextEvent event) {
        /*
        * Register that this application is running.
        */

        log.info("TBTB dwl services init bef");
        DSpaceServicesFactory.getInstance().getServiceManager().getServiceByName("solrLoggerService", SolrLoggerService.class).initSolrYearCores();
        log.info("TBTB dwl services init aft");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        webApp.deregister();
    }
}
