package com.bhargo.reader;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

public interface Reader {

    Stream<String> readAsStream(File file) throws IllegalArgumentException, IOException;
    String readWholeAsString(File file);
}
