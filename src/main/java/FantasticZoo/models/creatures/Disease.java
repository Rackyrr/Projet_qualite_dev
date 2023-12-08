package FantasticZoo.models.creatures;

public class Disease {
    private String name;
    private boolean curableByItself;
    private int naturalHealingTime;
    private int damageToHealth;

    /**
     * Create tho object Disease with parameters
     * @param name
     * @param cureItself
     * @param naturalHealingTime
     * @param damageToHealth
     */
    public Disease(String name, boolean cureItself, int naturalHealingTime, int damageToHealth) {
        this.name = name;
        this.curableByItself = cureItself;
        this.naturalHealingTime = naturalHealingTime;
        this.damageToHealth = damageToHealth;
    }

    /**
     * Retrieves the name of the Disease.
     *
     * @return the name of the Disease
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Disease.
     *
     * @param name the name to set for the Disease
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Check if the disease is curable by itself.
     *
     * @return true if the disease is curable by itself, false otherwise
     */
    public boolean isCurableByItself() {
        return curableByItself;
    }

    /**
     * Sets whether the disease is curable by itself.
     *
     * @param curableByItself true if the disease is curable by itself, false otherwise
     */
    public void setCurableByItself(boolean curableByItself) {
        this.curableByItself = curableByItself;
    }

    /**
     * Retrieves the natural healing time of the Disease.
     *
     * @return the natural healing time of the Disease
     */
    public int getNaturalHealingTime() {
        return naturalHealingTime;
    }

    /**
     * Sets the natural healing time of the Disease.
     *
     * @param naturalHealingTime the natural healing time to set for the Disease
     */
    public void setNaturalHealingTime(int naturalHealingTime) {
        this.naturalHealingTime = naturalHealingTime;
    }

    /**
     * Retrieves the amount of damage caused by the disease to the health of the individual.
     *
     * @return the amount of damage caused by the disease to the health
     */
    public int getDamageToHealth() {
        return damageToHealth;
    }

    /**
     * Sets the amount of damage caused by the disease to the health of the individual.
     *
     * @param damageToHealth the amount of damage caused by the disease to the health
     */
    public void setDamageToHealth(int damageToHealth) {
        this.damageToHealth = damageToHealth;
    }
}
