package com.petproject.whatsdown.util.resource;

public class StaticIconResource extends StaticByteArrayResource {

    public static final String CONTENT_TYPE_ICO_HEADER = "image/x-icon";
    public static final String ICO_EXTENSION_POSTFIX = "ico";

    @Override
    public String getContentType() {
        return CONTENT_TYPE_ICO_HEADER;
    }


    public StaticIconResource(String name) {
        super(name);
    }
}
