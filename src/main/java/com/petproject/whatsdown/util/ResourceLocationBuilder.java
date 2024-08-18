package com.petproject.whatsdown.util;

public interface ResourceLocationBuilder {

    ResourceLocationBuilder addLocation(String location);

    ResourceLocationBuilder addResource(String name);

    ResourceResponseBuilder build();
}
