


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdvancedArrayListOps {
    private ArrayList<String> stringList;

    public AdvancedArrayListOps() {
        stringList = new ArrayList<>();
    }

    // a) Append
    public void append(String str) {
        stringList.add(str);
    }

    // b) Insert
    public void insert(int index, String str) {
        if (index >= 0 && index <= stringList.size()) {
            stringList.add(index, str);
        } else {
            System.out.println("Invalid index.");
        }
    }

    // c) Search
    public boolean search(String str) {
        return stringList.contains(str);
    }

    // d) List strings starting with a letter
    public ArrayList<String> listStartingWith(char letter) {
        ArrayList<String> result = new ArrayList<>();
        for (String s : stringList) {
            if (s.toLowerCase().startsWith(Character.toString(letter).toLowerCase())) {
                result.add(s);
            }
        }
        return result;
    }

    // e) Sort strings
    public void sortAscending() {
        Collections.sort(stringList);
    }

    public void sortDescending() {
        Collections.sort(stringList, Collections.reverseOrder());
    }

    // f) Case-insensitive search using regex
    public ArrayList<String> regexSearch(String regex) {
        ArrayList<String> result = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        for (String s : stringList) {
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                result.add(s);
            }
        }
        return result;
    }

    // Remove duplicates using LinkedHashSet
    public void removeDuplicates() {
        LinkedHashSet<String> set = new LinkedHashSet<>(stringList);
        stringList.clear();
        stringList.addAll(set);
    }

    // Partial match search
    public ArrayList<String> partialMatch(String substring) {
        ArrayList<String> result = new ArrayList<>();
        for (String s : stringList) {
            if (s.toLowerCase().contains(substring.toLowerCase())) {
                result.add(s);
            }
        }
        return result;
    }

    // Display all strings
    public void display() {
        if (stringList.isEmpty()) {
            System.out.println("(List is empty)");
        } else {
            for (String s : stringList) {
                System.out.println(s);
            }
        }
    }

    // Get internal list (for testing or further processing)
    public ArrayList<String> getStringList() {
        return stringList;
    }

    // Menu-based MAIN method
    public static void main(String[] args) {
        AdvancedArrayListOps ops = new AdvancedArrayListOps();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Append a string");
            System.out.println("2. Insert a string at specific index");
            System.out.println("3. Search for a string");
            System.out.println("4. List strings starting with a letter");
            System.out.println("5. Sort strings ascending");
            System.out.println("6. Sort strings descending");
            System.out.println("7. Remove duplicates");
            System.out.println("8. Partial match search");
            System.out.println("9. Regex search");
            System.out.println("10. Display all strings");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter string to append: ");
                    String appendStr = scanner.nextLine();
                    ops.append(appendStr);
                    break;

                case 2:
                    System.out.print("Enter string to insert: ");
                    String insertStr = scanner.nextLine();
                    System.out.print("Enter index: ");
                    try {
                        int index = Integer.parseInt(scanner.nextLine());
                        ops.insert(index, insertStr);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 3:
                    System.out.print("Enter string to search: ");
                    String searchStr = scanner.nextLine();
                    if (ops.search(searchStr)) {
                        System.out.println("Found!");
                    } else {
                        System.out.println("Not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter starting letter: ");
                    String input = scanner.nextLine();
                    if (input.length() > 0) {
                        char letter = input.charAt(0);
                        ArrayList<String> startsWith = ops.listStartingWith(letter);
                        Collections.sort(startsWith);
                        System.out.println("Matching strings:");
                        startsWith.forEach(System.out::println);
                    } else {
                        System.out.println("Invalid letter.");
                    }
                    break;

                case 5:
                    ops.sortAscending();
                    System.out.println("Sorted (Ascending):");
                    ops.display();
                    break;

                case 6:
                    ops.sortDescending();
                    System.out.println("Sorted (Descending):");
                    ops.display();
                    break;

                case 7:
                    ops.removeDuplicates();
                    System.out.println("Duplicates removed.");
                    break;

                case 8:
                    System.out.print("Enter substring to search: ");
                    String substring = scanner.nextLine();
                    ArrayList<String> partialMatches = ops.partialMatch(substring);
                    System.out.println("Partial matches:");
                    partialMatches.forEach(System.out::println);
                    break;

                case 9:
                    System.out.print("Enter regex pattern: ");
                    String regex = scanner.nextLine();
                    ArrayList<String> regexMatches = ops.regexSearch(regex);
                    System.out.println("Regex matches:");
                    regexMatches.forEach(System.out::println);
                    break;

                case 10:
                    System.out.println("Current List:");
                    ops.display();
                    break;

                case 11:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 11);

        scanner.close();
    }
}
