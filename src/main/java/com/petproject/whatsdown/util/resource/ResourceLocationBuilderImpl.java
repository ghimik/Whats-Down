package com.petproject.whatsdown.util.resource;

import java.util.Collection;
import java.util.LinkedList;

public class ResourceLocationBuilderImpl implements ResourceLocationBuilder {

    private final Collection<String> locations = new LinkedList<>();

    private StaticResource resource;

    @Override
    public ResourceLocationBuilder addLocation(String location) {
        locations.add(location);
        return this;
    }

    @Override
    public ResourceLocationBuilder addResource(String name) {
        resource = StaticResource.from(name);
        return this;
    }

    @Override
    public ResourceResponseBuilder build() {
        return new ResourceResponseBuilderImpl(resource, locations);
    }
}
