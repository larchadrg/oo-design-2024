package output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger extends Logger{
    File file;
    FileWriter writer;

    public FileLogger(String filename) {
        try{
            file = new File(filename);
            writer = new FileWriter(file,false);
        } catch (IOException e){
            System.err.println("An error occurred.");
        }

    }

    @Override
    public void print(String content) {
        try {
            writer.write(content + '\n');
            writer.flush(); // flush to ensure content is written immediately
        } catch (IOException e) {
            // Proper error handling, you might want to log the error or throw it
            e.printStackTrace();
        }
    }

}
