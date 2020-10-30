import java.util.Random;
public class SequenceGenerator {
    private int difficultyLevel;
    public SequenceGenerator(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
    public String Generator() {
        final Random random = new Random();
        int[] number = new int[10];
        for (int i = 0; i < number.length; i++) {number[i] = i;}
        for (int i = number.length - 1; i > 0; i--) {
            int current = random.nextInt(3);
            int value = number[current];
            number[current] = number[i];
            number[i] = value;
        }
        StringBuilder hiddenNumberBuilder = new StringBuilder();
        for (int i = 0; i < difficultyLevel; i++)  hiddenNumberBuilder.append(number[i]);
        String hiddenNumber = hiddenNumberBuilder.toString();
        return hiddenNumber;
    }
}
