import java.util.Scanner;
import java.lang.reflect.Method;

public class LibraryManagementSystem {

    public static Scanner inputs = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\n\n" + ConsoleColors.GREEN_BOLD + "LIBRARY MANAGEMENT SYSTEM" + ConsoleColors.RESET + "\n");
        Commands.list();
        Commands.init();
    }

    public class ConsoleColors {

        public static final String RESET = "\033[0m"; // Text Reset

        // Regular Colors
        public static final String BLACK = "\033[0;30m"; // BLACK
        public static final String RED = "\033[0;31m"; // RED
        public static final String GREEN = "\033[0;32m"; // GREEN
        public static final String YELLOW = "\033[0;33m"; // YELLOW
        public static final String BLUE = "\033[0;34m"; // BLUE
        public static final String PURPLE = "\033[0;35m"; // PURPLE
        public static final String CYAN = "\033[0;36m"; // CYAN
        public static final String WHITE = "\033[0;37m"; // WHITE

        // Bold
        public static final String BLACK_BOLD = "\033[1;30m"; // BLACK
        public static final String RED_BOLD = "\033[1;31m"; // RED
        public static final String GREEN_BOLD = "\033[1;32m"; // GREEN
        public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
        public static final String BLUE_BOLD = "\033[1;34m"; // BLUE
        public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
        public static final String CYAN_BOLD = "\033[1;36m"; // CYAN
        public static final String WHITE_BOLD = "\033[1;37m"; // WHITE

        // Underline
        public static final String BLACK_UNDERLINED = "\033[4;30m"; // BLACK
        public static final String RED_UNDERLINED = "\033[4;31m"; // RED
        public static final String GREEN_UNDERLINED = "\033[4;32m"; // GREEN
        public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
        public static final String BLUE_UNDERLINED = "\033[4;34m"; // BLUE
        public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
        public static final String CYAN_UNDERLINED = "\033[4;36m"; // CYAN
        public static final String WHITE_UNDERLINED = "\033[4;37m"; // WHITE

        // Background
        public static final String BLACK_BACKGROUND = "\033[40m"; // BLACK
        public static final String RED_BACKGROUND = "\033[41m"; // RED
        public static final String GREEN_BACKGROUND = "\033[42m"; // GREEN
        public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
        public static final String BLUE_BACKGROUND = "\033[44m"; // BLUE
        public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
        public static final String CYAN_BACKGROUND = "\033[46m"; // CYAN
        public static final String WHITE_BACKGROUND = "\033[47m"; // WHITE

        // High Intensity
        public static final String BLACK_BRIGHT = "\033[0;90m"; // BLACK
        public static final String RED_BRIGHT = "\033[0;91m"; // RED
        public static final String GREEN_BRIGHT = "\033[0;92m"; // GREEN
        public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
        public static final String BLUE_BRIGHT = "\033[0;94m"; // BLUE
        public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
        public static final String CYAN_BRIGHT = "\033[0;96m"; // CYAN
        public static final String WHITE_BRIGHT = "\033[0;97m"; // WHITE

        // Bold High Intensity
        public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
        public static final String RED_BOLD_BRIGHT = "\033[1;91m"; // RED
        public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
        public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
        public static final String BLUE_BOLD_BRIGHT = "\033[1;94m"; // BLUE
        public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
        public static final String CYAN_BOLD_BRIGHT = "\033[1;96m"; // CYAN
        public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

        // High Intensity backgrounds
        public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
        public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
        public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
        public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
        public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
        public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
        public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m"; // CYAN
        public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m"; // WHITE
    }

    public static class Users {

        public static String list() {
            return "ME";
        }

        public static String set() {
            return "YOU";
        }
    }

    public static class Commands {

        public static void init() {
            System.out.println("\n================================================== \n" + ConsoleColors.BLUE_BACKGROUND_BRIGHT + "Enter command:" + ConsoleColors.RESET);
            String check = inputs.nextLine();
            String finCheck[] = check.split(" ");
            check = finCheck[0].substring(0, 1).toUpperCase() + finCheck[0].substring(1).toLowerCase() + "s";
            try {
                switch (check) {
                    case "Users":
                        if (finCheck[1].equals("list")) {
                            System.out.println(Users.list());
                        } else if (finCheck[1].equals("set")) {
                            System.out.println(Users.set());
                        }
                        break;

                    case "Books":
                        if (finCheck[1].equals("list")) {
                            System.out.println(Books.list());
                        } else if (finCheck[1].equals("set")) {
                            System.out.println(Books.set());
                        }
                        break;

                    case "Cmds":
                        Commands.list();
                        break;
                    case "Exits":
                        System.exit(0);
                        break;

                    default:
                        System.out.println(ConsoleColors.RED + "Error, command not found" + ConsoleColors.RESET);
                        break;
                }
            } catch (Exception e) {
                // System.out.println(e);
            } finally {
                System.out.println("====== End of line =======");
                Commands.init();
            }
        }

        public static void list() {
            Users users = new Users();
            Books books = new Books();
            System.out.println("\nCommand Lists:");

            System.out.println("cmd list");
            Method usersClass[] = users.getClass().getDeclaredMethods();
            for (Method user : usersClass) {
                if (user.getModifiers() == 9) {
                    System.out.println("user " + user.getName());
                }
            }

            Method Books[] = books.getClass().getDeclaredMethods();
            for (Method book : Books) {
                if (book.getModifiers() == 9) {
                    System.out.println("book " + book.getName());
                }
            }

            System.out.println("exit");
        }
    }

    public static class Books {

        private static String stored[][] = new String[10][3];

        // DO NOT USE STATIC METHOD IF YOU DONT NEED IT IN THE LIST OF COMMANDS
        public static String list() {
            String[][] books = Books.stored;

            // System.out.println(Arrays.deepToString(books));
            for (int i = 0; i < books.length; i++) {
                if (books[i][0] != null) {
                    System.out.println("\n===== BOOK ID: " + (i + 1) + " =======");
                    System.out.println("Name: " + books[i][0]);
                    System.out.println("Author: " + books[i][1]);
                    System.out.println("Date: " + books[i][2]);
                } else if (books[0][0] == null) {
                    System.out.println("\nNO BOOKS HAVE BEEN ADDED YET");
                    break;
                }
            }

            return "";
        }

        public static String set() {
            Scanner inputs = new Scanner(System.in);

            int counter = 1;
            for (int i = 0; i < Books.stored.length; i++) {
                for (int j = 0; j < Books.stored[i].length; j++) {
                    if (Books.stored[i][j] == null) {
                        if (counter == 1) {
                            System.out.println("\nPlease enter the book title:");
                            Books.stored[i][j] = inputs.nextLine();
                            counter++;
                        } else if (counter == 2) {
                            System.out.println("\nPlease enter the book author:");
                            Books.stored[i][j] = inputs.nextLine();
                            counter++;
                        } else if (counter == 3) {
                            System.out.println("\nPlease enter the date:");
                            Books.stored[i][j] = inputs.nextLine();
                            counter++;
                        }
                    }
                }
                if (counter > 3) {
                    break;

                }
                System.out.println();
            }

            return "";
        }
    }
}
