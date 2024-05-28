package junior_heart.diet_hub.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import junior_heart.diet_hub.service.RestaurantService;
import junior_heart.diet_hub.service.dto.RestaurantInfoResponse;
import junior_heart.diet_hub.service.dto.RestaurantSearchResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Operation(summary = "레스토랑 상세조회")
    @GetMapping("/{restaurantId}/info")
    public ResponseEntity<RestaurantInfoResponse> getInfo(@PathVariable Long restaurantId) {
        RestaurantInfoResponse response = restaurantService.findRestaurantInfo(restaurantId);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "레스토랑 검색")
    @GetMapping("/search")
    public ResponseEntity<RestaurantSearchResponses> search(@RequestParam(value = "title") String title) {
        RestaurantSearchResponses response = restaurantService.search(title);
        return ResponseEntity.ok(response);
    }
}
