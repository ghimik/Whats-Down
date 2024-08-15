package com.petproject.whatsdown.controllers.mvc;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/static")
public class StaticResourceController {

    @GetMapping("/{pageName}/{type}/{resourceName}")
    public ResponseEntity<String> resource(@PathVariable String pageName,
                                           @PathVariable String type,
                                           @PathVariable String resourceName) {
        var path = Paths.get("src/main/resources/static", pageName, type, resourceName).toString();
        ResourceResponseBuilder builder = new ResourceResponseBuilder();
        return builder.path(path).type(type).returnResource();

    }

    @GetMapping("/{pageName}/{resourceName}")
    public ResponseEntity<String> anotherResource(@PathVariable String pageName,
                                                  @PathVariable String resourceName) {
        var path = Paths.get("src/main/resources/static", pageName, resourceName).toString();
        ResourceResponseBuilder builder = new ResourceResponseBuilder();
        return builder.path(path).returnResource();
    }

    private class ResourceResponseBuilder {
        private String path;

        private String type;

        private HttpHeaders headers = new HttpHeaders();

        public ResourceResponseBuilder path(String path) {
            this.path = path;
            return this;
        }

        public ResourceResponseBuilder type(String type) {
            this.type = type;
            if (type.equals("js"))
                headers.add("Content-Type", "text/javascript");
            if (type.equals("css"))
                headers.add("Content-Type", "text/css");

            return this;
        }

        public ResponseEntity<String> returnResource() {

            try (InputStream inputStream = new FileSystemResource(path).getInputStream()) {
                if (inputStream == null) {
                    return ResponseEntity.notFound().build();
                }
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String contents = reader.lines()
                        .collect(Collectors.joining(System.lineSeparator()));
                return ResponseEntity.ok().headers(headers).body(contents);
            } catch (IOException e) {
                return ResponseEntity.status(500).body("Error reading resource: " + e.getMessage());
            }
        }
    }


}