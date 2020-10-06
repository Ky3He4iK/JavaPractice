package dev.ky3he4ik.pr.pr10_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextDocument implements IDocument {
    private String data;

    public TextDocument(String data) {
        this.data = data;
    }

    public TextDocument() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public void save(String filename) throws IOException {
        Files.writeString(Paths.get(filename), data);
    }
}
