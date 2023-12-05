package models.creatures;

public class Werewolf extends Viviparous implements IRunning{
    @Override
    public String getSpecieName() {
        return "Loup-Garou";
    }

    @Override
    public String getCreatureInfo() {
        if (this.getGender().equals(Gender.MALE)){
            return "Ce loup-garou se nomme " + this.getName() + ", il pèse " + this.getWeight()
                    + " et il mesure " + this.getHeight() + ". Il a " + this.getAge()
                    + ", et c'est un mâle. Il peut courir.";
        }
        else if (this.getGender().equals(Gender.FEMALE)){
            return "Ce loup-garou se nomme " + this.getName() + ", elle pèse " + this.getWeight()
                    + " et elle mesure " + this.getHeight() + ". Elle a " + this.getAge()
                    + ", et c'est une femele. Elle peut courir.";
        }
        return null;
    }

    @Override
    public String shout() {
        return null;
    }

    @Override
    public void run() {

    }
}
