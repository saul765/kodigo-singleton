package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static java.util.Objects.isNull;

public class FileManager implements IFileManager {

    private static FileManager instance;


    private FileManager() {
    }

    public static FileManager getInstance() {
        if (isNull(instance)) {
            instance = new FileManager();
        }
        return instance;
    }

    @Override
    public String readFile(String path) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;
        while (!isNull(line = reader.readLine())) {
            content.append(line).append("\n");
        }
        reader.close();
        return content.toString();
    }

    @Override
    public void writeFile(String path, String content, Boolean shouldAppend) throws IOException {
        FileWriter writer = new FileWriter(path, shouldAppend);
        writer.write(content);
        writer.close();
    }
}
