package junior_heart.diet_hub.controller;

import junior_heart.diet_hub.controller.dto.RecipeSignRequest;
import junior_heart.diet_hub.service.RecipeService;
import junior_heart.diet_hub.service.dto.RecipeSignResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members/{memberId}/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public ResponseEntity<MemberSignResponse> Register(@RequestBody RecipeSignRequest request) {
        RecipeRegResponse response = recipeService.Register(request.recipename());
        return ResponseEntity.ok(response);
    }
}
