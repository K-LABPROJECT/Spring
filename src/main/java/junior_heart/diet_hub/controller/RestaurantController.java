package junior_heart.diet_hub.controller;

import junior_heart.diet_hub.service.RestaurantService;
import junior_heart.diet_hub.service.dto.RestaurantSearchResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public ResponseEntity<RestaurantSearchResponse> search(@RequestParam(value = "title") String title) {
        RestaurantSearchResponse response = restaurantService.search(title);
        return ResponseEntity.ok(response);
    }
}
