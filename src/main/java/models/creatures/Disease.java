package models.creatures;

public class Disease {
    private String name;
    private boolean cureItself;
    private int naturalHealingTime;
    private int damageToHealth;

    public Disease(String name, boolean cureItself, int naturalHealingTime, int damageToHealth) {
        this.name = name;
        this.cureItself = cureItself;
        this.naturalHealingTime = naturalHealingTime;
        this.damageToHealth = damageToHealth;
    }

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

    public int getDamageToHealth() {
        return damageToHealth;
    }

    public void setDamageToHealth(int damageToHealth) {
        this.damageToHealth = damageToHealth;
    }
}
