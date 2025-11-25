package es.daw.foodexpressapi.mapper;

import es.daw.foodexpressapi.dto.DishDTO;
import es.daw.foodexpressapi.entity.Dish;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DishMapper {

    @Mapping(source = "restaurant.name", target = "restaurantName")
    DishDTO toDTO(Dish entity);

    @Mapping(source = "restaurantName", target = "restaurant.name")
    Dish toEntity(DishDTO dto);
}
