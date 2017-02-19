package com.sjd.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class CustomZuulFilter extends ZuulFilter {
 
    private static final Logger logger = LoggerFactory.getLogger(CustomZuulFilter.class);

    // https://github.com/Netflix/zuul/wiki/Writing-Filters
    // https://spring.io/guides/gs/routing-and-filtering/

    static {
        logger.info("\n\nLOADED UP THE CUSTOM FILTER!!n\n\n");        
    }

    @Override
    public Object run() {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        logger.info(String.format("\n\n%s request to %s\n\n", request.getMethod(), request.getRequestURL().toString()));

        return null;
    }
 
    @Override
    public boolean shouldFilter() {
       return true;
    }
    
    @Override
    public int filterOrder () {
        return 1;
    }

    @Override
    public String filterType () {
        return "pre"; // pre, routing, post
    }
}