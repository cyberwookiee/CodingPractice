package com.brymanco.bogglesolver.impl;

import com.brymanco.bogglesolver.Dictionary;
import com.brymanco.bogglesolver.DictionaryLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DictionaryLoaderImpl implements DictionaryLoader {

    @Override
    public Dictionary load(final File file)
            throws FileNotFoundException, IOException {
        return load(file.toPath());
    }

    @Override
    public Dictionary load(URI file) throws FileNotFoundException, IOException {
        return load(Paths.get(file));
    }

    @Override
    public Dictionary load(Path file) throws FileNotFoundException, IOException {
        final Dictionary dictionary = new TrieDictionaryImpl();

        try (Stream<String> stream = Files.lines(file)) {
            stream.forEach(dictionary::addWord);
        }

        return dictionary;
    }

}
