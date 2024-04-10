package weapons;

import output.Output;

public abstract class Weapon implements WeaponBehaviour{
    Output output;
    public Weapon(Output output){
        this.output = output;
    }
}
