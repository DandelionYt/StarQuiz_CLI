//import java.util.Scanner;
//
//public class UserOptions extends StrInterfaces {
////    private int option;
//    private Scanner scanner;
//    private boolean running;
//    public UserOptions(){
//        this.scanner = new Scanner(System.in);
//        this.running = true;
////        this.option = options;
//    }
//    public void Start(){
//        while(running){
//            Menu(); //Displaying the menu interface
//            HandlesMenuOptions(); //Handling the user unput
//        }
//        scanner.close();
//    }
//    private void HandlesMenuOptions(){
//        System.out.print("Enter option: ");
//        int option = scanner.nextInt();
//        scanner.nextLine();
//        switch (option){
//            case 1:
//                //SelectTopic();
//                HandlesMenuOptions();
//                break;
//            case 2:
//                HistoryMenu();
//                break;
//            case 3:
//                //SettingsMenu();
//                HandlesSettings();
//                break;
//            case 4:
//                System.out.println("Thank you for your time");
//                running = false;
//                break;
//            default:
//                System.out.println("Invalid option! Please try again");
//                //Menu();
//
//        }
//
//    }
//    private void HandleSettingsMenu(){
//        SettingsMenu();
//        HandlesSettings();
//    }
//    private void HandlesSettings(){
//        //SettingsMenu();
//        System.out.println("Enter a option: ");
//        int setting = scanner.nextInt();
//        scanner.nextLine();
//        switch (setting){
//            case 1:
//                System.out.println("User settings");
//                break;
//            case 2:
//                System.out.println("Progress bar");
//                break;
//            case 3:
//                System.out.println("Logining out");
//                break;
//            default:
//                System.out.println("Invalid option,try again");
//                HandlesSettings();
//                break;
//        }
//
//    }
////    private void HandlesSelectTopic(){
////        System.out.println("Enter");
////    }
//}
