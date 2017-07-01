package com.bhargo.reader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader implements Reader {

    /**
     *
     * @param file, absolute path
     * @return a stream of the content of the file
     * @throws IllegalArgumentException
     * @throws IOException
     */
    @Override
    public Stream<String> readAsStream(File file) throws IllegalArgumentException, IOException {
        if(file.isFile()) {
            return Files.lines(Paths.get(file.getAbsolutePath())).skip(1);
        }
        throw new IllegalArgumentException("Argument should be a absolute file name");
    }

    /**
     *should not be used
     * @param file
     * @return
     */
    @Deprecated
    @Override
    public String readWholeAsString(File file) {
        return null;
    }
}
