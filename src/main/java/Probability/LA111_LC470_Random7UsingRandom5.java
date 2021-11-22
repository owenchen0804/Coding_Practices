package Probability;

public class LA111_LC470_Random7UsingRandom5 {
    public int random7() {
        // write your solution here
        // you can use RandomFive.random5() for generating
        // 0 - 4 with equal probability.
        while (true) {
            int random = 5 * RandomFive.random5() + RandomFive.random5();
            if (random < 21) {
                return random % 7;
            }
        }
    }
}
