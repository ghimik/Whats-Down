package com.petproject.whatsdown.controller.mvc;

import com.petproject.whatsdown.util.resource.ResourceLocationBuilderImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/static")
public class StaticResourceController {

    @RequestMapping("/**")
    public ResponseEntity<Object> handleStaticResource(HttpServletRequest request) {
        String requestURI = request.getRequestURI();

        String resourcePath = requestURI.startsWith("/") ?
                requestURI.substring(1) : requestURI;

        String[] pathParts = resourcePath.split("/");

        var builder = new ResourceLocationBuilderImpl();

        if (pathParts.length == 0 || (pathParts.length == 1 && pathParts[0].isEmpty())) {
            return ResponseEntity.notFound().build();
        }

        for (int i = 0; i < pathParts.length - 1; i++) {
            builder.addLocation(pathParts[i]);
        }

        builder.addResource(pathParts[pathParts.length - 1]);

        return builder.build().getResponse();
    }
}
