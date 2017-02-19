package com.sjd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sjd.filters.*;

@EnableZuulProxy
@SpringBootApplication
public class ZuulProxyApplication {

    private static final Logger logger = LoggerFactory.getLogger(ZuulProxyApplication.class);

    public static void main(String[] args) {
        logger.debug ("\n\nSTARTING THE ZUUL SERVER!!\n\n");
        SpringApplication.run(ZuulProxyApplication.class, args);
    }

    @Bean
    public CustomZuulFilter customZuulFilter() {

        logger.info ("\n\nRETURNING THE FILTER!!\n\n");
        return new CustomZuulFilter();
    }
}