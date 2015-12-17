/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.rest.common;

import org.codehaus.jackson.annotate.JsonProperty;
import org.dspace.core.Context;
import org.dspace.eperson.EPerson;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Used to handle/determine status of REST API.
 * Mainly to know your authentication status
 *
 */
@XmlRootElement(name = "status")
public class Status
{
    private boolean okay;
    private boolean authenticated;
    private String email;
    private String fullname;

    public Status() {
        setOkay(true);
        setAuthenticated(false);
    }

    public Status(String email, String fullname) {
        setOkay(true);
        setAuthenticated(true);
        setEmail(email);
        setFullname(fullname);
    }

    public Status(EPerson eperson) {
        setOkay(true);
        if(eperson != null) {
            setAuthenticated(true);
            setEmail(eperson.getEmail());
            setFullname(eperson.getFullName());
        } else {
            setAuthenticated(false);
        }
    }

    @JsonProperty("okay")
    public boolean isOkay()
    {
        return this.okay;
    }

    @JsonProperty("okay")
    public void setOkay(boolean okay)
    {
        this.okay = okay;
    }

    @JsonProperty("authenticated")
    public boolean isAuthenticated() {
        return authenticated;
    }

    @JsonProperty("authenticated")
    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("fullname")
    public String getFullname() {
        return fullname;
    }

    @JsonProperty("fullname")
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
