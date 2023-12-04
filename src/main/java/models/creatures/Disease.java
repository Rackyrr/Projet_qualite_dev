package models.creatures;

public class Disease {
    private String name;
    private boolean curableByItself;
    private int naturalHealingTime;
    private int damageToHealth;

    public Disease(String name, boolean cureItself, int naturalHealingTime, int damageToHealth) {
        this.name = name;
        this.curableByItself = cureItself;
        this.naturalHealingTime = naturalHealingTime;
        this.damageToHealth = damageToHealth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCurableByItself() {
        return curableByItself;
    }

    public void setCurableByItself(boolean curableByItself) {
        this.curableByItself = curableByItself;
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
