package Colony;

public class Werewolf {
    public enum AgeCategory {
        YOUNG,
        ADULT,
        OLD
    }
    private String gender;
    private AgeCategory ageCategory;
    private int strength;
    private int dominationExerted;
    private int dominationSuffered;
    private int dominationRank;
    private int level;
    private double impulsivenessFactor;
    private String pack;

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAgeCategory(AgeCategory ageCategory) {
        this.ageCategory = ageCategory;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDominationExerted(int dominationExerted) {
        this.dominationExerted = dominationExerted;
    }

    public void setDominationSuffered(int dominationSuffered) {
        this.dominationSuffered = dominationSuffered;
    }

    public void setDominationRank(int dominationRank) {
        this.dominationRank = dominationRank;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setImpulsivenessFactor(double impulsivenessFactor) {
        this.impulsivenessFactor = impulsivenessFactor;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public Werewolf(String gender, AgeCategory ageCategory, int strength, int dominationExerted, int dominationSuffered,
                    int dominationRank, double impulsivenessFactor, String pack) {
        this.gender = gender;
        this.ageCategory = ageCategory;
        this.strength = strength;
        this.dominationExerted = dominationExerted;
        this.dominationSuffered = dominationSuffered;
        this.dominationRank = dominationRank;
        this.impulsivenessFactor = impulsivenessFactor;
        this.pack = pack;
        this.level = calculateLevel();
    }
    private int calculateLevel() {
        return 0;
    }

    public String getGender() {
        return gender;
    }

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    public int getStrength() {
        return strength;
    }

    public int getDominationExerted() {
        return dominationExerted;
    }

    public int getDominationSuffered() {
        return dominationSuffered;
    }

    public int getDominationRank() {
        return dominationRank;
    }

    public int getLevel() {
        return level;
    }

    public double getImpulsivenessFactor() {
        return impulsivenessFactor;
    }

    public String getPack() {
        return pack;
    }
    public void displayCharacteristics() {
        System.out.println("Caractéristiques du Loup-Garou :");
        System.out.println("Genre : " + gender);
        System.out.println("Catégorie d'Âge : " + ageCategory);
        System.out.println("Force : " + strength);
        System.out.println("Domination Exercée : " + dominationExerted);
        System.out.println("Domination Subie : " + dominationSuffered);
        System.out.println("Rang : " + dominationRank);
        System.out.println("Niveau : " + level);
        System.out.println("Facteur d'Impétuosité : " + impulsivenessFactor);
        System.out.println("Meute : " + pack);
    }
    public String shout() {
        return String.format("Miaou");
    }
    public void hearShout(String shout) {
        System.out.println("Le loup garou entends un miaulement: " + shout);
    }
    public void leavePack() {
        System.out.println("Le loup garou a quitté la meute.");
        this.pack = "Solitaire";
    }
    public void transformToHuman() {
        System.out.println("The werewolf transforms into a human.");
        // Add any additional logic for the transformation
    }
}
