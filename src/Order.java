import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Order {
    public Order(ArrayList<Cupcake> cupcakeMenu, ArrayList<Drink> drinkMenu) {
        System.out.println("Hello, customer! Would you like to place an order? (Y or N)");
        Scanner input = new Scanner(System.in);
        String placeOrder = input.nextLine();
        ArrayList<Object> order = new ArrayList<>();
        if (placeOrder.equalsIgnoreCase("y")) {
            order.add(LocalDate.now());
            order.add(LocalTime.now());
            System.out.println("Here's the menu");
            System.out.println("CUPCAKES");
            int itemNumber = 0;
            for (int ind = 0; ind<cupcakeMenu.size(); ind++) {
                itemNumber++;
                System.out.println(itemNumber);
                cupcakeMenu.get(ind).type();
                System.out.println("Price: "+cupcakeMenu.get(ind).getPrice());
                System.out.println();
            }
            System.out.println("DRINKS");
            for (int ind = 0; ind<drinkMenu.size(); ind++) {
                itemNumber++;
                System.out.println(itemNumber);
                drinkMenu.get(ind).type();
                System.out.println("Price: "+drinkMenu.get(ind).getPrice());
                System.out.println();
            }
            boolean ordering = true;
            while (ordering) {
                System.out.println("What would you like to order? Please use the number associated with each item to order");

                int orderChoice = input.nextInt();
                if (orderChoice == 1) {
                    order.add(cupcakeMenu.get(0));
                    System.out.println("Basic cupcake added to order");
                } else if (orderChoice == 2) {
                    order.add(cupcakeMenu.get(1));
                    System.out.println("Red Velvet cupcake added to order");
                } else if (orderChoice == 3) {
                    order.add(cupcakeMenu.get(2));
                    System.out.println("Chocolate cupcake added to order");
                } else if (orderChoice == 4) {
                    order.add(drinkMenu.get(0));
                    System.out.println("soda added to order");
                } else if (orderChoice == 5) {
                    order.add(drinkMenu.get(1));
                    System.out.println("water added to order");
                } else if (orderChoice == 6) {
                    order.add(drinkMenu.get(2));
                    System.out.println("milk added to order");
                }
                else {
                    System.out.println("Sorry, we don't seem to have that on the menu");
                }
                input.nextLine();

                System.out.println("Woould you like to continue ordering? Y/N?");
                placeOrder = input.nextLine();
                System.out.println("The placeOrder is: "+placeOrder);
                if (!placeOrder.equalsIgnoreCase("y")) {
                    ordering = false;
                }
            }
            System.out.println(order.get(0));
            System.out.println(order.get(1));
            double subtotal = 0;
            for (int i = 2; i<order.size(); i++) {
                if (order.get(i) == cupcakeMenu.get(0)) {
                    cupcakeMenu.get(0).type();
                    System.out.println("Price of that is: "+cupcakeMenu.get(0).getPrice());
                    subtotal += cupcakeMenu.get(0).getPrice();

                }
                else if (order.get(i) == cupcakeMenu.get(1)) {
                    cupcakeMenu.get(1).type();
                    System.out.println("Price of that is: "+cupcakeMenu.get(1).getPrice());
                    subtotal += cupcakeMenu.get(1).getPrice();
                }
                else if (order.get(i) == cupcakeMenu.get(2)) {
                    cupcakeMenu.get(2).type();
                    System.out.println("Price of that is: "+cupcakeMenu.get(2).getPrice());
                    subtotal += cupcakeMenu.get(2).getPrice();
                }
                else if (order.get(i) == drinkMenu.get(0)) {
                    drinkMenu.get(0).type();
                    System.out.println("Price of that is: "+drinkMenu.get(0).getPrice());
                    subtotal += drinkMenu.get(0).getPrice();
                }
                else if (order.get(i) == drinkMenu.get(1)) {
                    drinkMenu.get(1).type();
                    System.out.println("Price of that is: "+drinkMenu.get(1).getPrice());
                    subtotal += drinkMenu.get(1).getPrice();
                }
                else if (order.get(i) == drinkMenu.get(2)) {
                    drinkMenu.get(2).type();
                    System.out.println("Price of that is: "+drinkMenu.get(2).getPrice());
                    subtotal += drinkMenu.get(2).getPrice();
                }
            }
            System.out.println("Total amount to pay is: "+subtotal);
            new CreateFile();
            new WriteToFile(order);
        } else {
            System.out.println("Have a nice day then");
        }

    }
}
class CreateFile {
    public CreateFile() {
        try {
            File salesData = new File("salesData.txt");
            if (salesData.createNewFile()) {
                System.out.println("File created: "+salesData.getName());
            } else {
                System.out.println("File already exists");
            }

        } catch (IOException e){
            System.out.println("An error occurred");
        }
    }
}

class WriteToFile {
    public WriteToFile(ArrayList<Object> order) {
        try {
            FileWriter fw = new FileWriter("salesData.txt", true);
            PrintWriter salesWriter = new PrintWriter(fw);
            for (Object element : order) {
                salesWriter.println(element);
            }
            salesWriter.close();
            System.out.println("Successfully wrote to the file");
        } catch (IOException e){
            System.out.println("An error occurred");
        }
    }
}
