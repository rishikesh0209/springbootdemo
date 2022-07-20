package com.demoproject.springbootdemo.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

@Component
public class CustomLoggingFilter extends OncePerRequestFilter {
    private static final Logger LOG = LoggerFactory.getLogger(CustomLoggingFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);

        long startTime = System.currentTimeMillis();
        filterChain.doFilter(requestWrapper, responseWrapper);
        long timeTaken = System.currentTimeMillis() - startTime;

        String requestBody = getStringValue(requestWrapper.getContentAsByteArray(),
                request.getCharacterEncoding());

        String responseBody = getStringValue(responseWrapper.getContentAsByteArray(),
                response.getCharacterEncoding());

        String req_ip = request.getRemoteAddr();
        Long res_time = timeTaken;
        String req_protocol = request.getScheme();
        String req_url = request.getRequestURI();
        String req_method = request.getMethod();
        String req_host = request.getServerName();
        String req_header = getRequestHeadersParsed(request);
        String req_query = request.getQueryString();
        Integer res_status_code = response.getStatus();
        String res_status_message = "res_status_message";
        String app_env = "development";
        // Map<String, String> test = new HashMap<>();
        // test.put("req_body",requestBody);
        // test.put("app_env",app_env);
        LOG.info(
                "- info: {'req_host':'{}';'req_ip':'{}';'req_method':'{}';'req_headers':'{}','req_protocol':'{}';'req_url':'{}';'req_query':'{}';'req_status':'{}';'req_body':{};'app_env':'{}'}",
                req_host, req_ip, req_method, req_header, req_protocol, req_url, req_query, "REQUESTED", requestBody,
                app_env);

        LOG.info(
                "- info: {app_env:{};res_time:{};status:{};res_status_code:{};res_status_message:{};req_ip:{};req_protocol:{};req_url:{};req_query:{};req_method:{};req_host:{};req_body:{},req_header:{}}",
                app_env, res_time, "RESPONDED", res_status_code, res_status_message, req_ip, req_protocol, req_url,
                req_query, req_method, req_host, requestBody, req_header);
        // log request
        responseWrapper.copyBodyToResponse();
    }

    private String getStringValue(byte[] contentAsByteArray, String characterEncoding) {
        try {
            return new String(contentAsByteArray, 0, contentAsByteArray.length, characterEncoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String getRequestHeadersParsed(HttpServletRequest request) {
        Map<String, Object> returnValue = new HashMap<>();

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            returnValue.put(headerName, request.getHeader(headerName));
        }
        return returnValue.toString();
    }

}
