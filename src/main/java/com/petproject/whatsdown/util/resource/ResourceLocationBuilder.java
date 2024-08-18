package com.petproject.whatsdown.util.resource;

public interface ResourceLocationBuilder {

    ResourceLocationBuilder addLocation(String location);

    ResourceLocationBuilder addResource(String name);

    ResourceResponseBuilder build();
}
