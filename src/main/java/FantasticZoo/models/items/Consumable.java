package FantasticZoo.models.items;

import FantasticZoo.models.creatures.Creature;

public interface Consumable {
    boolean useOn(Creature c);
}
