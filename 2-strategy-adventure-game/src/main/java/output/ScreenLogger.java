package output;

public class ScreenLogger extends Logger{
    @Override
    public void print(String content) {
        System.out.println(content);
    }
}
