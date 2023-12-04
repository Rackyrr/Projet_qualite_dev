package models.creatures;

public class Unicorn extends Viviparous implements IRunning{
    @Override
    public String getSpecieName() {
        return "Licorne";
    }

    @Override
    public String getCreatureInfo() {
        if (this.getGender().equals(Gender.MALE)){
            return "Cet licorne se nomme " + this.getName() + ", il pèse " + this.getWeight()
                    + " et il mesure " + this.getHeight() + ". Il a " + this.getAge()
                    + ", et c'est un mâle. Il peut courir.";
        }
        else if (this.getGender().equals(Gender.FEMALE)){
            return "Cette licorne se nomme " + this.getName() + ", elle pèse " + this.getWeight()
                    + " et elle mesure " + this.getHeight() + ". elle a " + this.getAge()
                    + ", et c'est une femele. Elle peut courir.";
        }
        return null;
    }

    @Override
    public void run() {

    }
}
