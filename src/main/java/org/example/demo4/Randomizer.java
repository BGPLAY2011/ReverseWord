package org.example.demo4;
import java.util.Random;

public class Randomizer{

    private final Random random = new Random();

    public int generate() {
        return random.nextInt(2);
    }
}
