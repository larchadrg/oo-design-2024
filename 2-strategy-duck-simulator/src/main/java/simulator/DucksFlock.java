package simulator;

import output.Output;
import output.Terminal;

import java.util.ArrayList;
import java.util.List;

public class DucksFlock {
    List<Duck> duckList;
    Output output;

    public DucksFlock(List<Duck> duckList, Output output){
        this.duckList = duckList;
        this.output = output;
    }

    public void fly(){
        if(duckList.isEmpty()) System.out.println("There are no ducks");
        for(Duck d: duckList){
            d.performFly();
        }
    }

    public void quack(){
        if(duckList.isEmpty()) System.out.println("Can't hear anything");
        for(Duck d: duckList){
            d.performQuack();
        }
    }
}
