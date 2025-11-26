import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class car {
    String model;
    double price;

    public car(String model, double price) {
        this.model = model;
        this.price = price;
    }

    @Override
    public String toString() {
        return model + " - " + price;
    }
}

class carInventory {
    ArrayList<car> inventory;

    public carInventory() {
        inventory = new ArrayList<>();
    }

    public void addCar(String model, double price) {
        car car = new car(model,price);
        inventory.add(car);
    }

    public void sortByPrice() {
        Collections.sort(inventory, Comparator.comparingDouble(car -> car.price));
    }

    public void displayInventory() {
        for (car car : inventory) {
            System.out.println(car);
        }
    }
}

 class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        carInventory carInventory = new carInventory();

        System.out.print("Araba sayısına giriniz: ");
        int numOfCars = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numOfCars; i++) {
            System.out.print(" modeli giriniz: ");
            String model = scanner.nextLine();
            System.out.print("fiyat giriniz: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            carInventory.addCar(model,price);
        }

        carInventory.sortByPrice();

        System.out.println("sıralanmış araba envanteri:");
        carInventory.displayInventory();

        scanner.close();
    }
}
