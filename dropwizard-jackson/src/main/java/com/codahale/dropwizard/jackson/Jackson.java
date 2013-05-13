package com.codahale.dropwizard.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;

/**
 * A utility class for Jackson.
 */
public class Jackson {
    private Jackson() { /* singleton */ }

    /**
     * Creates a new {@link ObjectMapper} with Guava, Logback, and Joda Time support, as well as
     * support for {@link JsonSnakeCase}.
     */
    public static ObjectMapper newObjectMapper() {
        final ObjectMapper mapper = new ObjectMapper();

        mapper.registerModule(new GuavaModule());
        mapper.registerModule(new LogbackModule());
        mapper.registerModule(new GuavaExtrasModule());
        mapper.registerModule(new JodaModule());

        mapper.registerModule(new AfterburnerModule());

        mapper.setPropertyNamingStrategy(new AnnotationSensitivePropertyNamingStrategy());

        return mapper;
    }
}
