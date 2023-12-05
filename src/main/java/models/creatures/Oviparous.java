package models.creatures;

public abstract class Oviparous extends Creature{

    public boolean reproduce(Oviparous mate) {
        if (canMateWith(mate)) {
            Oviparous female;
            Oviparous male;
            if (this.getGender() == Gender.FEMALE) {
                female = this;
                male = mate;
            } else {
                female = mate;
                male = this;
            }
            if (!female.getActualEnclosure().isFull())
                return female.layEgg();
        }
        return false;
    }

    public boolean layEgg(){}
}
