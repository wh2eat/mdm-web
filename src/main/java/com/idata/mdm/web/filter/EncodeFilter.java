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

public class EncodeFilter implements Filter {

    private final static Logger LOGGER = LogManager.getLogger(EncodeFilter.class);

    public EncodeFilter() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("[][doFilter][requestCharacterEncoding:" + request.getCharacterEncoding()
                    + ";responseCharacterEncoding:" + response.getCharacterEncoding() + "]");
        }
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("[][doFilter][set request and response CharacterEncoding to utf-8]");
        }
        chain.doFilter(request, response);

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

}
