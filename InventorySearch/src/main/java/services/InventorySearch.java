package main.java.services;

import main.java.model.Inventory;
import main.java.model.Product;

import java.util.*;
import java.util.stream.Collectors;

public class InventorySearch {

    public Set<String> search(String searchTerm, List<Inventory> inventories) {
        final List<Product> products = inventories.stream().flatMap(inventory -> inventory.getProducts().stream()).toList();
        final String[] searchParams = searchTerm.toLowerCase().split("\\s+");
        final Set<String> matches = new HashSet<>();

        products.forEach(product -> {
                final String[] productTerms = product.getProductDescription().toLowerCase().split("\\s+");
                for (String searchParam : searchParams) {
                    for (String productTerm : productTerms) {
                        if (productTerm.contains(searchParam)) {
                            matches.add(product.getProductDescription());
                            break;
                        }
                    }
                }
            });
        return matches;
    }
}
