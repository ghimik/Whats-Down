package com.petproject.whatsdown.util;

public class StaticJavaScriptResource extends StaticTextResource {
    public static final String CONTENT_TYPE_JS_HEADER = "text/javascript";

    public static final String JS_EXTENSION_POSTFIX = "js";


    @Override
    public String getContentType() {
        return CONTENT_TYPE_JS_HEADER;
    }


    public StaticJavaScriptResource(String name) {
        super(name);
    }
}
