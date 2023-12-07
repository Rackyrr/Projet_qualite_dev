package Colony;

import java.util.ArrayList;
import java.util.List;

public class WerewolfPack {
    private Werewolf alphaMale;
    private Werewolf alphaFemale;
    private List<Werewolf> members;

    public WerewolfPack(Werewolf alphaMale, Werewolf alphaFemale) {
        this.alphaMale = alphaMale;
        this.alphaFemale = alphaFemale;
        this.members = new ArrayList<>();
        initializePack();
    }

    private void initializePack() {
        members.add(alphaMale);
        members.add(alphaFemale);
    }

    public void displayPackCharacteristics() {
        System.out.println("Caractéristiques du pack:");
        System.out.println("Male alpha: " + alphaMale.getGender() + " - " + alphaMale.getStrength());
        System.out.println("\n" + "Femelle Alpha: " + alphaFemale.getGender() + " - " + alphaFemale.getStrength());
        System.out.println("Nombres de membres: " + (members.size() - 2));
        System.out.println("Nombre de descendants: " + alphaFemale.getNumberOfOffspring());
    }

    public void displayMembersCharacteristics() {
        System.out.println("Members Characteristics:");
        for (Werewolf member : members) {
            if (member != alphaMale && member != alphaFemale) {
                System.out.println(member.getGender() + " - " + member.getStrength());
            }
        }
    }

    public void createNewHierarchy(List<Werewolf> newHierarchy) {
        members.clear();
        alphaMale = null;
        alphaFemale = null;

        for (Werewolf werewolf : newHierarchy) {
            addWerewolf(werewolf);
        }
    }

    public void constituteAlphaCouple(Werewolf newAlphaMale) {
        if (newAlphaMale != null) {
            if (alphaMale != null) {
                alphaMale.removeAlphaCouple();
            }
            alphaMale = newAlphaMale;
            alphaMale.becomeAlphaCouple();
            adjustHierarchy(alphaMale);
        }
    }

    public void reproduceInAlphaCouple() {
        for (Werewolf member : members) {
            if (member.isAlphaCouple()) {
                member.reproduce();
            }
        }
    }

    public void decreaseDominationRanksNaturally() {
        for (Werewolf member : members) {
            member.decreaseDominationRankNaturally();
        }
    }

    public void declareOmegaWerewolves() {
        for (Werewolf member : members) {
            if (member.getStrength() < calculateAverageStrength() / 2) {
                member.declareOmega();
            }
        }
    }

    public void addWerewolves(List<Werewolf> newMembers) {
        for (Werewolf newMember : newMembers) {
            addWerewolf(newMember);
        }
    }

    public void removeWerewolf(Werewolf werewolf) {
        if (werewolf != null) {
            members.remove(werewolf);
        }
    }

    private double calculateAverageStrength() {
        double totalStrength = 0;
        for (Werewolf member : members) {
            totalStrength += member.getStrength();
        }
        return totalStrength / members.size();
    }

    private void addWerewolf(Werewolf werewolf) {
        members.add(werewolf);
        adjustHierarchy(werewolf);
    }

    private void adjustHierarchy(Werewolf werewolf) {
        if (werewolf != alphaMale && werewolf != alphaFemale) {
            if (werewolf.getDominationRank() >= alphaMale.getStrength() * alphaMale.getImpulsivenessFactor()
                    && !werewolf.getGender().equals("Femelle Alpha")) {
                performDomination(werewolf);
            } else {
                werewolf.setDominationRank(werewolf.getDominationRank() - 1);
            }
        }
    }

    private void performDomination(Werewolf aggressor) {
        for (Werewolf target : members) {
            if (target != aggressor && target.getStrength() < aggressor.getStrength()
                    && !target.getGender().equals("Femelle Alpha")) {
                aggressor.increaseDominationRank();
                aggressor.exchangeRanks(target);
                target.decreaseDominationRank();

                if (target.equals(alphaMale)) {
                    Werewolf newAlphaFemale = findAlphaFemale();
                    alphaFemale = newAlphaFemale;
                }

                break;
            }
        }
    }

    private Werewolf findAlphaFemale() {
        Werewolf newAlphaFemale = alphaFemale;
        for (Werewolf member : members) {
            if (member != alphaMale && member != alphaFemale && member.getGender().equals("femelle")
                    && member.getStrength() > newAlphaFemale.getStrength()) {
                newAlphaFemale = member;
            }
        }
        return newAlphaFemale;
    }
}