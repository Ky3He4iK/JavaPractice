package dev.ky3he4ik.pr.pr10_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TextCreateDocument implements ICreateDocument {
    @Override
    public IDocument CreateOpen(String filename) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filename));
            StringBuilder sb = new StringBuilder();
            for (String line: lines)
                sb.append(line).append('\n');

            return new TextDocument(sb.toString());
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public IDocument CreateNew() {
        return new TextDocument();
    }
}
