public class Game {
    private static int step = 0;
    private static String hiddenNumber;
    public static void main(String[] args) {
        System.out.print("Введите сложность: ");
        Input input = new Input();
        input.setDifficultyLevel(input.DifficultyLevelInput());
        Sequences sequenceGenerator = new Sequences(input.getDifficultyLevel());
        hiddenNumber = sequenceGenerator.Generator();
        gameIteration(input, hiddenNumber);
    }
    private static void gameIteration(Input input, String hiddenNumber) {
        step++;
        if (Sequences.comparisonOfSequences(input, hiddenNumber)) EndGame(true);
        else gameIteration(input, hiddenNumber);

    }
    public static void EndGame(Boolean exodus){
        if (exodus) System.out.print("Победа за вами || ");
        else System.out.print("Вы проиграли || ");
        System.out.println("Число попыток: " + step + " || Загаданная последовательность: " + hiddenNumber);
        System.exit(0);
    }
}