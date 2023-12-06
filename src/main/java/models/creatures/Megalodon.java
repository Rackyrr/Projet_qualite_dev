package models.creatures;

public class Megalodon extends Oviparous implements ISwimming{
    @Override
    public String getSpecieName() {
        return "Megalodon";
    }

    @Override
    public String getCreatureInfo() {
        if (this.getGender().equals(Gender.MALE)){
            return "Ce Megalodon se nomme " + this.getName() + ", il pèse " + this.getWeight()
                    + " et il mesure " + this.getHeight() + ". Il a " + this.getAge()
                    + ", et c'est un mâle. Il peut nager.";
        }
        else if (this.getGender().equals(Gender.FEMALE)){
            return "Ce Megalodon se nomme " + this.getName() + ", elle pèse " + this.getWeight()
                    + " et elle mesure " + this.getHeight() + ". Elle a " + this.getAge()
                    + ", et c'est une femele. Elle peut nager.";
        }
        return null;
    }

    @Override
    public String shout() {
        return String.format("%s fait de petites bulles !",this.getName());
    }

    @Override
    public void run() {

    }
}
