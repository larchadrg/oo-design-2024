import org.junit.jupiter.api.Test;
import weatherstation.CelsiusDegreesDisplay;
import weatherstation.WeatherData;

public class DisplayTest {
    @Test
    public void testCelsiusToFahrenheitConvertor(){
        CelsiusDegreesDisplay display = new CelsiusDegreesDisplay();
        float res = display.fahrenheitToCelsius(30);
    }
}
