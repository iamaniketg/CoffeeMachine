public class CoffeeMachine {
    private int water;
    private int milk;
    private int beans;
    private int moneyEarned;
    private int espressoSold;
    private int latteSold;
    private int cappuccinoSold;

    public CoffeeMachine() {
        this.water = 0;
        this.milk = 0;
        this.beans = 0;
        this.moneyEarned = 0;
        this.espressoSold = 0;
        this.latteSold = 0;
        this.cappuccinoSold = 0;
    }

    public void showIngredients() {
        System.out.println("Water: " + water + " ml");
        System.out.println("Milk: " + milk + " ml");
        System.out.println("Coffee Beans: " + beans + " grams");
        System.out.println("Money Earned: $" + moneyEarned);
    }

    public void fillIngredients(int addedWater, int addedMilk, int addedBeans) {
        this.water += addedWater;
        this.milk += addedMilk;
        this.beans += addedBeans;
    }

    public void takeMoney() {
        System.out.println("Taking $" + moneyEarned + " from the money box.");
        moneyEarned = 0;
    }

    public boolean makeCoffee(CoffeeType coffeeType) {
        int waterNeeded = coffeeType.getWaterRequired();
        int milkNeeded = coffeeType.getMilkRequired();
        int beansNeeded = coffeeType.getBeansRequired();
        int price = coffeeType.getPrice();

        if (water >= waterNeeded && milk >= milkNeeded && beans >= beansNeeded) {
            System.out.println("Dispensing " + coffeeType.getName() + "...");
            water -= waterNeeded;
            milk -= milkNeeded;
            beans -= beansNeeded;
            moneyEarned += price;

            switch (coffeeType) {
                case ESPRESSO:
                    espressoSold++;
                    break;
                case LATTE:
                    latteSold++;
                    break;
                case CAPPUCCINO:
                    cappuccinoSold++;
                    break;
            }

            return true;
        } else {
            System.out.println("Error: Not enough ingredients to make " + coffeeType.getName());
            return false;
        }
    }

    public void displayAnalytics() {
        System.out.println("Coffee sold: ");
        System.out.println("Espresso: " + espressoSold);
        System.out.println("Latte: " + latteSold);
        System.out.println("Cappuccino: " + cappuccinoSold);
        System.out.println("Total Earnings: $" + moneyEarned);
        System.out.println("Ingredients Consumed:");
        System.out.println("Water: " + (espressoSold * CoffeeType.ESPRESSO.getWaterRequired() +
                latteSold * CoffeeType.LATTE.getWaterRequired() +
                cappuccinoSold * CoffeeType.CAPPUCCINO.getWaterRequired()) + " ml");
        System.out.println("Milk: " + (espressoSold * CoffeeType.ESPRESSO.getMilkRequired() +
                latteSold * CoffeeType.LATTE.getMilkRequired() +
                cappuccinoSold * CoffeeType.CAPPUCCINO.getMilkRequired()) + " ml");
        System.out.println("Coffee Beans: " + (espressoSold * CoffeeType.ESPRESSO.getBeansRequired() +
                latteSold * CoffeeType.LATTE.getBeansRequired() +
                cappuccinoSold * CoffeeType.CAPPUCCINO.getBeansRequired()) + " grams");
    }
}

enum CoffeeType {
    ESPRESSO("Espresso", 4, 250, 0, 16),
    LATTE("Latte", 7, 350, 75, 20),
    CAPPUCCINO("Cappuccino", 6, 200, 100, 12);

    private final String name;
    private final int price;
    private final int waterRequired;
    private final int milkRequired;
    private final int beansRequired;

    CoffeeType(String name, int price, int waterRequired, int milkRequired, int beansRequired) {
        this.name = name;
        this.price = price;
        this.waterRequired = waterRequired;
        this.milkRequired = milkRequired;
        this.beansRequired = beansRequired;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getWaterRequired() {
        return waterRequired;
    }

    public int getMilkRequired() {
        return milkRequired;
    }

    public int getBeansRequired() {
        return beansRequired;
    }
}
