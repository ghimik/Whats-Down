package com.petproject.whatsdown.util.resource;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.stream.Collectors;

public class ResourceResponseBuilderImpl implements ResourceResponseBuilder {

    private static final String PATH_SEPARATOR = "/";

    private static final String RESOURCE_PREFIX = "src/main/resources";

    private Collection<String> locations;

    private StaticResource resource;

    private final HttpHeaders headers = new HttpHeaders();


    public ResourceResponseBuilderImpl(StaticResource resource, Collection<String> locations) {
        this.resource = resource;
        this.locations = locations;
        fillHeaders();
    }

    private void fillHeaders() {
        headers.add(StaticResource.CONTENT_TYPE_HEADER, resource.getContentType());
    }

    private String getLocationsPath() {
        return locations
                .stream()
                .map(loc -> loc + PATH_SEPARATOR)
                .collect(Collectors.joining());
    }

    private Path parsePath() {
        return Paths.get(RESOURCE_PREFIX, getLocationsPath(), resource.getName());
    }

    @Override
    public ResponseEntity<Object> getResponse() {
        Path path = parsePath();
        try (InputStream inputStream = new FileSystemResource(path).getInputStream()) {
            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .body(resource.getContentFromInputStream(inputStream));
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error reading resource: " + e.getMessage());
        }
    }
}
