package com.petproject.whatsdown.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.stream.Collectors;

public abstract class StaticTextResource extends StaticResource<String> {

    @Override
    public Type getType() {
        return String.class;
    }

    @Override
    public String getContentFromInputStream(InputStream stream) throws IOException {
        if (stream == null) {
            throw new IOException("Input stream not found");
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader
                .lines()
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public StaticTextResource(String name) {
        super(name);
    }
}