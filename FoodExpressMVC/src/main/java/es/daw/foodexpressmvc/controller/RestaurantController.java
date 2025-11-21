package es.daw.foodexpressmvc.controller;

import es.daw.foodexpressmvc.dto.RestaurantDTO;
import es.daw.foodexpressmvc.service.RestaurantsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantsService  restaurantsService;

    @GetMapping("/restaurants")
    public String listRestaurants(Model model) {

        List<RestaurantDTO> restaurants = restaurantsService.getAllRestaurants();

        model.addAttribute("restaurants", restaurants);

        return "restaurants";

    }

    @GetMapping("/menu")
    public String showMenu(Principal principal, Model model) {
        model.addAttribute(principal.getName());
        return "restuarants/restaurants-menu";
    }

    public String showForm(Model model, Principal principal) {
        model.addAttribute(principal.getName());
        model.addAttribute("restaurants", new RestaurantDTO());
        return "restaurants/restaurant-create";
    }

    public String create(@ModelAttribute("restaurant") RestaurantDTO restaurantDTO, Principal principal) {
        
    }



}
