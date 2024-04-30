package utils;

import java.io.IOException;

public interface IFileManager {

    String readFile(String path) throws IOException;

    void writeFile(String path, String content, Boolean shouldAppend) throws IOException;
}
