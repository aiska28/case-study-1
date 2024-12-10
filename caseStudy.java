import java.util.Scanner;

public class caseStudy {
    static String[][] nameStudent = new String[5][5];
    static int row = 0;

    static void archievement() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Name Student College: ");
        nameStudent[row][0] = input.nextLine();
        System.out.print("Enter NIM Student College: ");
        int nim = input.nextInt();
        nameStudent[row][1] = String.valueOf(nim);
        input.nextLine();
        System.out.print("Enter Achievement Type: ");
        nameStudent[row][2] = input.nextLine();

        String level;
        while (true) {
            System.out.print("Enter level achievement (Local/National/International): ");
            level = input.next();
            if (level.equalsIgnoreCase("Local") || level.equalsIgnoreCase("National") || level.equalsIgnoreCase("International")) {
                nameStudent[row][3] = level;
                break;
            } else {
                System.out.println("Level is invalid. Please try again.");
            }
        }

        int year;
        while (true) {
            System.out.print("Enter year of achievement: ");
            year = input.nextInt();
            if (year >= 2010 && year <= 2024) {
                nameStudent[row][4] = String.valueOf(year);
                System.out.println("Achievement data successfully added.");
                break;
            } else {
                System.out.println("Achievement data is invalid. Please try again.");
            }
        }
        row++;
    }

    static void displayingLists() {
        if (row == 0) {
            System.out.println("No achievements to display.");
            return;
        }

        System.out.println("=== LIST OF ALL ACHIEVEMENTS ==="); 
        for (int i = 0; i < row; i++) {
        System.out.println("\nName: " + nameStudent[i][0] + " | " + "NIM: " + nameStudent[i][1] + " | " + "Type: " + nameStudent[i][2] +
         " | " + "Level: " + nameStudent[i][3] + " | " + "Year: " + nameStudent[i][4] + " | ");}
    }

    static void analyzeAchievements() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the Type of Achievement you want to Analyze: ");
        String typeAnalyze = input.nextLine();

        System.out.println("=== ANALYSIS ===");
        boolean found = false;
        for (int i = 0; i < row; i++) {
            if (nameStudent[i][2].equalsIgnoreCase(typeAnalyze)) {
                System.out.println("Name: " + nameStudent[i][0] + " | NIM: " + nameStudent[i][1] + " | Level: " + nameStudent[i][3] + " | Year: " + nameStudent[i][4]);
                found = true;
            } else if (!found) {
                System.out.println("No achievements found for the specified type.");
            }
        }
    } 

    static void exit() {
        System.out.println("Program finished. Thank you.");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int menu = 0;

        while (menu != 4) {
            System.out.println();
            System.out.println("=== STUDENT ACHIEVEMENT RECORD ===");
            System.out.println("1. Add Achievement Data");
            System.out.println("2. Display All Achievements");
            System.out.println("3. Analyze Achievements by Type");
            System.out.println("4. Exit");
            System.out.print("Choose menu: ");
            menu = input.nextInt();
            input.nextLine();

            switch (menu) {
                case 1:
                    archievement();
                    break;
                case 2:
                    displayingLists();
                    break;
                case 3:
                    analyzeAchievements();
                    break;
                case 4:
                    exit();
                    break;
                default:
                    System.out.println("Invalid menu. Try again.");
            }
        }
    }
}
