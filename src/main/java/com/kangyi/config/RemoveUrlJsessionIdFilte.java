package com.kangyi.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
@WebFilter(urlPatterns = "/*", filterName = "RemoveUrlJsessionIdFilte")
public class RemoveUrlJsessionIdFilte implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest reqs = (HttpServletRequest) req;

        if (!(req instanceof HttpServletRequest)) {
            chain.doFilter(req, response);
            return;
        }

        //从url中删除jsessionid
        // isRequestedSessionIdFromURL():Checks whether the requested session ID came in as part of the request URL.
        if (reqs.isRequestedSessionIdFromURL()) {
            HttpSession session = reqs.getSession();
            if (null != session) {
                session.invalidate();
            }
        }

        // wrap response to remove URL encoding
        HttpServletResponseWrapper wrappedResponse = new HttpServletResponseWrapper(response) {
            @Override
            public String encodeRedirectUrl(String url) {
                return url;
            }
            @Override
            public String encodeRedirectURL(String url) {
                return url;
            }
            @Override
            public String encodeUrl(String url) {
                return url;
            }
            @Override
            public String encodeURL(String url) {
                return url;
            }
        };




//        String curOrigin = reqs.getHeader("Origin");
//        response.setHeader("Access-Control-Allow-Origin", curOrigin == null ? "true" : curOrigin);
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PATCH, DELETE, PUT");
//        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
//        chain.doFilter(req, res);

        chain.doFilter(req, wrappedResponse);

    }


    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {}

}
