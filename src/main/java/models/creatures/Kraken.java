package models.creatures;

public class Kraken extends Oviparous implements ISwimming{
    @Override
    public String getSpecieName() {return "Kraken";}

    @Override
    public String getCreatureInfo() {
        if (this.getGender().equals(Gender.MALE)){
            return "Ce Kraken se nomme " + this.getName() + ", il pèse " + this.getWeight()
                    + " et il mesure " + this.getHeight() + ". Il a " + this.getAge()
                    + ", et c'est un mâle. Il peut nager.";
        }
        else if (this.getGender().equals(Gender.FEMALE)){
            return "Ce Kraken se nomme " + this.getName() + ", elle pèse " + this.getWeight()
                    + " et elle mesure " + this.getHeight() + ". Elle a " + this.getAge()
                    + ", et c'est une femele. Elle peut nager.";
        }
        return null;
    }

    @Override
    public String shout() {
        return String.format("%s crie !",this.getName());
    }

    @Override
    public void run() {

    }
}
