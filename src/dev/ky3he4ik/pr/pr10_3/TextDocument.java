package dev.ky3he4ik.pr.pr10_3;

import java.io.File;
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

    @Override
    public String getData() {
        return data;
    }

    @Override
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public void save(File file) throws IOException {
        Files.writeString(file.toPath(), data);
    }
}
