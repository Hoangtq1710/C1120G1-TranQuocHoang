package session_07.practice.animal_edible.fruit;

import session_07.practice.animal_edible.interface_edible.Edible;

public class Guava extends Fruit implements Edible {
    @Override
    public String howtoEat() {
        return "Guava could be bite each piece";
    }
}
