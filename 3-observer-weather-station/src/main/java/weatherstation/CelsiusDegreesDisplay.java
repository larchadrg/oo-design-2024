package weatherstation;

public class CelsiusDegreesDisplay implements Observer, DisplayElement{
    float curr_temp;
    @Override
    public void update(float temp, float humidity, float pressure) {
        curr_temp = fahrenheitToCelsius(temp);
        display();
    }

    @Override
    public void display() {
        System.out.println("Current temperature is " + curr_temp + "Celsius degrees.");
    }

    float fahrenheitToCelsius(float temp){
        return  (temp - 32) * 5 /9;
    }
}
