package models.creatures;

public class Phoenix extends Oviparous implements IFlying, IRebirth{
    @Override
    public String getSpecieName() {
        return "Phénix";
    }

    @Override
    public String getCreatureInfo() {
        if (this.getGender().equals(Gender.MALE)){
            return "Ce phénix se nomme " + this.getName() + ", il pèse " + this.getWeight()
                    + " et il mesure " + this.getHeight() + ". Il a " + this.getAge()
                    + ", et c'est un mâle. Il peut voler et renaître après sa mort.";
        }
        else if (this.getGender().equals(Gender.FEMALE)){
            return "Ce phénix se nomme " + this.getName() + ", elle pèse " + this.getWeight()
                    + " et elle mesure " + this.getHeight() + ". Elle a " + this.getAge()
                    + ", et c'est une femele. Elle peut voler et renaître après sa mort.";
        }
        return null;
    }

    @Override
    public String shout() {
        return String.format("%s gazouille !",this.getName());
    }

    @Override
    public void run() {

    }
}
