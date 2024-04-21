package output;

import java.io.FileWriter;
import java.io.IOException;

public class TextFileOutput implements Output{
    String filename;

    public TextFileOutput(String filename){
        this.filename = filename;
    }

    @Override
    public void print(String content) {
        try{
            FileWriter file = new FileWriter(filename);
            file.write(content);
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

}