package com.petproject.whatsdown.util;

public class StaticMapResource extends StaticTextResource {

    public static final String MAP_EXTENSION_POSTFIX = "map";

    @Override
    public String getContentType() {
        return StaticJSONResource.CONTENT_TYPE_JSON_HEADER;
    }


    public StaticMapResource(String name) {
        super(name);
    }
}