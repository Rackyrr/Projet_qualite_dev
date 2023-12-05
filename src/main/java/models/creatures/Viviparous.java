package models.creatures;

public abstract class Viviparous extends Creature{
    private boolean isPregnant;
    private int actualGestationTime = 0;
    private final int GESTATION_TIME;


    @Override
    public boolean reproduce(Viviparous mate) {
        if (canMateWith(mate)) {
            Viviparous female;
            Viviparous male;
            if (this.getGender() == Gender.FEMALE) {
                female = this;
                male = mate;
            } else {
                female = mate;
                male = this;
            }
            if (!female.isPregnant && female.getActualEnclosure().isFull())
                return female.isPregnant = true;
        }
        return false;
    }

    public void refreshPregnancy(){
        if (!isPregnant) return;
        ++actualGestationTime;
        if (actualGestationTime >= GESTATION_TIME) giveBirth();
    }

    private void giveBirth() {
    }

    @Override
    public void run() {
        super.run();
        if(isPregnant){

        }
    }
}
