
    import java.util.Scanner;

    public class UserOptOne extends StrInterfaces {
        private Scanner scanner;
        private boolean running;

        public UserOptOne() {
            this.scanner = new Scanner(System.in);
            this.running = true;
        }

        public void Start() {
            while (running) {
                Menu(); // Displaying the menu interface
                handleMenuOptions(); // Handling the user input
            }
            scanner.close();
        }

        private void handleMenuOptions() {
            System.out.print("Enter option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    handleSelectTopic();  // Fixed: Call topic handler instead of recursion
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
            SelectTopic();  // Show topic selection menu
            System.out.print("Enter topic choice (1-3) or 0 to go back: ");
            int topic = scanner.nextInt();
            scanner.nextLine();

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
                    System.out.println("Returning to main menu...");
                    break;  // Go back to main menu
                default:
                    System.out.println("Invalid topic! Please try again");
                    handleSelectTopic();  // Recursively ask again
                    break;
            }
        }

        private void handleQuizMenu() {
            QuizMenu();  // Show quiz menu
            System.out.print("Enter option (1 to start, 2 to go back): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    ProgressBar();
                    System.out.println("Quiz started! Answering questions...");
                    // Add actual quiz logic here
                    System.out.println("Quiz completed! Score: 0/0");
                    waitForEnter();
                    break;
                case 2:
                    System.out.println("Returning to topics...");
                    handleSelectTopic();  // Go back to topic selection
                    break;
                default:
                    System.out.println("Invalid option!");
                    handleQuizMenu();  // Try again
                    break;
            }
        }

        private void handleSettingsMenu() {
            SettingsMenu();  // Show settings menu first
            handleSettings();  // Then handle input
        }

        private void handleSettings() {
            System.out.print("Enter option: ");
            int setting = scanner.nextInt();
            scanner.nextLine();

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
                    System.out.println("Logging out...");
                    // Just return to main menu
                    break;
                default:
                    System.out.println("Invalid option, try again");
                    handleSettings();  // Recursively ask again
                    break;
            }
        }

        private void handleHistoryMenu() {
            HistoryMenu();  // Show history menu
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
    }

