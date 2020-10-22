import java.util.Random;
import java.util.Scanner;
public class Test {
    private static int step = 0;
    private static final Scanner  in = new Scanner(System.in);
    public static void main(String[] args) {
        final Random random = new Random();
        System.out.print("Введите сложность: ");
        int difficultyLevel = ProtectedInput();
        int[] number = new int [] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = number.length - 1; i > 0; i--) {
            int current = random.nextInt(i + 1);
            int value = number[current];
            number[current] = number[i];
            number[i] = value;
        }
        StringBuilder hiddenNumberBuilder = new StringBuilder();
        for (int i = 0; i < difficultyLevel; i++)  hiddenNumberBuilder.append(number[i]);
        String hiddenNumber = hiddenNumberBuilder.toString();
        gameProcess(difficultyLevel, hiddenNumber);
        System.out.println("Число попыток: " + step + " || Загаданная последовательность: " + hiddenNumber);
        in.close();
    }
    private static void gameProcess(int difficultyLevel, String hiddenNumber) {
        step++;
        String userVariant = Integer.toString(ProtectedInput(difficultyLevel));
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < userVariant.length(); i++) {
            if(userVariant.charAt(i) == hiddenNumber.charAt(i)) bull++;
            else{
                for (int j = 0; j < hiddenNumber.length(); j++) {
                    if(userVariant.charAt(i) == hiddenNumber.charAt(j)) cow++;
                }
            }
        }
        System.out.println("cow: " + cow + "   " + "bull: " + bull);
        if (bull == difficultyLevel) System.out.print("Победа за вами || ");
        else if  (!in.hasNextInt()){
            if (in.nextLine().equals("сдаюсь")){
                System.out.print("Вы проиграли ");
            }
        }
        else {
            gameProcess(difficultyLevel, hiddenNumber);
        }
    }
    private static int ProtectedInput() {
        int result;
        if (!in.hasNextInt()) {
            System.out.print("Введённое значение не является целым числом, попробуйте снова: ");
            ProtectedInput();
        }
        result = in.nextInt();
        if (result < 3 || result > 5) {
            System.out.print("Введённое значение не коррктно, попробуйте снова: ");
            result = ProtectedInput();
        }
        return result;
    }
    private static int ProtectedInput(int difficultyLevel) {
        int result;
        if (!in.hasNextInt()) {
            System.out.print("Введённое значение не является целым числом, попробуйте снова: ");
            ProtectedInput(difficultyLevel);
        }
        result = in.nextInt();
        if (String.valueOf(result).length() != difficultyLevel){
            System.out.print("Введённое значение не коррктно, попробуйте снова: ");
            result = ProtectedInput(difficultyLevel);
        }
        return result;
    }
}