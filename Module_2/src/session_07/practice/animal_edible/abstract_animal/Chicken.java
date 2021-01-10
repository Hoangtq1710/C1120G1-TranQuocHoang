package session_07.practice.animal_edible.abstract_animal;

import session_07.practice.animal_edible.interface_edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken : chick-chick";
    }

    @Override
    public String howtoEat() {
        return "Chicken could be boiled";
    }
}
