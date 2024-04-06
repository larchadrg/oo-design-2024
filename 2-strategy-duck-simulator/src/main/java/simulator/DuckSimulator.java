package simulator;

public class DuckSimulator {
 
	public static void main(String[] args) {
		Duck mallard = new MallardDuck(mockOutput);
		mallard.performQuack();
		mallard.performFly();
   
		Duck model = new ModelDuck();
		model.performFly();
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();
	}

}
