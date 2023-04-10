package main.java.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Inventory {
    private List<Product> products;
    private String category;
    private Integer inventoryId;
}
