package Colony;

import java.util.ArrayList;
import java.util.List;
public class WerewolfPack {
    private Werewolf alphaMale;
    private Werewolf alphaFemale;
    private List<Werewolf> members;

    public WerewolfPack(Werewolf alphaMale, Werewolf alphaFemale) {
        this.alphaMale = alphaMale;
        this.alphaMale = alphaFemale;
        this.members = new ArrayList<>();
        initializePack();
    }

    private void initializePack(){
        members.add(alphaMale);
        members.add(alphaFemale);
    }

    public void addWerewolf(Werewolf werewolf) {
        members.add(werewolf);
        adjustHierarchy(werewolf);
    }

    private void adjustHierarchy(Werewolf werewolf) {
        if (werewolf != alphaMale && werewolf != alphaFemale) {
            if (werewolf.getDominationRank() >= alphaMale.getStrength() * alphaMale.getImpulsivenessFactor()
                    && !werewolf.getGender().equals("female_alpha")) {
                performDomination(werewolf);
            } else {
                werewolf.setDominationRank(werewolf.getDominationRank() - 1);
            }
        }
    }

    private void performDomination(Werewolf aggressor) {
        for (Werewolf target : members) {
            if (target != aggressor && target.getStrength() < aggressor.getStrength()
                    && !target.getGender().equals("female_alpha")) {
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

    public void disperseSolitaries() {
        List<Werewolf> solitaries = new ArrayList<>();
        for (Werewolf member : members) {
            if (member.isSolitary()) {
                solitaries.add(member);
            }
        }

        if (solitaries.size() >= 2) {
            Werewolf newAlphaMale = findAlpha(solitaries, "male");
            Werewolf newAlphaFemale = findAlpha(solitaries, "female");

            if (newAlphaMale != null && newAlphaFemale != null) {
                WerewolfPack newPack = new WerewolfPack(newAlphaMale, newAlphaFemale);
                for (Werewolf member : solitaries) {
                    member.joinPack();
                    newPack.addWerewolf(member);
                }
                members.removeAll(solitaries);
            }
        }
    }

    private Werewolf findAlpha(List<Werewolf> candidates, String gender) {
        Werewolf alpha = null;
        for (Werewolf candidate : candidates) {
            if (candidate.getGender().equals(gender) && (alpha == null || candidate.getStrength() > alpha.getStrength())) {
                alpha = candidate;
            }
        }
        return alpha;
    }

    private Werewolf findAlphaFemale() {
        Werewolf newAlphaFemale = alphaFemale;
        for (Werewolf member : members) {
            if (member != alphaMale && member != alphaFemale && member.getGender().equals("female")
                    && member.getStrength() > newAlphaFemale.getStrength()) {
                newAlphaFemale = member;
            }
        }
        return newAlphaFemale;
    }

    public void reproduceInAlphaCouple() {
        for (Werewolf member : members) {
            if (member.isAlphaCouple()) {
                member.reproduce();
            }
        }
    }

    public void displayPackHierarchy() {
        System.out.println("Pack Hierarchy:");
        System.out.println("Alpha Male:" + alphaMale.getDominationRank() + " - " + alphaMale.getGender());
        System.out.println("Alpha Female:" + alphaFemale.getDominationRank() + " - " + alphaFemale.getGender());

        for (Werewolf member : members) {
            if (member != alphaMale && member != alphaFemale) {
                System.out.println(member.getDominationRank() + " - " + member.getGender());
            }
        }

    }
}


