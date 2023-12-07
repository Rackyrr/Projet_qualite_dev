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


