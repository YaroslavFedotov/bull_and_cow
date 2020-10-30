import java.util.Random;
public class SequenceGenerator {
    private int difficultyLevel;
    public SequenceGenerator(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
    public String Generator() {
        final Random random = new Random();
        int[] number = new int[difficultyLevel + 1];
        for (int i = 0; i < number.length - 1; i++) {
            number[i] = random.nextInt(9);
            for (int j = 0; j < i; j++) {
                 if(number[i] == number[j]){
                     j = 0;
                     number[i] = random.nextInt(9);
                 }
            }
        }
        StringBuilder numberBuilder = new StringBuilder();
        for (int i = 0; i < number.length - 1; i++)  numberBuilder.append(number[i]);
        System.out.println(numberBuilder.toString());
        return numberBuilder.toString();
    }
}
