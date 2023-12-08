package Colony;

public class WerewolfCoupleAlpha {
    private Werewolf alphaMale;
    private Werewolf alphaFemale;

    public WerewolfCoupleAlpha(Werewolf alphaMale, Werewolf alphaFemale) {
        this.alphaMale = alphaMale;
        this.alphaFemale = alphaFemale;
    }

    public Werewolf getAlphaMale() {
        return alphaMale;
    }

    public Werewolf getAlphaFemale() {
        return alphaFemale;
    }

    public void displayCoupleCharacteristics() {
        System.out.println("Caracteristique du couple Alpha:");
        System.out.println("Male Alpha: " + alphaMale.getGender() + " - " + alphaMale.getStrength());
        System.out.println("Femelle Alpha: " + alphaFemale.getGender() + " - " + alphaFemale.getStrength());
    }

    public void reproduce() {
        if (alphaMale != null && alphaFemale != null) {
            System.out.println("Progres de la reproduction");
            alphaFemale.reproduce();
        } else {
            System.out.println("Ne peux pas reproduire car necessite un Male alpha ou une Femelle Alpha");
        }
    }
}