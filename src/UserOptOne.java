import java.util.Scanner;

public class UserOptOne {

    private Scanner scanner = new Scanner(System.in);
    private boolean running = true;
    private QuizUI ui = new QuizUI();
    private User user;

    public void start() {
        while (running) {
            clearScreen();
            login();
            ui.showMainMenu();
            handleMenu();
        }
        scanner.close();
    }
    private void login() {
        System.out.print("Enter username: ");
        String name = scanner.nextLine();
        user = new User(name);
        System.out.println("Welcome " + name + "!");
    }

    private void handleMenu() {
        System.out.print("Enter option: ");
        int option = readInt();

        switch (option) {
            case 1 -> handleTopics();
            case 2 -> showHistory();
            case 3 -> handleSettings();
            case 4 -> {
                System.out.println("Goodbye!");
                running = false;
            }
            default -> System.out.println("Invalid option!");
        }
    }

    private void handleTopics() {
        boolean inMenu = true;

        while (inMenu) {
            ui.showTopics();
            int topic = readInt();

            switch (topic) {
                case 1 -> launchQuiz("Java Basics");
                case 2 -> launchQuiz("OOP Concepts");
                case 3 -> launchQuiz("Data Structures");
                case 0 -> inMenu = false;
                default -> System.out.println("Invalid topic!");
            }
        }
    }

    private void launchQuiz(String topicName) {
        ui.showQuizMenu();
        int choice = readInt();

        if (choice == 1) {
            System.out.println("Starting " + topicName + " quiz...");

            Timer timer = new Timer();
            timer.start(1); // 1 minute

            Quiz quiz = new StarCore(scanner, timer, topicName, user);
            quiz.start();

            timer.stop();
            waitEnter();
        }
    }

    private void handleSettings() {
        ui.showSettingsMenu();
        System.out.println("Feature coming soon...");
        waitEnter();
    }

    private void showHistory() {
        FileManager.showLeaderboard();
        waitEnter();
    }

    private void waitEnter() {
        System.out.println("Press Enter...");
        scanner.nextLine();
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
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}