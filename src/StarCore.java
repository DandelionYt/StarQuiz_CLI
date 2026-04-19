import java.util.Scanner;
public class StarCore {

    private Scanner scanner;
    private Timer timer;
//        UserOptOne userOptOne = new UserOptOne();

    public StarCore(Scanner scanner, Timer timer) {
        this.scanner = scanner;
        this.timer = timer;
    }

    public void runQuiz() {
        if (timer == null) {
            System.out.println("Timer not initialized!");
            return;
        }

        int score = 0;

        String[] questions = {
                "What is Java?",
                "What is OOP?"
        };

        String[][] options = {
                {"Language", "Car", "Food", "OS"},
                {"Concept", "Tool", "Game", "None"}
        };

        int[] answers = {1, 1};

        for (int i = 0; i < questions.length; i++) {

            // STOP IF TIME IS UP
            if (timer.isTimeUp()) {
                System.out.println("\nTIME IS UP! AUTO-SUBMITTING...");
                break;
            }

            System.out.println("\nTime left: " + timer.getRemainingSeconds() + "s");

            System.out.println(questions[i]);

            for (int j = 0; j < options[i].length; j++) {
                System.out.println((j + 1) + ". " + options[i][j]);
            }

            System.out.print("Your answer: ");
            int userAns = readInt();
            if (userAns == answers[i]) {
                System.out.println("✔ Correct!");
                score++;
            } else {
                System.out.println(" Wrong! Correct answer: " + answers[i]);
            }
        }

        System.out.println("\n Final Score: " + score + "/" + questions.length);
    }

    private int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a number!");
            scanner.next();
        }
        int val = scanner.nextInt();
        scanner.nextLine();
        return val;
    }
}

