package es.daw.foodexpressapi.mapper;

import es.daw.foodexpressapi.dto.RestaurantDTO;
import es.daw.foodexpressapi.entity.Restaurant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {
    Restaurant toEntity(RestaurantDTO dto);
    RestaurantDTO toDTO(Restaurant entity);
}
