/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */

package org.dspace.app.util;

import java.util.Iterator;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.DefaultConfigurationBuilder;
import org.apache.commons.configuration.EnvironmentConfiguration;
import org.dspace.services.ConfigurationService;
import org.dspace.services.factory.DSpaceServicesFactory;

/**
 * Configuration tools.
 *
 * @author mwood
 */
public class ConfigurationDump
{
    /**
     * Command-line interface for running configuration tasks. Possible
     * arguments:
     * <ul>
     * <li>{@code --module name} the name of the configuration "module" for this property.</li>
     * <li>{@code --property name} prints the value of the DSpace configuration
     * property {@code name} to the standard output.</li>
     * <li>{@code --raw} suppresses parameter substitution in the output.</li>
     * <li>{@code --help} describes these options.</li>
     * </ul>
     * If the property does not exist, nothing is written.
     *
     * @param argv
     *            command-line arguments
     */
    public static void main(String[] argv)
    {
        try {
            DefaultConfigurationBuilder builder = new DefaultConfigurationBuilder("config-definition.xml");
            Configuration config = builder.getConfiguration(true);
            for(Iterator<String> keys = config.getKeys(); keys.hasNext(); ) {
                System.out.println("TBTB1 "+keys.next());
            }
            
            System.out.println("");
            
            for(Iterator<String> keys=new EnvironmentConfiguration().getKeys(); keys.hasNext();) {
                System.out.println("TBTB2 "+keys.next());
            }
            
            System.out.println("");
            
            for(String s: System.getenv().keySet()) {
                System.out.println("TBTB3 "+s);
            }
            
            System.out.println("");
            System.out.println(config.getString("dspace.foo"));
            System.out.println(config.getString("dspace.name"));
            System.out.println("");

            /*
            // Print the property's value, if it exists
            ConfigurationService cfg = DSpaceServicesFactory.getInstance().getConfigurationService();
            for(String s: cfg.getPropertyKeys()) {
                System.out.println("TBTB4 "+s);
            }
            System.out.println("");
            System.out.println(cfg.getProperty("dspace.foo"));
            System.out.println(cfg.getProperty("dspace.name"));
            */
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
