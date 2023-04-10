import main.java.model.Inventory;
import main.java.model.Product;
import main.java.services.InventoryManagement;
import main.java.services.InventorySearch;

import java.util.*;

public class Main {
    public static Integer productCounter = 1;

    public static void main(String[] args) {
        final Map<Integer, Inventory> inventoryMap = new HashMap<>();
        final Inventory electronics = new Inventory();
        electronics.setCategory("Electronics");
        electronics.setInventoryId(1);
        electronics.setProducts(new ArrayList<>());
        final Inventory apparels = new Inventory();
        apparels.setCategory("Apparels");
        apparels.setInventoryId(2);
        apparels.setProducts(new ArrayList<>());
        inventoryMap.put(1, electronics);
        inventoryMap.put(2, apparels);

        boolean loop = true;
        final InventoryManagement inventoryManagement = new InventoryManagement();
        final InventorySearch inventorySearch = new InventorySearch();

        while(loop) {
            System.out.println("Hello and welcome to PhonePe Inventory Search!");
            System.out.println("1. To add a Product to Inventory, Please press 1");
            System.out.println("2. To modify a Product in Inventory, Please press 2");
            System.out.println("3. To remove a Product from Inventory, Please press 3");
            System.out.println("4. To search for a Product in Inventory, Please press 4");
            System.out.println("5. Press 5 to close the program");

            Scanner sc = new Scanner(System.in);
            int operation = sc.nextInt();
            sc.nextLine();

            //Switch expression
            switch (operation) {
                //Case statements
                case 1 -> {
                    System.out.println("1. For adding product to Electronics Inventory, Please Press 1");
                    System.out.println("2. For adding product to Apparels Inventory, Please Press 2");
                    int inventoryId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Please enter product description : ");
                    final String productDescription = sc.nextLine();
                    System.out.print("Please enter product category, Press enter to skip : ");
                    final String category = sc.nextLine();
                    System.out.print("Please enter product color, Press enter to skip : ");
                    final String color = sc.nextLine();
                    int productId = productCounter;

                    final Inventory inventory = inventoryMap.get(inventoryId);
                    final Product product = new Product(productDescription, category, color, productId);

                    inventoryManagement.addProductToInventory(inventory, product);
                    productCounter++;
                }
                case 2 -> {
                    System.out.println("1. If the product belongs to Electronics Inventory, Please Press 1");
                    System.out.println("2. If the product belongs to Apparels Inventory, Please Press 2");
                    int inventoryId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Please enter the product ID, you wish to modify");
                    int productId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Please enter new product description, Press Enter to skip : ");
                    final String productDescription = sc.nextLine();
                    System.out.print("Please enter new product category, Press enter to skip : ");
                    final String category = sc.nextLine();
                    System.out.print("Please enter new product color, Press enter to skip : ");
                    final String color = sc.nextLine();

                    final Inventory inventory = inventoryMap.get(inventoryId);
                    final Product product =  new Product(productDescription, category, color, productId);

                    inventoryManagement.modifyProductInInventory(inventory, product);
                }
                case 3 -> {
                    System.out.println("1. If the product belongs to Electronics Inventory, Please Press 1");
                    System.out.println("2. If the product belongs to Apparels Inventory, Please Press 2");
                    int inventoryId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Please enter the product ID, you wish to remove");
                    int productId = sc.nextInt();
                    sc.nextLine();

                    final Inventory inventory = inventoryMap.get(inventoryId);

                    inventoryManagement.deleteProductFromInventory(inventory, productId);
                }
                case 4 -> {
                    System.out.println("Please describe the product you wish to search and then press enter : ");
                    final String searchTerm = sc.nextLine();
                    final List<Inventory> inventories = inventoryMap.values().stream().toList();

                    System.out.println(inventorySearch.search(searchTerm, inventories));
                }
                case 5 -> {
                    loop = false;
                }
            }
        }
    }
}
