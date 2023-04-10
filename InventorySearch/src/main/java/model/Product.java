package main.java.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String productDescription;
    private String category;
    private String color;
    private Integer productId;
}
