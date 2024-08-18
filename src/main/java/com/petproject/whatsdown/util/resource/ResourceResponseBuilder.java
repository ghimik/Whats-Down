package com.petproject.whatsdown.util.resource;

import org.springframework.http.ResponseEntity;

public interface ResourceResponseBuilder {

    ResponseEntity<Object> getResponse();
}
