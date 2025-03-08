package com.example;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class OIDCDiscovery {

    public String issuer;

    @JsonProperty("authorization_endpoint")
    public String authorizationEndpoint;

    @JsonProperty("token_endpoint")
    public String tokenEndpoint;

    @JsonProperty("jwks_uri")
    public String jwksUri;

    @JsonProperty("response_types_supported")
    public List<String> responseTypesSupported;

    @JsonProperty("subject_types_supported")
    public List<String> subjectTypesSupported;

    @JsonProperty("token_endpoint_auth_methods_supported")
    public List<String> tokenEndpointAuthMethodsSupported;

    // Constructor
    public OIDCDiscovery() {}

    public OIDCDiscovery(String issuer, String authorizationEndpoint, String tokenEndpoint, String jwksUri,
                         List<String> responseTypesSupported, List<String> subjectTypesSupported,
                         List<String> tokenEndpointAuthMethodsSupported) {
        this.issuer = issuer;
        this.authorizationEndpoint = authorizationEndpoint;
        this.tokenEndpoint = tokenEndpoint;
        this.jwksUri = jwksUri;
        this.responseTypesSupported = responseTypesSupported;
        this.subjectTypesSupported = subjectTypesSupported;
        this.tokenEndpointAuthMethodsSupported = tokenEndpointAuthMethodsSupported;
    }
}