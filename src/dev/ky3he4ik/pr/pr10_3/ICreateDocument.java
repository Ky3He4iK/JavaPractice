package dev.ky3he4ik.pr.pr10_3;

import java.io.File;

public interface ICreateDocument {
    IDocument CreateOpen(File file);

    IDocument CreateNew();
}
