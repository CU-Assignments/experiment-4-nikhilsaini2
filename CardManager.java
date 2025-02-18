import java.util.*;

class CardManager {
    static HashMap<String, List<String>> cardCollection = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void addCard() {
        System.out.print("Enter Card Symbol: ");
        String symbol = sc.next();
        System.out.print("Enter Card Name: ");
        String cardName = sc.next();

        cardCollection.putIfAbsent(symbol, new ArrayList<>());
        cardCollection.get(symbol).add(cardName);
        System.out.println("Card added successfully!");
    }

    public static void findCards() {
        System.out.print("Enter Symbol to search: ");
        String symbol = sc.next();
        if (cardCollection.containsKey(symbol)) {
            System.out.println("Cards: " + cardCollection.get(symbol));
        } else {
            System.out.println("No cards found with this symbol.");
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Card\n2. Find Cards\n3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> addCard();
                case 2 -> findCards();
                case 3 -> System.exit(0);
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
