package es.daw.foodexpressmvc.dto;

import lombok.Data;

@Data
public class DishesDTO {
    private Long id;
    private String name;
    private double price;
    private String category;
    private String restaurant_id;
}
