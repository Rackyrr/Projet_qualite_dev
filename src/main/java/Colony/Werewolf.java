package Colony;

public class Werewolf {
    private String gender;
    private String ageCategory;
    private int strength;
    private int dominationExerted;
    private int dominationSuffered;
    private int dominationRank;
    private int level;
    private double impulsivenessFactor;
    private String pack;
    private boolean isAlphaCouple;
    private int numberOfOffspring;
    private boolean isOmega;

    public Werewolf(String gender, String ageCategory, int strength, int dominationExerted, int dominationSuffered,
                    int dominationRank, double impulsivenessFactor, String pack) {
        this.gender = gender;
        this.ageCategory = ageCategory;
        this.strength = strength;
        this.dominationExerted = dominationExerted;
        this.dominationSuffered = dominationSuffered;
        this.dominationRank = dominationRank;
        this.impulsivenessFactor = impulsivenessFactor;
        this.pack = pack;
        this.isAlphaCouple = false;
        this.numberOfOffspring = 0;
        this.isOmega = false;
        this.level = calculateLevel();
    }

    private int calculateLevel() {
        return 0;
    }

    public String getGender() {
        return gender;
    }

    public String getAgeCategory() {
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

    public void howl() {
        System.out.println("Awooooo");
    }

    public void hearHowl() {
        if (!isSleeping() && !isSick()) {
            System.out.println("Les Loup Garou écoute les hurlements");
        } else {
            System.out.println("Le Loup Garou n'écoute pas les hurlements car soit il dort, soit il est malade ");
        }
    }

    public void transformIntoHuman() {
        System.out.println("Le Loup Garou se transforme en humain");
    }

    private boolean isSleeping() {
        return false;
    }

    private boolean isSick() {
        return false;
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

    public boolean isAlphaCouple() {
        return isAlphaCouple;
    }

    public void becomeAlphaCouple() {
        isAlphaCouple = true;
    }

    public void removeAlphaCouple() {
        isAlphaCouple = false;
    }

    public int getNumberOfOffspring() {
        return numberOfOffspring;
    }

    public void increaseDominationRank() {
        dominationRank++;
    }

    public void exchangeRanks(Werewolf other) {
        int tempRank = other.getDominationRank();
        other.setDominationRank(dominationRank);
        setDominationRank(tempRank);
    }

    public void decreaseDominationRank() {
        dominationRank--;
    }

    public void decreaseDominationRankNaturally() {
    }

    public void declareOmega() {
        isOmega = true;
    }

    public boolean isOmega() {
        return isOmega;
    }

    public void reproduce() {
    }

    public void setDominationRank(int rank) {
        dominationRank = rank;
    }
}