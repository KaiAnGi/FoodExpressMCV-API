package es.daw.foodexpressapi.service;

import es.daw.foodexpressapi.dto.DishDTO;
import es.daw.foodexpressapi.entity.Dish;
import es.daw.foodexpressapi.mapper.DishMapper;
import es.daw.foodexpressapi.repository.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishService {
    private final DishRepository dishRepository;
    private final DishMapper dishMapper;

    public List<DishDTO> getAllDishes() {
        return dishRepository.findAll().stream()
                .map(dishMapper::toDTO)
                .toList();
    }



    // ---------------- UTILIDADES TIPO MAPSTRUCT ------------------
    public DishDTO toDTO(Dish dish){
        return DishDTO.builder()
                .name(dish.getName())
                .price(dish.getPrice())
                .category(dish.getCategory())
                .restaurantName(dish.getRestaurant().getName())
                .build();
    }

    public Dish toEntity(DishDTO dto){
        Dish dish = new Dish();
        dish.setName(dto.getName());
        dish.setPrice(dto.getPrice());
        dish.setCategory(dto.getCategory());
        return dish;
    }


}
