package models.creatures;

public abstract class Viviparous extends Creature{
    private boolean pregnant;
    private int actualGestationTime = 0;
    private final int GESTATION_TIME = -1;


    public boolean isPregnant() {
        return pregnant;
    }

    public void setPregnant(boolean pregnant) {
        this.pregnant = pregnant;
    }

    public int getActualGestationTime() {
        return actualGestationTime;
    }

    public void setActualGestationTime(int actualGestationTime) {
        this.actualGestationTime = actualGestationTime;
    }

    public int getGESTATION_TIME() {
        return GESTATION_TIME;
    }

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
            if (!female.pregnant && !female.getActualEnclosure().isFull())
                return female.pregnant = true;
        }
        return false;
    }

    public void refreshPregnancy(){
        if (!pregnant) return;
        ++actualGestationTime;
        if (actualGestationTime >= GESTATION_TIME) giveBirth();
    }

    private void giveBirth() {
    }

    @Override
    public void run() {
        super.run();
        if(pregnant){

        }
    }
}
