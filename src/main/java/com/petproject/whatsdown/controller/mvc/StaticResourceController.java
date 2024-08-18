package com.petproject.whatsdown.controller.mvc;

import com.petproject.whatsdown.util.ResourceLocationBuilderImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// фав айкон ебуча
// sw.js


@Controller
public class StaticResourceController {

    @GetMapping("/{type}/{resourceName}")
    public ResponseEntity<String> resource(@PathVariable String type,
                                           @PathVariable String resourceName) {
        var builder = new ResourceLocationBuilderImpl();
        return builder.addLocation(type).addResource(resourceName).build().getResponse();

    }

    @GetMapping("/{resourceName}")
    public ResponseEntity<String> anotherResource(@PathVariable String resourceName) {
        var builder = new ResourceLocationBuilderImpl();
        return builder.addResource(resourceName).build().getResponse();
    }


}