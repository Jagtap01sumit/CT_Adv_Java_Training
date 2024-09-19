package com.citiustech.test;
import java.util.Scanner;



import com.citiustech.store.*;
import com.citiustech.store.Clothing;
import com.citiustech.store.Product;
public class ProductStore {
    private Product[] products = new Product[10];
    private Product[] cart = new Product[10];
    private int productIndex = 0;
    private int cartIndex = 0;
    private Scanner scanner = new Scanner(System.in);

    public void addProduct() {
        System.out.println("1. Electronics");
        System.out.println("2. Clothing");
        System.out.print("Enter product type: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                addElectronics();
                break;
            case 2:
                addClothing();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void addElectronics() {
        System.out.print("Enter electronics name: ");
        String name = scanner.nextLine();
        System.out.print("Enter electronics price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over

        Product electronics = new Electronics(name, price);
        products[productIndex++] = electronics;
        System.out.println("Electronics added successfully!");
    }

    private void addClothing() {
        System.out.print("Enter clothing name: ");
        String name = scanner.nextLine();
        System.out.print("Enter clothing price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Enter clothing size: ");
        String size = scanner.nextLine();
        System.out.print("Enter clothing season: ");
        String season = scanner.nextLine();

        Product clothing = new Clothing(name, price, size, season);
        products[productIndex++] = clothing;
        System.out.println("Clothing added successfully!");
    }

    public void viewProducts() {
        if (productIndex == 0 ) {
            System.out.println("No products available!");
            return;
        }

        for (int i = 0; i < productIndex; i++) {
            Product product = products[i];
            System.out.println((i + 1) + ". " + product.getName() + " - " + product.getPrice());
        }
    }

  public void buyProduct() {
    if (productIndex == 0) {
        System.out.println("No products available!");
        return;
    }

    System.out.println("Enter product index to buy (starts from 1): ");
    for (int i = 0; i < productIndex; i++) {
        Product product = products[i];
        System.out.println((i + 1) + ". " + product.getName() + " - " + product.getPrice());
    }

    int choice = scanner.nextInt();
    scanner.nextLine(); 

    if (choice > 0 && choice <= productIndex) {
        Product product = products[choice - 1];

       
        if (product instanceof DiscountStrategy) {
            DiscountStrategy discountStrategy = (DiscountStrategy) product;
            discountStrategy.applyDiscount();
        }

        cart[cartIndex++] = product;
        for (int i = choice - 1; i < productIndex - 1; i++) {
            products[i] = products[i + 1];
        }
        productIndex--;
        System.out.println("Product added to cart successfully!");
    } else {
        System.out.println("Invalid choice. Please try again.");
    }
}
    

    public void viewCart() {
        if (cartIndex == 0) {
            System.out.println("Cart is empty!");
            return; 
        }
            int total=0;
        for (int i = 0; i < cartIndex; i++) {
                Product product = cart[i];
                System.out.println((i + 1) + ". " + product.getName() + " - " + product.calculateFinalPrice());
                total += product.calculateFinalPrice();
        }

            System.out.println("Total: " + total);
        }

        public static void main(String[] args) {
            ProductStore store = new ProductStore();
            boolean check = true;
            do {
                System.out.println("1. Add product");
                System.out.println("2. View products");
                System.out.println("3. Buy product");
                System.out.println("4. View cart");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = store.scanner.nextInt();
                store.scanner.nextLine(); // Consume newline left-over

                switch (choice) {
                    case 1:
                        store.addProduct();
                        break;
                    case 2:
                        store.viewProducts();
                        break;
                    case 3:
                        store.buyProduct();
                        break;
                    case 4:
                        store.viewCart();
                        break;
                    case 5:
                        check = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (check);
        }
    }
        

