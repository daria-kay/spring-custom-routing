package com.examples.routing.mapping;

import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.mvc.condition.AbstractRequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@RequiredArgsConstructor
public class ApiVersionRequestCondition extends AbstractRequestCondition<ApiVersionRequestCondition> {

    private final String version;

    @Override
    protected Collection<?> getContent() {
        return Collections.singleton(version);
    }

    @Override
    protected String getToStringInfix() {
        return "";
    }

    @Override
    public ApiVersionRequestCondition combine(ApiVersionRequestCondition apiVersionRequestCondition) {
        var version = this.version.compareTo(apiVersionRequestCondition.version) > 0 ?
                apiVersionRequestCondition.version : this.version;

        return new ApiVersionRequestCondition(version);
    }

    @Override
    public ApiVersionRequestCondition getMatchingCondition(javax.servlet.http.HttpServletRequest httpServletRequest) {
        var acceptHeader = httpServletRequest.getHeader("Accept");
        if (Objects.nonNull(acceptHeader) && acceptHeader.matches("application/v[0-9]\\+json")) {
            return acceptHeader.substring(12, 14).compareTo(version) >= 0 ? this : null;
        }

        return null;
    }

    @Override
    public int compareTo(ApiVersionRequestCondition other, HttpServletRequest request) {
        return other.version.compareTo(this.version);
    }
}
