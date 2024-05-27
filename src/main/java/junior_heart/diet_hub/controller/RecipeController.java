package junior_heart.diet_hub.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import junior_heart.diet_hub.controller.dto.RecipeFindRequest;
import junior_heart.diet_hub.controller.dto.RecipeRegisterRequest;
import junior_heart.diet_hub.service.RecipeService;
import junior_heart.diet_hub.service.dto.RecipeFindResponse;
import junior_heart.diet_hub.service.dto.RecipeRegisterResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Recipes", description = "레시")
@RestController
@RequestMapping("/api/restaurants/{restaurantId}/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @Operation(summary = "레시피 등록")
    @PostMapping
    public ResponseEntity<RecipeRegisterResponse> Register(@PathVariable Long restaurantId, @RequestBody RecipeRegisterRequest request) {
        RecipeRegisterResponse response = recipeService.register(request.recipeName(), request.recipeDetail(), restaurantId);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "레시피 조회")
    @GetMapping
    public ResponseEntity<RecipeFindResponse> findRecipe(@PathVariable Long restaurantId, @RequestBody RecipeFindRequest request) {
        RecipeFindResponse response = recipeService.findRecipe(request.recipeId());
        return ResponseEntity.ok(response);
    }
}