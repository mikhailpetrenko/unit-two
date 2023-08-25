import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Cupcake> cupcakeMenu = new ArrayList<>();
        Cupcake cupcake = new Cupcake();
        RedVelvet redVelvet = new RedVelvet();
        Chocolate chocolate = new Chocolate();
        System.out.println("We're in the middle of creating the cupcake menu. We currently have three cupcakses on the menu, but we need to decide on pricing");
        Scanner input = new Scanner(System.in);

        // working on cupcake price:
        System.out.println("We are decidint on the price for our standard cupcake. Here is the description:");
        cupcake.type();
        System.out.println("How much would you like to charge for the cupcake?");
        String priceText = input.nextLine();
        double price = Double.parseDouble(priceText);
        cupcake.setPrice(price);

        // working on redvelvet price:
        System.out.println("We are deciding on the price for our red vedvelvet cupcake. Here is the description:");
        redVelvet.type();
        System.out.println("How much would you like to charge for the redvelvet?");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        redVelvet.setPrice(price);

        System.out.println("We are decidint on the price for our chocolate cupcake. Here is the description:");
        chocolate.type();
        System.out.println("How much would you like to charge for the chocolate cupcake?");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        chocolate.setPrice(price);

        // adding cupcakes to our menu:
        cupcakeMenu.add(cupcake);
        cupcakeMenu.add(redVelvet);
        cupcakeMenu.add(chocolate);


        // PART 2:
        ArrayList<Drink> drinkMenu = new ArrayList<>();

        Drink water = new Drink();
        Soda soda = new Soda();
        Milk milk = new Milk();

        System.out.println("We're in the middle of creating the drink menu");
        input = new Scanner(System.in);

        // working on water price:
        System.out.println("We are decidint on the price for our water. Here is the description:");
        cupcake.type();
        System.out.println("How much would you like to charge for the cupcake?");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        water.setPrice(price);

        // working on soda price:
        System.out.println("We are deciding on the price for our red soda. Here is the description:");
        redVelvet.type();
        System.out.println("How much would you like to charge for the soda?");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        soda.setPrice(price);

        System.out.println("We are decidint on the price for our milk. Here is the description:");
        chocolate.type();
        System.out.println("How much would you like to charge for the mlk?");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        milk.setPrice(price);

        // adding cupcakes to our menu:
        drinkMenu.add(water);
        drinkMenu.add(soda);
        drinkMenu.add(milk);

        // PART 3:
        new Order(cupcakeMenu, drinkMenu);



    }
}
class Cupcake {
    public double price;
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void type() {
        System.out.println("A basic, generic cupcake, with vanilla frosting");
    }
}
class RedVelvet extends Cupcake {
    public void type() {
        System.out.println("A red velvet based cupcake, with cream cheese frosting.");
    }
}
class Chocolate extends Cupcake {
    public void type() {
        System.out.println("A chocolate based cupcake, with cream cheese frosting.");
    }
}

class Drink {
    public double price;
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void type() {
        System.out.println("A bottle of water");
    }
}
class Soda extends Drink {
    public void type() {
        System.out.println("A bottle of soda");
    }
}
class Milk extends Drink {
    public void type() {
        System.out.println("A glass of milk");
    }
}