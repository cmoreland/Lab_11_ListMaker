import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<String> itemList = new ArrayList<>();
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        char choice;

        do {
            displayMenu();
            String input = SafeInput.getRegExString(in, "Enter your choice","[AaDdPpQq]");
            choice = input.toUpperCase().charAt(0);

            switch (choice) {
                case 'A':
                    addItem();
                    break;
                case 'D':
                    deleteItem();
                    break;
                case 'P':
                    printList();
                    break;
                case 'Q':
                    if (confirmQuit()) {
                        System.out.println("Exiting program. Goodbye!");
                        System.exit(0);
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 'Q');
    }

    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("A – Add an item to the list");
        System.out.println("D – Delete an item from the list");
        System.out.println("P – Print the list");
        System.out.println("Q – Quit");

        System.out.println("\nCurrent List:");
        displayNumberedItems();
    }

    private static void displayNumberedItems() {
        for (int i = 0; i < itemList.size(); i++) {
            System.out.println((i + 1) + ". " + itemList.get(i));
        }
        System.out.println();
    }

    private static void addItem() {
        String newItem = SafeInput.getRegExString(in, "Enter item to add", ".+"); // Accept any non-empty string
        itemList.add(newItem);
        System.out.println("Item added: " + newItem);
    }

    private static void deleteItem() {
        if (itemList.isEmpty()) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        displayNumberedItems();
        int itemNumber = SafeInput.getRangedInt(in, "Enter item number to delete: ", 1, itemList.size());
        String deletedItem = itemList.remove(itemNumber - 1);
        System.out.println("Item deleted: " + deletedItem);
    }

    private static void printList() {
        if (itemList.isEmpty()) {
            System.out.println("List is empty.");
        } else {
            System.out.println("Current List:");
            displayNumberedItems();
        }
    }

    private static boolean confirmQuit() {
        return SafeInput.getYNConfirm(in,"Are you sure you want to quit? (Y/N): ");
    }
}
