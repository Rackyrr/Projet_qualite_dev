package models.creatures;

public class Dragon extends Oviparous implements IRunning, IFlying{
    @Override
    public String getSpecieName() {
        return "Dragon";
    }

    @Override
    public String getCreatureInfo() {
        if (this.getGender().equals(Gender.MALE)){
            return "Ce Dragon se nomme " + this.getName() + ", il pèse " + this.getWeight()
                    + " et il mesure " + this.getHeight() + ". Il a " + this.getAge()
                    + ", et c'est un mâle. Il peut voler.";
        }
        else if (this.getGender().equals(Gender.FEMALE)){
            return "Ce Dragon se nomme " + this.getName() + ", elle pèse " + this.getWeight()
                    + " et elle mesure " + this.getHeight() + ". Elle a " + this.getAge()
                    + ", et c'est une femele. Elle peut voler.";
        }
        return null;
    }

    @Override
    public void run() {

    }

    @Override
    public String shout() {
        return null;
    }

}
