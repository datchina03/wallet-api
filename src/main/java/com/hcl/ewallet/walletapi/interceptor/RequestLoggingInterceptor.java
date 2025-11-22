package com.hcl.ewallet.walletapi.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Enumeration;

@Component
public class RequestLoggingInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(RequestLoggingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            String method = request.getMethod();
            String uri = request.getRequestURI();
            String query = request.getQueryString();
            String client = request.getRemoteAddr();

            StringBuilder sb = new StringBuilder();
            sb.append("Incoming request: ")
              .append(method).append(" ").append(uri);
            if (query != null) sb.append('?').append(query);
            sb.append(" from ").append(client).append("\n");

            sb.append("Headers:\n");
            Enumeration<String> names = request.getHeaderNames();
            if (names == null) names = Collections.emptyEnumeration();
            while (names.hasMoreElements()) {
                String name = names.nextElement();
                sb.append("  ").append(name).append(": ").append(request.getHeader(name)).append("\n");
            }

            log.info(sb.toString());
        } catch (Exception ex) {
            log.warn("Failed to log request details", ex);
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        // Optionally, log response status
        try {
            log.info("Completed request: {} {} => status={}", request.getMethod(), request.getRequestURI(), response.getStatus());
        } catch (Exception e) {
            // ignore
        }
    }
}
