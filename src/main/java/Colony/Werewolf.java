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
