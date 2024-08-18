package com.petproject.whatsdown.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

public abstract class StaticByteArrayResource extends StaticResource<byte[]> {

    @Override
    public Type getType() {
        return byte[].class;
    }

    @Override
    public byte[] getContentFromInputStream(InputStream stream) throws IOException {
        if (stream == null) {
            throw new IOException("Input stream not found");
        }
        return stream.readAllBytes();
    }

    public StaticByteArrayResource(String name) {
        super(name);
    }

}
