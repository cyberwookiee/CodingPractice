package com.brymanco.bogglesolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;

public interface DictionaryLoader {

    Dictionary load(File file)
            throws FileNotFoundException, IOException;

    Dictionary load(URI file)
            throws FileNotFoundException, IOException;

    Dictionary load(Path file)
            throws FileNotFoundException, IOException;

}
