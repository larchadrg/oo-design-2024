package decorator.starbuzz;

import java.util.Map;
import static decorator.starbuzz.BeverageSize.*;
import static java.util.Map.entry;

public class Whip extends CondimentDecorator {
	public Whip(Beverage beverage) {
		super(beverage);
		costBySize = Map.ofEntries(
				entry(BIG, .20),
				entry(MEDIUM,.15),
				entry(SMALL,.10)
		);
	}

	public String getDescription() {
		return beverage.getDescription() + ", Whip";
	}
}
