package junior_heart.diet_hub.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import junior_heart.diet_hub.service.RestaurantService;
import junior_heart.diet_hub.service.dto.RestaurantSearchResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Restaurants", description = "레스토랑")
@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Operation(summary = "레스토랑 검색")
    @GetMapping
    public ResponseEntity<RestaurantSearchResponse> search(@RequestParam(value = "title") String title) {
        RestaurantSearchResponse response = restaurantService.search(title);
        return ResponseEntity.ok(response);
    }
}
