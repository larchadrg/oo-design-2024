package logger;

public class MockLogger implements ILogger{
    private boolean invoked = false;
    @Override
    public void write(int result) {
        invoked = true;
        if(result != 35) // example
            throw new Error("Invalid mock call");
    }

    public boolean isInvoked() {
        return invoked;
    }
}
