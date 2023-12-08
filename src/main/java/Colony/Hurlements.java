package Colony;

public class Hurlements {
    private String type;
    private Werewolf werewolf;

    public Hurlements(String type, Werewolf werewolf) {
        this.type = type;
        this.werewolf = werewolf;
    }

    public String getType() {
        return type;
    }

    public Werewolf getWerewolf() {
        return Werewolf;
    }

    public void displayHurlementsCharacteristics() {
        System.out.println("Hurlements Characteristics:");
        System.out.println("Type: " + type);
        System.out.println("Werewolf: " + werewolf.getGender() + " - " + werewolf.getStrength());
    }


}


