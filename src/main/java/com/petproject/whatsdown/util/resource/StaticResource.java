package com.petproject.whatsdown.util.resource;

import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.io.InputStream;

public abstract class StaticResource<T> {

    public static final String CONTENT_TYPE_HEADER = "Content-Type";

    public abstract String getContentType();

    public abstract T getContentFromInputStream(InputStream stream) throws IOException;

    private String name;

    public static StaticResource from(String s) {

        String extension = FilenameUtils.getExtension(s);

        return switch (extension) {
            case StaticCSSResource.CSS_EXTENSION_POSTFIX -> new StaticCSSResource(s);
            case StaticJavaScriptResource.JS_EXTENSION_POSTFIX -> new StaticJavaScriptResource(s);
            case StaticJSONResource.JSON_EXTENSION_POSTFIX -> new StaticJSONResource(s);
            case StaticMapResource.MAP_EXTENSION_POSTFIX -> new StaticMapResource(s);
            case StaticIconResource.ICO_EXTENSION_POSTFIX -> new StaticIconResource(s);

            default -> throw new IllegalArgumentException("File type is not defined");
        };

    }

    public String getName() {
        return this.name;
    }

    public StaticResource(String name) {
        this.name = name;
    }

    public StaticResource() {
    }
}
