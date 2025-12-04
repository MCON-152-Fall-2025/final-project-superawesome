package com.mcon152.recipeshare.domain;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * Custom serializer for AppUser that only exposes safe fields (id, displayName)
 * and excludes sensitive fields like username and password.
 */
public class AppUserSerializer extends JsonSerializer<AppUser> {

    @Override
    public void serialize(AppUser user, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("id", user.getId());
        gen.writeStringField("displayName", user.getDisplayName());
        gen.writeEndObject();
    }
}

