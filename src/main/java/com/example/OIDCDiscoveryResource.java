package com.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

import org.eclipse.microprofile.config.inject.ConfigProperty;


@Path("/.well-known/openid-configuration")
public class OIDCDiscoveryResource {

    @ConfigProperty(name = "idp.issuer")
    String issuer;

    @ConfigProperty(name = "idp.authorization_endpoint")
    String authorization_endpoint;
    
    @ConfigProperty(name = "idp.token_endpoint")
    String token_endpoint;

    @ConfigProperty(name = "idp.jwks_uri")
    String jwks_uri;

    @ConfigProperty(name = "idp.response_types_supported")
    List<String> response_types_supported;

    @ConfigProperty(name = "idp.subject_types_supported")
    List<String> subject_types_supported;

    @ConfigProperty(name = "idp.token_endpoint_auth_methods_supported")
    List<String> token_endpoint_auth_methods_supported;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public OIDCDiscovery getConfig() {
        return new OIDCDiscovery(
            issuer,
            authorization_endpoint,
            token_endpoint,
            jwks_uri,
            response_types_supported,
            subject_types_supported,
            token_endpoint_auth_methods_supported
        );
    }
}