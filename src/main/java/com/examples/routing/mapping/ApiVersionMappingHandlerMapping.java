package com.examples.routing.mapping;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import com.examples.routing.annotation.ApiVersion;

import java.lang.reflect.Method;
import java.util.Objects;

public class ApiVersionMappingHandlerMapping extends RequestMappingHandlerMapping {

    @Override
    protected RequestCondition<?> getCustomMethodCondition(Method method) {
        var ann = AnnotationUtils.findAnnotation(method, ApiVersion.class);
        if (Objects.nonNull(ann)) {
            var version = method.getAnnotation(ApiVersion.class).value();
            return new ApiVersionRequestCondition(version);
        }

        return null;
    }
}
