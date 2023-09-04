import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Buy Coffee");
            System.out.println("2. Fill Ingredients");
            System.out.println("3. Take Money");
            System.out.println("4. Show Ingredients");
            System.out.println("5. Analytics");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nSelect Coffee Type:");
                    System.out.println("1. Espresso");
                    System.out.println("2. Latte");
                    System.out.println("3. Cappuccino");
                    int coffeeChoice = scanner.nextInt();
                    switch (coffeeChoice) {
                        case 1:
                            coffeeMachine.makeCoffee(CoffeeType.ESPRESSO);
                            break;
                        case 2:
                            coffeeMachine.makeCoffee(CoffeeType.LATTE);
                            break;
                        case 3:
                            coffeeMachine.makeCoffee(CoffeeType.CAPPUCCINO);
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;
                case 2:
                    System.out.print("Enter amount of water to add (ml): ");
                    int addedWater = scanner.nextInt();
                    System.out.print("Enter amount of milk to add (ml): ");
                    int addedMilk = scanner.nextInt();
                    System.out.print("Enter amount of coffee beans to add (grams): ");
                    int addedBeans = scanner.nextInt();
                    coffeeMachine.fillIngredients(addedWater, addedMilk, addedBeans);
                    break;
                case 3:
                    coffeeMachine.takeMoney();
                    break;
                case 4:
                    coffeeMachine.showIngredients();
                    break;
                case 5:
                    coffeeMachine.displayAnalytics();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}