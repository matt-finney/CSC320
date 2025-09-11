package testing;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        clearScreen();
        Scanner scanner = new Scanner(System.in);
        String[] shoppingCartIDs = new String[5];
        // Loop to listen for items to add to cart
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter item ID to add to cart: ");
            shoppingCartIDs[i] = scanner.nextLine();
        }
        System.out.println();
        // Example IDs: "X0010234", "X0033455", "X0067853", "X0098765", "X0012345"
        for (String id : shoppingCartIDs) {
            System.out.println("Shopping Cart ID: " + id);
        }
        scanner.close();
    }



    public static void clearScreen() 
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
