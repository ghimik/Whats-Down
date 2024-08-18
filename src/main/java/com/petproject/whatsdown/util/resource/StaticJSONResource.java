package com.petproject.whatsdown.util.resource;

public class StaticJSONResource extends StaticTextResource {
    public static final String CONTENT_TYPE_JSON_HEADER = "application/json";

    public static final String JSON_EXTENSION_POSTFIX = "json";

    @Override
    public String getContentType() {
        return CONTENT_TYPE_JSON_HEADER;
    }


    public StaticJSONResource(String name) {
        super(name);
    }
}
