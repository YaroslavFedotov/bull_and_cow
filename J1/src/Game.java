public class Game {
    private static int step = 0;
    private static String hiddenNumber;
    public static void main(String[] args) {
        System.out.print("Введите сложность: ");
        Input input = new Input();
        input.setDifficultyLevel(input.DifficultyLevelInput());
        SequenceGenerator sequenceGenerator = new SequenceGenerator(input.getDifficultyLevel());
        hiddenNumber = sequenceGenerator.Generator();
        gameIteration(input, hiddenNumber);
        System.out.println("Число попыток: " + step + " || Загаданная последовательность: " + hiddenNumber);
    }
    private static void gameIteration(Input input, String hiddenNumber) {
        step++;
        String userVariant = input.SequenceInput();
        int bull = 0, cow = 0;
        for (int i = 0; i < userVariant.length(); i++) {
            if(userVariant.charAt(i) == hiddenNumber.charAt(i)) bull++;
            else{
                for (int j = 0; j < hiddenNumber.length(); j++) {
                    if(userVariant.charAt(i) == hiddenNumber.charAt(j)) cow++;
                }
            }
        }
        System.out.println("cow: " + cow + "   " + "bull: " + bull);
        if (bull == input.getDifficultyLevel()) System.out.print("Победа за вами || ");
        else gameIteration(input, hiddenNumber);
    }
    public static void EndGame(){
        System.out.print("Вы проиграли || ");
        System.out.println("Число попыток: " + step + " || Загаданная последовательность: " + hiddenNumber);
        System.exit(0);
    }
}