
    import java.util.Scanner;

    public class UserOptOne{
        private Scanner scanner;
        private boolean running;
        private int option;
        private int topic;
        private int choice;
        private int setting;
        private StrInterfaces str = new StrInterfaces();

        public UserOptOne() {
            this.scanner = new Scanner(System.in);
            this.running = true;
            this.option = 0;
            this.topic = 0;
            this.choice = 0;
            this.setting = 0;
        }

        public void Start() {
            while (running) {
                str.Menu();
                handleMenuOptions();
            }
            scanner.close();
        }

        private void handleMenuOptions() {
            System.out.print("Enter option: ");
            option = readInt();

            switch (option) {
                case 1:
                    handleSelectTopic();
                    break;
                case 2:
                    handleHistoryMenu();
                    break;
                case 3:
                    handleSettingsMenu();  // Fixed: Show settings menu first
                    break;
                case 4:
                    System.out.println("Thank you for your time");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option! Please try again");
                    // Let the loop continue to show menu again
            }
        }

        private void handleSelectTopic() {
            boolean inTopicMenu = true;
            while (inTopicMenu) {
                str.SelectTopic();

                System.out.print("Enter topic choice (1-3) or 0 to go back: ");
                topic = readInt();

                switch (topic) {
                    case 1:
                        System.out.println("Topic 1 selected: Java Basics");
                        handleQuizMenu();
                        break;

                    case 2:
                        System.out.println("Topic 2 selected: OOP Concepts");
                        handleQuizMenu();
                        break;

                    case 3:
                        System.out.println("Topic 3 selected: Data Structures");
                        handleQuizMenu();
                        break;

                    case 0:
                        inTopicMenu = false;
                        return; // clean exit

                    default:
                        System.out.println("Invalid topic!");
                }
            }
        }

        private void handleQuizMenu() {
            str.QuizMenu();

            System.out.print("Enter option (1 to start, 2 to go back): ");
            choice = readInt();

            switch (choice) {
                case 1:
                    str.ProgressBar();
                    System.out.println("Quiz started! Answering questions...");
                    str.DisplayQuiz();
                    waitForEnter();
                    return;

                case 2:
                    System.out.println("Returning to topics...");
                    return;
            }
        }

        private void handleSettingsMenu() {
            str.SettingsMenu();  // Show settings menu first
            handleSettings();  // Then handle input
        }

        private void handleSettings() {
            while (true) {
                System.out.print("Enter option: ");
                setting = readInt();

                switch (setting) {
                    case 1:
                        System.out.println("=== User Settings ===");
                        System.out.println("Username: Quiz User");
                        System.out.println("Difficulty: Medium");
                        System.out.println("Sound: ON");
                        waitForEnter();
                        break;

                    case 2:
                        System.out.println("=== Progress Level ===");
                        System.out.println("Current Level: 1");
                        System.out.println("XP: 0/100");
                        System.out.println("Quizzes Completed: 0");
                        waitForEnter();
                        break;

                    case 3:
                        System.out.println("Returning to main menu...");
                        return;

                    default:
                        System.out.println("Invalid option, try again");
                }
            }
        }

        private void handleHistoryMenu() {
            str.HistoryMenu();  // Show history menu
            System.out.println("=== Quiz History ===");
            System.out.println("No quizzes completed yet!");
            System.out.println("Complete a quiz to see your history here.");
            waitForEnter();
            // Automatically returns to main menu
        }

        private void waitForEnter() {
            System.out.print("Press Enter to continue...");
            scanner.nextLine();

        }

        private int readInt() {
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a number!");
                scanner.next(); // discard bad input
            }
            int val = scanner.nextInt();
            scanner.nextLine(); // clear buffer
            return val;
        }
    }


