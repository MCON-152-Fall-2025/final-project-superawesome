package com.mcon152.recipeshare.loader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcon152.recipeshare.domain.AppUser;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class UserDataLoaderTest {

    @Test
    void usersJsonDeserializes_usernameAndPasswordPopulated() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream is = getClass().getResourceAsStream("/data/users.json")) {
            assertNotNull(is, "users.json resource not found");
            AppUser[] users = mapper.readValue(is, AppUser[].class);
            assertTrue(users.length > 0, "No users deserialized from users.json");
            for (AppUser u : users) {
                assertNotNull(u.getUsername(), () -> "username null for user: " + u);
                assertNotNull(u.getPassword(), () -> "password null for user: " + u.getUsername());
            }
        }
    }
}

