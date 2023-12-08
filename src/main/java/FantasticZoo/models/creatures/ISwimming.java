package FantasticZoo.models.creatures;

public interface ISwimming {
    public default String canSwim(){
        return "peut nager.";
    }
}
