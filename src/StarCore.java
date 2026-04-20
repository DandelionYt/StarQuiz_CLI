import java.util.Scanner;

public class StarCore implements Quiz {

    private Scanner scanner;
    private Timer timer;
    private String topicName;
    private Question[] questions;
    private User user;

    public StarCore(Scanner scanner, Timer timer, String topicName,User user) {
        this.scanner = scanner;
        this.timer = timer;
        this.topicName = topicName;
        this.user = user;

        questions = new Question[]{
                new Question("What is Java?",
                        new String[]{"Language", "Car", "Food", "OS"}, 1),

                new Question("What is OOP?",
                        new String[]{"Concept", "Tool", "Game", "None"}, 1)
        };
    }

    @Override
    public void start() {

        if (timer == null) {
            System.out.println("Timer not initialized!");
            return;
        }

        int score = 0;

        for (int i = 0; i < questions.length; i++) {

            if (timer.isTimeUp()) break;

            Question q = questions[i];

            System.out.println("\n" + q.getText());

            String[] options = q.getOptions();
            for (int j = 0; j < options.length; j++) {
                System.out.println((j + 1) + ". " + options[j]);
            }

            System.out.print("Your answer: ");
            int ans = readInt();

            if (ans < 1 || ans > options.length) {
                System.out.println("Invalid choice!");
                i--;
                continue;
            }

            if (ans == q.getCorrectAnswer()) {
                System.out.println("✔ Correct!");
                score++;
            } else {
                System.out.println("✘ Wrong! Correct answer: "
                        + options[q.getCorrectAnswer() - 1]);
            }
        }

        System.out.println("\n Final Score: " + score + "/" + questions.length);
        FileManager.saveScore(user.getUsername(), score);

// ADD XP
        int xpEarned = score * 10;
        user.addXp(xpEarned);

        System.out.println("⭐ XP gained: " + xpEarned);
        System.out.println("🏆 Total XP: " + user.getXp());
    }

    private int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Enter a number!");
            scanner.next();
        }
        int val = scanner.nextInt();
        scanner.nextLine();
        return val;
    }
}