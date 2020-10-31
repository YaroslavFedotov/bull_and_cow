import java.util.Scanner;
public class Input {
    public Scanner in = new Scanner(System.in);
    private int difficultyLevel;
    public Input() {}
    public void setDifficultyLevel(int difficultyLevel) { this.difficultyLevel = difficultyLevel; }
    public int getDifficultyLevel() {
        return difficultyLevel;
    }
    public int DifficultyLevelInput() {
        int result;
        result = in.nextInt();
        if (result < 3 || result > 5) {
            System.out.print("Введённое значение не коррктно, попробуйте снова: ");
            result = DifficultyLevelInput();
        } return result;
    }
    public String SequenceInput() {
        String result = in.nextLine();
        surrenderInput(result);
        if (result.length() != difficultyLevel) result = SequenceInput();
        return result;
    }
    public void surrenderInput(String result) {
        if (result.equals("сдаюсь")) Game.EndGame(false);
    }
}
