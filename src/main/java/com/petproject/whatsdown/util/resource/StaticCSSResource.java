package com.petproject.whatsdown.util.resource;

public class StaticCSSResource extends StaticTextResource {

    public static final String CONTENT_TYPE_CSS_HEADER = "text/css";

    public static final String CSS_EXTENSION_POSTFIX = "css";

    @Override
    public String getContentType() {
        return CONTENT_TYPE_CSS_HEADER;
    }

    public StaticCSSResource(String name) {
        super(name);
    }


}
