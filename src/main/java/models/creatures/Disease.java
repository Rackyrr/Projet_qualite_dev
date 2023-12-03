package models.creatures;

public class Disease {
    private String name;
    private boolean cureItself;
    private int naturalHealingTime;

    public Disease(String name, boolean cureItself, int naturalHealingTime) {
        this.name = name;
        this.cureItself = cureItself;
        this.naturalHealingTime = naturalHealingTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCureItself() {
        return cureItself;
    }

    public void setCureItself(boolean cureItself) {
        this.cureItself = cureItself;
    }

    public int getNaturalHealingTime() {
        return naturalHealingTime;
    }

    public void setNaturalHealingTime(int naturalHealingTime) {
        this.naturalHealingTime = naturalHealingTime;
    }
}
