/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.services.sessions.model;

import org.apache.log4j.Logger;
import org.dspace.app.util.DSpaceContextListener;
import org.dspace.services.model.Request;
import org.dspace.services.model.Session;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class HttpRequestImpl extends AbstractRequestImpl implements Request {

    private transient ServletRequest  servletRequest  = null;
    private transient ServletResponse servletResponse = null;
    private static Logger log = Logger.getLogger(HttpRequestImpl.class);

    private Session session = null;
    
    public HttpRequestImpl(ServletRequest request, ServletResponse response) {
        if (request == null || response == null) {
            throw new IllegalArgumentException("Cannot create a request without an http request or response");
        }

        this.servletRequest = request;
        this.servletResponse = response;
        if (servletRequest instanceof HttpServletRequest) {
        	log.error("HttpRequestImpl TBTB 1 "+response);
            this.session = new SessionImpl((HttpServletRequest)servletRequest);
        } else {
        	log.error("HttpRequestImpl TBTB 2 "+response);
            this.session = new SessionImpl();
        }
    }

    public ServletRequest getServletRequest() {
        return servletRequest;
    }

    public HttpServletRequest getHttpServletRequest() {
        if (servletRequest instanceof HttpServletRequest) {
            return (HttpServletRequest)servletRequest;
        }

        return null;
    }

    public Session getSession() {
        return session;
    }

    public ServletResponse getServletResponse() {
        return servletResponse;
    }

    public HttpServletResponse getHttpServletResponse() {
        if (servletResponse instanceof HttpServletResponse) {
            return (HttpServletResponse)servletResponse;
        }

        return null;
    }

    public Object getAttribute(String name) {
        return servletRequest.getAttribute(name);
    }

    public void setAttribute(String name, Object o) {
        servletRequest.setAttribute(name, o);
    }
}
