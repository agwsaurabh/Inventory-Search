package main.java.services;

import main.java.model.Inventory;
import main.java.model.Product;

public class InventoryManagement {

    public void addProductToInventory (final Inventory inventory, final Product product) {
        inventory.getProducts().add(product);
        System.out.println("Product Added Successfully");
    }

    public void deleteProductFromInventory(final Inventory inventory, final Integer productId) {
        inventory.getProducts().removeIf(entry -> entry.getProductId().equals(productId));
        System.out.println("Product Deleted Successfully");
    }

    public void modifyProductInInventory(final Inventory inventory, final Product product) {
        deleteProductFromInventory(inventory, product.getProductId());
        addProductToInventory(inventory, product);
        System.out.println("Product Modified Successfully");
    }
}
