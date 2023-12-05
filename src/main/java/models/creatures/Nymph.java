package models.creatures;

public class Nymph extends Viviparous implements IRebirth{
    @Override
    public String getSpecieName() {
        return "Nymphe";
    }

    @Override
    public String getCreatureInfo() {
        if (this.getGender().equals(Gender.MALE)){
            return "Cet nymphe se nomme " + this.getName() + ", il pèse " + this.getWeight()
                    + " et il mesure " + this.getHeight() + ". Il a " + this.getAge()
                    + ", et c'est un mâle. Cette créature peut renaître après sa mort.";
        }
        else if (this.getGender().equals(Gender.FEMALE)){
            return "Cette nymphe se nomme " + this.getName() + ", elle pèse " + this.getWeight()
                    + " et elle mesure " + this.getHeight() + ". Elle a " + this.getAge()
                    + ", et c'est une femele. Cette créature peut renaître après sa mort.";
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
