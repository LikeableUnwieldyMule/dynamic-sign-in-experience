package com.example.oidc;

import io.quarkus.qute.Template;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import java.util.Map;
import java.util.stream.Collectors;

@Path("/oidc/authorize")
public class AuthorizeResource {

    @Inject
    Template authorizePage;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String get(@Context UriInfo uriInfo) {
        // Convert query parameters into a Map for Qute
        Map<String, String> queryParams = uriInfo.getQueryParameters()
            .entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey, e -> String.join(", ", e.getValue())));

        // Render the template with query parameters
        return authorizePage.data("queryParams", queryParams).render();
    }
}