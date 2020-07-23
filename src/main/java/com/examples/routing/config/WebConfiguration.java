package com.examples.routing.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import com.examples.routing.mapping.ApiVersionMappingHandlerMapping;

@Configuration
public class WebConfiguration extends DelegatingWebMvcConfiguration {

    @Override
    protected RequestMappingHandlerMapping createRequestMappingHandlerMapping() {
        return new ApiVersionMappingHandlerMapping();
    }
}
