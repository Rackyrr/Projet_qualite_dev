package models.creatures;

public class Dragon extends Oviparous implements IRunning, IFlying{
    @Override
    public String getSpecieName() {
        return "Dragon";
    }

    @Override
    public void run() {

    }
}
