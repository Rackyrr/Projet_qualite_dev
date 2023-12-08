package Colony;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WerewolfPack {
    private List<Werewolf> males;
    private List<Werewolf> females;

    public WerewolfPack() {
        this.males = new ArrayList<>();
        this.females = new ArrayList<>();
    }

    public void addWerewolf(Werewolf werewolf) {
        if (werewolf.getGender().equals("M")) {
            males.add(werewolf);
        } else {
            females.add(werewolf);
        }
        Collections.sort(males, (w1, w2) -> w1.getDominationRank() - w2.getDominationRank());
        Collections.sort(females, (w1, w2) -> w1.getDominationRank() - w2.getDominationRank());
    }

    public void displayHierarchy() {
        System.out.println("Hiérarchie de la meute :");
        displayGenderHierarchy("Mâles", males);
        displayGenderHierarchy("Femelles", females);
    }

    private void displayGenderHierarchy(String gender, List<Werewolf> wolves) {
        System.out.println(gender + ":");
        for (Werewolf werewolf : wolves) {
            System.out.println("Loup garou " + werewolf.getGender() + " de rang " + getRankSymbol(werewolf));
        }
    }

    private char getRankSymbol(Werewolf werewolf) {
        char symbol = (char) ('α' + males.indexOf(werewolf) + females.size());
        return symbol <= 'ω' ? symbol : 'ω';
    }

    public void makeOmega(Werewolf werewolf) {
        if (!isOmega(werewolf)) {
            if (werewolf.getGender().equals("M")) {
                males.remove(werewolf);
            } else {
                females.remove(werewolf);
            }
            werewolf.setDominationRank('ω');
            addWerewolf(werewolf);
        }
    }

    public boolean isOmega(Werewolf werewolf) {
        return werewolf.getDominationRank() == 'ω';
    }

    public List<Werewolf> getMales() {
        return males;
    }

    public List<Werewolf> getFemales() {
        return females;
    }
    public void showAggression(Werewolf aggressor, Werewolf victim) {
        System.out.println(aggressor.getGender() + " " + aggressor.getDominationRank() +
                " se montre agressif envers " + victim.getGender() + " " + victim.getDominationRank());
    }
    public void attemptDomination(Werewolf aggressor, Werewolf victim) {
        if (aggressor.getStrength() >= victim.getStrength() * aggressor.getImpulsivenessFactor()
                && victim.getDominationRank() != 'α') {
            if (aggressor.getDominationRank() > victim.getDominationRank()
                    || victim.getDominationRank() == 'ω') {
                accomplishDomination(aggressor, victim);
            } else {
                this.showAggression(aggressor,victim);
            }
        } else {
            System.out.println(aggressor.getGender() + " " + aggressor.getDominationRank()
                    + " a échoué à dominer " + victim.getGender() + " " + victim.getDominationRank());
        }
    }

    public void accomplishDomination(Werewolf aggressor, Werewolf target) {
        this.increaseDominationFactor(aggressor);
        int tempRank = aggressor.getDominationRank();
        aggressor.setDominationRank(target.getDominationRank());
        target.setDominationRank(tempRank);

        System.out.println(aggressor.getGender() + " " + aggressor.getDominationRank()
                + " a accompli la domination sur " + target.getGender() + " " + target.getDominationRank());
    }
    private static final int DOMINATION_THRESHOLD = 5;

    private void increaseDominationFactor(Werewolf werewolf) {
        if (werewolf.getDominationRank() != 'ω' && !werewolf.getGender().equals("α")) {
            if (werewolf.getLevel() > DOMINATION_THRESHOLD || werewolf.getDominationRank() == 'ω') {
                werewolf.setDominationRank(werewolf.getDominationRank() + 1);
                System.out.println(werewolf.getGender() + " " + werewolf.getDominationRank()
                        + " a augmenté son facteur de domination.");
                if (werewolf.getDominationRank() == 'ω') {
                }
            } else {
                showAggression(werewolf, werewolf);
            }
        }
    }
}

