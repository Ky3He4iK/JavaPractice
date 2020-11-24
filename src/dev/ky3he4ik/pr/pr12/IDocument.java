package dev.ky3he4ik.pr.pr12;

import java.io.File;
import java.io.IOException;

public interface IDocument {
    void save(File file) throws IOException;
    void setData(String data);
    String getData();
}
