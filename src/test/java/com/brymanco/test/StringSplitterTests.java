package com.brymanco.test;

import com.brymanco.bogglesolver.Dictionary;
import com.brymanco.bogglesolver.DictionaryLoader;
import com.brymanco.bogglesolver.impl.DictionaryLoaderImpl;
import com.brymanco.strings.IStringSplitter;
import com.brymanco.strings.impl.StringSplitter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringSplitterTests {

    @Test
    public void verifyStringSplitter() throws URISyntaxException, IOException {
        final DictionaryLoader loader = new DictionaryLoaderImpl();

        final URL wordsUrl = this.getClass().getResource("/words.txt");

        System.out.println("Loading dictionary...");

        final Dictionary dictionary = loader.load(wordsUrl.toURI());

        System.out.println("...Done Loading dictionary.");

        IStringSplitter splitter = new StringSplitter(dictionary);

        List<String> phrases = splitter.splitString("catsanddogshavefun");

        Assertions.assertEquals(6, phrases.size());

        phrases.stream().forEach(System.out::println);

    }

}
