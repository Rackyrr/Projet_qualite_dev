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
    private boolean isSolitary;
    private boolean isAlphaCouple;
    private int numberOfOffspring;
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
        this.level = calculateLevel();
        this.isSolitary = false;
        this.isAlphaCouple = false;
        this.numberOfOffspring = 0;

        if (pack.equals("AlphaMale")) {
            this.gender = "male_alpha";
        } else if (pack.equals("AlphaFemale")) {
            this.gender = "female_alpha";
        }
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

    public void increaseDominationRank() {
        dominationRank++;
    }

    public boolean isSolitary() {
        return isSolitary;
    }

    public void becomeSolitary() {
        isSolitary = true;
    }

    public void joinPack() {
        isSolitary = false;
    }

    public boolean isAlphaCouple() {
        return isAlphaCouple;
    }

    public void becomeAlphaCouple() {
        isAlphaCouple = true;
    }

    public int getNumberOfOffspring() {
        return numberOfOffspring;
    }

    public void reproduce() {
        if (isAlphaCouple && numberOfOffspring < 7) {
            int numberOfNewOffspring = (int) (Math.random() * 7) + 1;
            numberOfOffspring += numberOfNewOffspring;
            System.out.println("The alpha couple has produced " + numberOfNewOffspring + " offspring!");
        }
    }

    public void exchangeRanks(Werewolf other) {
        int tempRank = other.getDominationRank();
        other.setDominationRank(this.getDominationRank());
        this.setDominationRank(tempRank);
    }

    public void decreaseDominationRank() {
        dominationRank = Math.max(dominationRank - 1, 1);
    }

    public void setDominationRank(int newRank) {
        dominationRank = newRank;
    }

    public boolean isAlphaMale() {
        return gender.equals("male_alpha");
    }

    public boolean isAlphaFemale() {
        return gender.equals("female_alpha");
    }

    public int getLevel() {
        return level;
    }

    public double getImpulsivenessFactor() {
        return impulsivenessFactor;
    }

    public void howl()  {
        System.out.println("Awooooo");
    }

    public void hearHowl() {
        if (!isSleeping() && !isSick()) {
            System.out.println("Les Loup Garou ecoute les hurlements");
        } else {
            System.out.println("Le Loup Garou n'ecoute pas les hurlements car soit il dort ou soit il est malade ");
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
}
