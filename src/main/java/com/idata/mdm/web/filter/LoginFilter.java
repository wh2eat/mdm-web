package com.idata.mdm.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginFilter implements Filter {

    private final static Logger LOGGER = LogManager.getLogger(LoginFilter.class);

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // HttpServletRequest httpRequest = (HttpServletRequest) request;
        //
        // Object mdmUser = httpRequest.getSession().getAttribute("mdm_user");
        // if (null == mdmUser) {
        // if (LOGGER.isDebugEnabled()) {
        // LOGGER.debug("[][doFilter][not found login user info,forward to login page.]");
        // }
        // request.getRequestDispatcher("/").forward(request, response);
        // return;
        // }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

}
