package com.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.Map;

@Path("/.well-known/openid-configuration")
public class OIDCDiscovery {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getConfig() {
        return Map.of(
            "issuer", "https://your-domain.com",
            "authorization_endpoint", "https://your-domain.com/authorize",
            "token_endpoint", "https://your-domain.com/token",
            "jwks_uri", "https://your-domain.com/jwks.json",
            "response_types_supported", new String[]{"code"},
            "subject_types_supported", new String[]{"public"},
            "token_endpoint_auth_methods_supported", new String[]{"client_secret_post", "client_secret_jwt", "private_key_jwt"}
        );
    }
}