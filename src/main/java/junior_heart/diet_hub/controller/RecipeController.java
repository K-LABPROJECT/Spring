package junior_heart.diet_hub.controller;

import junior_heart.diet_hub.controller.dto.RecipeFindRequest;
import junior_heart.diet_hub.controller.dto.RecipeRegisterRequest;
import junior_heart.diet_hub.service.RecipeService;
import junior_heart.diet_hub.service.dto.RecipeFindResponse;
import junior_heart.diet_hub.service.dto.RecipeRegisterResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restaurants/{restaurantId}/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public ResponseEntity<RecipeRegisterResponse> Register(@RequestBody RecipeRegisterRequest request) {
        RecipeRegisterResponse response = recipeService.register(request.recipeName(), request.recipeDetail());
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<RecipeFindResponse> findRecipe(@RequestBody RecipeFindRequest request) {
        RecipeFindResponse response = recipeService.findRecipe(request.recipeId());
        return ResponseEntity.ok(response);
    }
}
