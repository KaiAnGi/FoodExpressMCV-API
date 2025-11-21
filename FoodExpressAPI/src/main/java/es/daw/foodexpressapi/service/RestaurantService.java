package es.daw.foodexpressapi.service;

import es.daw.foodexpressapi.dto.RestaurantDTO;
import es.daw.foodexpressapi.entity.Restaurant;
import es.daw.foodexpressapi.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public List<RestaurantDTO> getAllRestaurants(){
        return restaurantRepository.findAll().stream()
                .map(this::toDTO)
                .toList();

    }

    public Optional<RestaurantDTO> create(RestaurantDTO restaurantDTO){
        Restaurant restaurant = toEntity(restaurantDTO);
        Restaurant saved = restaurantRepository.save(restaurant);
        return Optional.of(this.toDTO(saved));
    }


    public RestaurantDTO toDTO(Restaurant restaurant){
        return RestaurantDTO.builder()
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .phone(restaurant.getPhone())
                .build();
    }

    public Restaurant toEntity(RestaurantDTO restaurantDTO){
        Restaurant restaurant = new Restaurant();
        restaurant.setName(restaurantDTO.getName());
        restaurant.setAddress(restaurantDTO.getAddress());
        restaurant.setPhone(restaurantDTO.getPhone());
        return restaurant;
    }

}
