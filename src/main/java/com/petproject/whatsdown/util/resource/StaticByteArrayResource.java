package com.petproject.whatsdown.util.resource;

import java.io.IOException;
import java.io.InputStream;

public abstract class StaticByteArrayResource extends StaticResource<byte[]> {

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
